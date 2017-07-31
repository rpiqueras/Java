package FightExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainFightExample {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beansFightExample.xml");
		Combat combat = (Combat) context.getBean("combat");
		combat.combat();
		System.out.println("And the winner is: " + combat.outcome().getName());
	}

}
