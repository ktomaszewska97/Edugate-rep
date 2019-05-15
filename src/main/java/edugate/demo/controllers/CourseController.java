package edugate.demo.controllers;

import edugate.demo.model.*;
import edugate.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
	
	@RequestMapping(value="/coursesStudentsListLink")
	public ModelAndView coursesStudentsListLink() {
	
		List<Course> listOfCourses = courseRepository.findAll();
	
		ModelAndView mv = new ModelAndView("showcoursesstudents");
		mv.addObject("coursesStudentsList", listOfCourses);
	
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

		List<UserProfile> listOfUserProfiles = userProfileRepository.findAll();
		List<Comment> listOfComments = commentRepository.findAll();
		List<File> listOfFiles = fileRepository.findAll();
		
		CourseRealization currentCourseRealization = courseRealizationRepository.findById((int)IDCourseRealization).get();
		Course currentCourseRealizationCourse = courseRepository.findById((int)currentCourseRealization.getIdcourse()).get();
		String currentCourseName = currentCourseRealizationCourse.getName();
		
		ModelAndView mv = new ModelAndView("courseview");
		mv.addObject("commentList", listOfComments);
		mv.addObject("userProfileList", listOfUserProfiles);
		mv.addObject("fileList", listOfFiles);
		mv.addObject("currentCourseRealization", currentCourseRealization);
		mv.addObject("currentCourseName", currentCourseName);
	
		return mv;
	}
}
