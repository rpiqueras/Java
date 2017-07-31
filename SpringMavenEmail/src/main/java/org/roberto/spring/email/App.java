package org.roberto.spring.email;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	static Properties prop;
	static ApplicationContext context;
	
	private static void loadProperties(){
		prop = new Properties();
	
		try{
			prop.load(new FileInputStream("src/main/resources/emailer.properties"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beansEmailExample.xml");
		loadProperties();
		Emailer emailer = (Emailer) context.getBean("emailer");
		System.out.println("Sending email: ");
		emailer.setFrom(prop.getProperty("email.username"));
		emailer.setTo("PUT_TO_VALUE@anyother.com");
		emailer.setSubject("Testing Spring email, version 4");
		emailer.setText("Testing email");
		emailer.addAttachment(context.getResource("6666_1.jpg"));
		
		if(emailer.send()){
			System.out.println("Ok, email sent! " + emailer.toString());
		}else{
			System.err.println("Error, something went wrong");
		}
	}

}
