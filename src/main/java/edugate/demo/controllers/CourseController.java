package edugate.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edugate.demo.model.Course;
import edugate.demo.model.CourseRealization;
import edugate.demo.repositories.CourseRealizationRepository;
import edugate.demo.repositories.CourseRepository;

@Controller
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;	
	@Autowired
	CourseRealizationRepository courseRealizationRepository;
	
	@RequestMapping(value="/courseslistLink")
	public ModelAndView courseslistLink() {
	
		List<Course> listOfCourses = courseRepository.findAll();
		List<CourseRealization> listOfCourseRealizations = courseRealizationRepository.findAll();
	
		ModelAndView mv = new ModelAndView("showallcourses");
		mv.addObject("coursesList", listOfCourses);
		mv.addObject("courseRealizationsList", listOfCourseRealizations);
	
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
}
