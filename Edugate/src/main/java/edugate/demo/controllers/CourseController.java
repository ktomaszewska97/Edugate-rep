package edugate.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edugate.demo.model.Comment;
import edugate.demo.model.Course;
import edugate.demo.model.CourseRealization;
import edugate.demo.model.File;
import edugate.demo.model.School;
import edugate.demo.model.UserProfile;
import edugate.demo.repositories.CommentRepository;
import edugate.demo.repositories.CourseRealizationRepository;
import edugate.demo.repositories.CourseRepository;
import edugate.demo.repositories.FileRepository;
import edugate.demo.repositories.UserProfileRepository;

@Controller
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	FileRepository fileRepository;
	
	@Autowired
	CourseRealizationRepository courseRealizationRepository;
	
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
	
	@PostMapping(value="/courseView")
	public ModelAndView showCourseView(int IDCourseRealization) {
		
		System.out.println("dupa");
	
		List<UserProfile> listOfUserProfiles = userProfileRepository.findAll();
		List<Comment> listOfComments = commentRepository.findAll();
		List<File> listOfFiles = fileRepository.findAll();
		
		CourseRealization currentCourseRealization = courseRealizationRepository.findById((long)IDCourseRealization).get();
		
		ModelAndView mv = new ModelAndView("courseview");
		mv.addObject("commentList", listOfComments);
		mv.addObject("userProfileList", listOfUserProfiles);
		mv.addObject("fileList", listOfFiles);
		mv.addObject("currentCourseRealization", currentCourseRealization);
	
		return mv;
	}
}
