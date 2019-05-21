package edugate.demo.controllers;

import edugate.demo.model.*;
import edugate.demo.repositories.*;
import edugate.demo.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;

@Controller
public class UserProfileController {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	UserCourseRealizationRepository userCourseRealizationRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	CourseRealizationRepository courseRealizationRepository;
	@Autowired
	SecurityService securityService;
	
	@RequestMapping(value="/userprofileListLink")
	public ModelAndView userProfileListLink() {
	
		ModelAndView mv = new ModelAndView("showUserProfiles");
		mv.addObject("userProfilesList", userProfileRepository.findAll());
		return mv;
	}


	@RequestMapping(value="/profileLink")
	public ModelAndView userProfileView (Principal principal) {

		ModelAndView mv = new ModelAndView("profile");
		int idUser = usersRepository.findByLogin(principal.getName()).getiduser();
		mv.addObject("currentUserLogin",  principal.getName());
		mv.addObject("currentUserId", idUser);
		mv.addObject("currentUserEmail", usersRepository.findByLogin(principal.getName()).getEmail());
		mv.addObject("currentUserName", userProfileRepository.findByIduser(idUser).getFirstName());
		mv.addObject("currentUserLastname", userProfileRepository.findByIduser(idUser).getLastName());

//		mv.addObject("currentUserSchool", schoolRepository.findByIDSchool(usersRepository.findByLogin(principal.getName()).getIDSchool()).getName());
//		mv.addObject("currentUserSchoolID", usersRepository.findByLogin(principal.getName()).getIDSchool());

		Integer idSchool =usersRepository.findByLogin(principal.getName()).getIDSchool();
		if(idSchool==null)
			mv.addObject("currentUserSchool","brak");
		else
//		School s = schoolRepository.findByIDSchool(idSchool);
//		String schoolName= s.getName();
		mv.addObject("currentUserSchool", schoolRepository.findByIDSchool(idSchool).getName());




		List<UserCourseRealization> userCourseRealization= userCourseRealizationRepository.findAllByIduser(idUser);
		List<String> courseRealizationsName = new ArrayList<String>();
		if(!userCourseRealization.isEmpty()){
			for (UserCourseRealization ucr: userCourseRealization
				 ) {

				CourseRealization cr= courseRealizationRepository.findByIdcourserealization(ucr.getIdcourse());
				Course c=courseRepository.findByIDCourse(cr.getIdcourse());
				String courseName=c.getName();
				courseRealizationsName.add(courseName);
			}
		}

		mv.addObject("currentUserCourses", courseRealizationsName);


		return mv;

	}

/*
	@GetMapping(value="/userProfileView")
	public ModelAndView userProfileView (Principal principal) {

		ModelAndView mv = new ModelAndView("profile");
		mv.addObject("currentUserName",  principal.getName());
		mv.addObject("currentUserId", usersRepository.findByLogin(principal.getName()).getiduser());

		return mv;

	}*/


}
