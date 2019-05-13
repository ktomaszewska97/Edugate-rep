package edugate.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edugate.demo.model.UserProfile;
import edugate.demo.model.Users;
import edugate.demo.repositories.UserProfileRepository;
import edugate.demo.repositories.UsersRepository;

@Controller
public class UserProfileController {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	UsersRepository usersRepository;
	
	@RequestMapping(value="/userprofileListLink")
	public ModelAndView userProfileListLink() {
	
		ModelAndView mv = new ModelAndView("showUserProfiles");
		mv.addObject("userProfilesList", userProfileRepository.findAll());
	
		return mv;
	}
	
	@PostMapping(value="/userProfileView")
	public ModelAndView userProfileView (int idUser) {
		
		ModelAndView mv = new ModelAndView("userprofileview"); //ZMIENIĆ NA WŁAŚCIWA NAZWE PLIKU .JSP
		
		mv.addObject("currentUse", usersRepository.findById(idUser).get());
		mv.addObject("currentUserProfile", userProfileRepository.findByIduser(idUser).get(0));
		
		return mv;
		
	}

}
