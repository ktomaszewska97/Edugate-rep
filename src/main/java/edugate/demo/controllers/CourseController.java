package edugate.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edugate.demo.model.Course;
import edugate.demo.model.School;
import edugate.demo.repositories.CourseRepository;

@Controller
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@RequestMapping(value="/courseslistLink")
	public ModelAndView courseslistLink() {
	
		List<Course> listOfCourses = courseRepository.findAll();
	
		ModelAndView mv = new ModelAndView("showcourses");
		mv.addObject("coursesList", listOfCourses);
	
		return mv;
	}
	
    @PostMapping(value="/addCourse")
	public ModelAndView addSchool(String name, int semester, int level, String note, String about) {
		
    	Course newCourse = new Course(name, semester, level, about);
		courseRepository.save(newCourse);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("newCourse", newCourse);
		mv.setViewName("addcourse");
		
		return mv;
	}
    
//	@RequestMapping(value="/courseLink")
//	public String addCourseLink() {
//	
//		System.out.println("addcourse");
//		return "addcourse";
//	}
}
