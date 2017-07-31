

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import models.Race;


public class MainAspectsExample {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beansAspectsExample.xml");
		
		Race race = (Race) context.getBean("race");
		System.out.println(race.toString());
		race.run();
		System.out.println(race.showResult());
	}
}
