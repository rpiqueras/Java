package FootballExampleAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import AddressExample.Person;

public class MainFootballExample {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beansFootballExample.xml");
		
		Match match = (Match) context.getBean("match");
		System.out.println("Match data: " + match.toString());
	}
}
