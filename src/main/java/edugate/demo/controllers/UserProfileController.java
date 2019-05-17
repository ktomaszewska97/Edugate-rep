package edugate.demo.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edugate.demo.model.Course;
import edugate.demo.model.CourseRealization;
import edugate.demo.model.UserCourse;
import edugate.demo.model.UserProfile;
import edugate.demo.model.Users;
import edugate.demo.repositories.CourseRealizationRepository;
import edugate.demo.repositories.CourseRepository;
import edugate.demo.repositories.UserCourseRepository;
import edugate.demo.repositories.UserProfileRepository;
import edugate.demo.repositories.UsersRepository;

@Controller
public class UserProfileController {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	UserCourseRepository userCourseRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	CourseRealizationRepository courseRealizationRepository;
	
	@RequestMapping(value="/userprofileListLink")
	public ModelAndView userProfileListLink() {
	
		ModelAndView mv = new ModelAndView("showUserProfiles");
		mv.addObject("userProfilesList", userProfileRepository.findAll());
	
		return mv;
	}
	
	@RequestMapping(value="/profileLink")
	public ModelAndView userProfileView (Principal principal) {
		
		ModelAndView mv = new ModelAndView("profile");
		
		Users currentUser = usersRepository.findByLogin(principal.getName());
		
		int currentUserId = currentUser.getIduser();
		
		UserProfile currentUserProfile = userProfileRepository.findByIduser(currentUserId).get(0);
		
		mv.addObject("currentUser", currentUser);
		mv.addObject("currentUserProfile", currentUserProfile);
		
		List<UserCourse> userCourses = userCourseRepository.findByIduser(currentUserId);
		
		Map<Course, CourseRealization> courses = new HashMap<>();
		
		CourseRealization temp = null;
		
		for(UserCourse userCourse : userCourses) {
			
			temp = courseRealizationRepository.findById(userCourse.getIdcourserealization()).get();
			
			courses.put(courseRepository.findById(temp.getIdcourse()).get(), temp);
		}
		
		mv.addObject("courses", courses);
		
		return mv;
		
	}

}
