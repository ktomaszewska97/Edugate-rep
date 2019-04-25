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
	
	
	
//    @Autowired
//    private SchoolRepository schoolRepository;
//	
//	@RequestMapping(value="/home")
//	public String home(String name) {
//
//		System.out.println("hi " +name);
//		
//		School school = new School("g", "h", "i");
//		
//		schoolRepository.save(school);
//		
//		return "home";
//	}
//	@RequestMapping(value="/dupa")
//	public String dupa() {
//		
//		System.out.println("hey");
//		return "dupa";
//	}
//	@PostMapping(value="/kutas")
//	public ModelAndView kutas(String name) {
//		
//		View view; 
//		ModelAndView mav = new ModelAndView();
//		System.out.println("halo");
//		mav.addObject("fullName", name);
//		mav.setViewName("response");
//		return mav;
//	}
//	@RequestMapping(value="/departament")
//	public String departament() {
//		
//		System.out.println("depo");
//		return "adddepartament";
//	}
}
