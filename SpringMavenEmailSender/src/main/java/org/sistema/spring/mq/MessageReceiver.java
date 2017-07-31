package org.sistema.spring.mq;

import java.util.Random;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.roberto.spring.email.Emailer;
import org.springframework.jms.core.JmsTemplate;

public class MessageReceiver extends Thread{

	private Random random;
	private String queueName;
	private Emailer emailer;
	private JmsTemplate jmsTemplate;
	
	public MessageReceiver(String name){
		super(name);
		random = new Random();
	}
	
	public void run(){
		Order order = null;
		int counter = 0;
		while(true){
			try{
				sleep(random.nextInt(5));
				order = receiveMessage();
				
				if(null != order){
					counter++;
					System.out.println("[" + counter + "] Order rcv: " + order.toString());
					sendEmailWithOrder(order, counter);
				}else{
					System.out.println("Order is null ");
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	private void sendEmailWithOrder(Order order, int counter){
		emailer.setSubject("Order recv: ");
		emailer.setText(order.toString());
		System.out.println("Sending email...");
		
		if(emailer.send()){
			System.out.println("[" + counter + "] Email sent");
		}else{
			System.err.println("[" + counter + "] There was a problem sending the email");
		}
	}
	
	private Order receiveMessage(){
		try{
			ObjectMessage receivedMessage = (ObjectMessage) jmsTemplate.receive(queueName);
			Order order = (Order) receivedMessage.getObject();
			return order;
		}catch(JMSException jmsException){
			System.err.println("Error reading msg: " + jmsException.getMessage());
		}
		
		return null;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public Emailer getEmailer() {
		return emailer;
	}

	public void setEmailer(Emailer emailer) {
		this.emailer = emailer;
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
