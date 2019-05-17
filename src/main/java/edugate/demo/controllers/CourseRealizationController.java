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

		ModelAndView mv = new ModelAndView("signupforacourse");
		
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
    
	@RequestMapping(value="/courseView")
	public ModelAndView showCourseView(Integer IDCourseRealization, HttpServletRequest request) {
		
		int currentCourseId;
		
		if(IDCourseRealization == null) {
			
			currentCourseId = Integer.parseInt(request.getParameter("currentCourseRealization"));
		}
		else {
			
			currentCourseId = IDCourseRealization;
		}
		
//		COMMENTS
		List<Comment> listOfComments = commentRepository.findByIdcourserealization(currentCourseId);
		
		Map<Comment, UserProfile> commentsAndUsers = new HashMap<>();
		
		for(Comment comment : listOfComments) {
			System.out.println(comment.getMessage());
			System.out.println(comment.getIduser());
			System.out.println(userProfileRepository.findByIduser(comment.getIduser()));
			commentsAndUsers.put(comment, userProfileRepository.findByIduser(comment.getIduser()).get(0));
		}
	
//		FILES
//		List<AssignFileToCourseRealization> filesAssigned = 
//				assignFileToCourseRealizationfileRepository.findByIdcourserealization(currentCourseId);
//		
//		List<File> listOfFiles = new ArrayList<>();
//		
//		for(AssignFileToCourseRealization fileAssigned : filesAssigned) {
//			
//			listOfFiles.add(fileRepository.findById(fileAssigned.getIdfile()).get());
//		}
		
//		COURSEREALIZATION ID
		CourseRealization currentCourseRealization = courseRealizationRepository.findById(currentCourseId).get();
		
//		ASSIGNED STUDENTS
		List<UserCourse> assignedUserCourseList = userCourseRepository.findByIdcourserealization(currentCourseId);
	
		Map<Users, UserProfile> usersAndProfiles = new HashMap<>();
		
		for(UserCourse userCourse : assignedUserCourseList) {
			
			Users user = usersRepository.findById(userCourse.getIduser()).get();
			usersAndProfiles.put(user, userProfileRepository.findByIduser(user.getIduser()).get(0));
		}
		
//		MODELANDVIEW
		ModelAndView mv = new ModelAndView("courseview");
		mv.addObject("lecturer", userProfileRepository.findByIduser(currentCourseRealization.getIdlecturer()).get(0));
		mv.addObject("users", usersAndProfiles);
		mv.addObject("comments", commentsAndUsers);
//		mv.addObject("fileList", listOfFiles);
		mv.addObject("currentCourseRealization", currentCourseRealization);
		mv.addObject("currentCourse", courseRepository.findById(currentCourseRealization.getIdcourse()).get());
	
		return mv;
	}
	
    @GetMapping(value="/addlecturerview")
	public ModelAndView addLecturerView(HttpServletRequest request) {
    	
//    	List<Users> lecturersList = usersRepository.findByAccounttype(1);
    	List<Users> lecturersList = usersRepository.findAll();
    	
		Map<Users, UserProfile> usersAndProfiles = new HashMap<>();
		
		for(Users lecturer : lecturersList) {
			
			usersAndProfiles.put(lecturer, userProfileRepository.findByIduser(lecturer.getIduser()).get(0));
		}
    	
		ModelAndView mv = new ModelAndView("addlecturer");
		mv.addObject("lecturers", usersAndProfiles);
		
		mv.addObject("confirmation", request.getParameter("confirmation"));
	
//		
//	Do usunięcia (zmiany)	
		List<CourseRealization> listOfCourseRealizations = courseRealizationRepository.findAll();
		
		Map<CourseRealization, String> courseRealizations = new HashMap<>();
		
		for(CourseRealization courseRealization : listOfCourseRealizations) {

			courseRealizations.put(courseRealization, courseRepository.findById((int)courseRealization.getIdcourse()).get().getName());
		}
		
		mv.addObject("courseRealizations", courseRealizations);
//
//		
		
		return mv;
	}
    
	@RequestMapping(value="/addlecturer")
	public ModelAndView addLecturer(int idLecturer, int idCourseRealization) {	
		
		CourseRealization currentCourseRealization = courseRealizationRepository.findById(idCourseRealization).get();
		
		currentCourseRealization.setIdlecturer(idLecturer);
		
		courseRealizationRepository.save(currentCourseRealization);
    	
    	ModelAndView mv = new ModelAndView("redirect:/addlecturerview");
    	mv.addObject("confirmation", "Przypisano prowadzącego!");
	
		return mv;
	}
}
