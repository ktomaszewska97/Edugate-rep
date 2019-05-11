package edugate.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home")
	public String homeLink() {
	
		System.out.println("homePage");
		return "home";
	}
	
	@RequestMapping(value="/profileLink")
	public String profileLink() {
	
		System.out.println("profileLink");
		return "profile";
	}
	
	@RequestMapping(value="/departmentLink")
	public String addDepartmentLink() {
	
		System.out.println("departmentLink");
		return "adddepartment";
	}
	
	@RequestMapping(value="/schoolLink")
	public String addSchoolLink() {
	
		System.out.println("schoolLink");
		return "addschool";
	}
	
	@RequestMapping(value="/courseLink")
	public String addCourseLink() {
	
		System.out.println("courseLink");
		return "addcourse";
	}
	
	@RequestMapping(value="/addlecturerview")
	public String addLecturerLink() {
	
		System.out.println("courseLink");
		return "addlecturer";
	}
}
