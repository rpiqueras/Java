package org.sistema.spring.mq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beansEmailSenderExample.xml");
		MessageSender messageSender = (MessageSender) context.getBean("messageSender");
		MessageReceiver messageReceiver = (MessageReceiver) context.getBean("messageReiver");
		
		messageSender.start();
		messageReceiver.start();
	}
}
