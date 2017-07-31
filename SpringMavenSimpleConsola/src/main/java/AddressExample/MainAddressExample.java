package AddressExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAddressExample {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beansAddressExample.xml");
		
		Person person = (Person) context.getBean("person");
		System.out.println(person);
		
		Person person2 = (Person) context.getBean("person2");
		System.out.println(person2);
	}

}
