package org.sistema.spring.mq;

import java.util.Random;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSender extends Thread{

	private Random random;
	private JmsTemplate jmsTemplate;
	private String queueName;
	
	public MessageSender(String name){
		super(name);
		random = new Random();
	}
	
	public void run(){
		String[] products = {"BigMac", "Chips", "Coke"};
		Order order = null;
		int counter = 0;
		while(true){
			try{
				sleep(random.nextInt(15000));
				counter++;
				order = new Order(products[random.nextInt(3)], random.nextInt(5));
				System.out.println("[" + counter +"] Sending order: " + order.toString());
				sendMessage(order);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	private void sendMessage(final Order order){
		jmsTemplate.send(queueName, new MessageCreator(){
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(order);
			}
		});
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
}
