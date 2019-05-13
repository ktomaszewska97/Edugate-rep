package edugate.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import edugate.demo.model.AssignFileToCourseRealization;
import edugate.demo.model.Comment;
import edugate.demo.model.Course;
import edugate.demo.model.CourseRealization;
import edugate.demo.model.File;
import edugate.demo.model.UserCourse;
import edugate.demo.model.UserProfile;
import edugate.demo.model.Users;
import edugate.demo.repositories.AssignFileToCourseRealizationRepository;
import edugate.demo.repositories.CommentRepository;
import edugate.demo.repositories.CourseRealizationRepository;
import edugate.demo.repositories.CourseRepository;
import edugate.demo.repositories.FileRepository;
import edugate.demo.repositories.UserCourseRepository;
import edugate.demo.repositories.UserProfileRepository;
import edugate.demo.repositories.UsersRepository;

@Controller
public class CourseRealizationController {
	
	@Autowired
	CourseRealizationRepository courseRealizationRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	UserCourseRepository userCourseRepository;
	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	FileRepository fileRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	AssignFileToCourseRealizationRepository assignFileToCourseRealizationfileRepository;

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
    
	@PostMapping(value="/courseView")
	public ModelAndView showCourseView(int IDCourseRealization) {	
		
		List<Comment> listOfComments = commentRepository.findByIdcourserealization(IDCourseRealization);
		
		Map<Comment, UserProfile> commentsAndUsers = new HashMap<>();
		
		for(Comment comment : listOfComments) {
			
			commentsAndUsers.put(comment, userProfileRepository.findByIduser(comment.getIduser()).get(0));
		}
		
//		List<AssignFileToCourseRealization> filesAssigned = 
//				assignFileToCourseRealizationfileRepository.findByIdcourserealization(IDCourseRealization);
//		
//		List<File> listOfFiles = new ArrayList<>();
//		
//		for(AssignFileToCourseRealization fileAssigned : filesAssigned) {
//			
//			listOfFiles.add(fileRepository.findById(fileAssigned.getIdfile()).get());
//		}
		
		CourseRealization currentCourseRealization = courseRealizationRepository.findById(IDCourseRealization).get();
		
		ModelAndView mv = new ModelAndView("courseview");
		mv.addObject("comments", commentsAndUsers);
//		mv.addObject("fileList", listOfFiles);
		mv.addObject("currentCourseRealization", currentCourseRealization);
		mv.addObject("currentCourse", courseRepository.findById(currentCourseRealization.getIdcourse()).get());
	
		return mv;
	}
	
    @GetMapping(value="/addlecturerview")
	public ModelAndView addLecturerView() {
    	
    	List<Users> lecturersList = usersRepository.findAll();
		
		Map<Users, UserProfile> usersAndProfiles = new HashMap<>();
		
//		for(Users lecturer : lecturersList) {
//			
//			usersAndProfiles.put(lecturer, userProfileRepository.findByIduser(lecturer.getIduser()).get(0));
//		}
    	
		ModelAndView mv = new ModelAndView("addlecturer");
//		mv.addObject("lecturers", usersAndProfiles);
		mv.addObject("lecturers", lecturersList);
		
		
//	Do usunięcia (zmiany)	
		List<CourseRealization> listOfCourseRealizations = courseRealizationRepository.findAll();
		
		Map<CourseRealization, String> courseRealizations = new HashMap<>();
		
		for(CourseRealization courseRealization : listOfCourseRealizations) {

			courseRealizations.put(courseRealization, courseRepository.findById((int)courseRealization.getIdcourse()).get().getName());
		}
		
		mv.addObject("courseRealizations", courseRealizations);
//	
		return mv;
	}
    
	@RequestMapping(value="/addlecturer")
	public ModelAndView addLecturer(int IDUser) {
	
		List<Course> listOfCourses = courseRepository.findAll();
					
		ModelAndView mv = new ModelAndView("showcourses");
		mv.addObject("coursesList", listOfCourses);
	
		return mv;
	}
    
}
