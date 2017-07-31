
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import models.GreetingEngine;

public class MainLogExample {
	
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beansLogExample.xml");
		
		GreetingEngine greetingEngine = (GreetingEngine) context.getBean("greetingEngine");
		
		Logger logger = Logger.getLogger(Main.class);
		logger.setLevel(Level.ALL);
		
		logger.info("Info message");
		logger.trace("Simple trace");
		logger.debug("Debug message");
		logger.error("Error message");
		logger.fatal("Fatal error");
		
		System.out.println(greetingEngine.greetMe());
	}
}
