package edugate.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import edugate.demo.model.CourseRealization;
import edugate.demo.model.UserCourse;
import edugate.demo.repositories.CourseRealizationRepository;
import edugate.demo.repositories.CourseRepository;
import edugate.demo.repositories.UserCourseRepository;

@Controller
public class CourseRealizationController {
	
	@Autowired
	CourseRealizationRepository courseRealizationRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	UserCourseRepository userCourseRepository;

	@RequestMapping(value="/signupforacourseLink")
	public ModelAndView homeLink(HttpServletRequest request) {

		System.out.println("signupforacourseLink");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("signupforacourse");
		
		List<CourseRealization> listOfCourseRealizations = courseRealizationRepository.findAll();
		
		Map<CourseRealization, String> courseRealizations = new HashMap<>();
		
		for(CourseRealization courseRealization : listOfCourseRealizations) {

			courseRealizations.put(courseRealization, courseRepository.findById((int)courseRealization.getIdcourse()).get().getName());
		}
		
		mv.addObject("courseRealizations", courseRealizations);
		mv.addObject("confirmation", request.getParameter("confirmation"));
		
		return mv;
	}
	
    @PostMapping(value="/signupforacourse")
	public ModelAndView signUpForACourse(int IDUser, int IDCourseRealization) {
    	
    	userCourseRepository.save(new UserCourse(IDUser, IDCourseRealization));
    	
    	ModelAndView mv = new ModelAndView("redirect:/signupforacourseLink");
    	mv.addObject("confirmation", "Dodano do grupy!");
    	
    	return mv;
	}
}
