package edugate.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value="/index")
	public String kutas() {
	
		System.out.println("index");
		return "index";
	}
	
	@RequestMapping(value="/registerLink")
	public String registrationLink() {
	
		System.out.println("registrationLink");
		return "signup";
	}
	
	@RequestMapping(value="/loginLink")
	public String loginLink() {
	
		System.out.println("loginLink");
		return "login";
	}
}
