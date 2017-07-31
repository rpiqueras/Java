package spring.example.myapp.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	private final String HELLO_PAGE = "hello";
	
	public HelloController(){
		System.out.println("BEAN instanciated");
	}
	
	@RequestMapping("/hello")
	public String sayHelloPage(Map<String, Object> model){
		System.out.println("Inside sayHelloPage");
		model.put("greet", "Hello world, welcome to my app");
		
		return HELLO_PAGE;
	}
}
