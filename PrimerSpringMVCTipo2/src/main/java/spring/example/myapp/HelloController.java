package spring.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	private final String HELLO_PAGE = "hello";
	
	public HelloController(){
		System.out.println("BEAN instanciated");
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHelloPage(Model model){
		System.out.println("Inside sayHelloPage");
		model.addAttribute("greet", "Hello world, welcome to my app");
		
		return HELLO_PAGE;
	}
}
