package edugate.demo.controllers;

import edugate.demo.model.Users;
import edugate.demo.repositories.UserProfileRepository;
import edugate.demo.repositories.UsersRepository;
import edugate.demo.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserProfileController {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	SecurityService securityService;
	
	@RequestMapping(value="/userprofileListLink")
	public ModelAndView userProfileListLink() {
	
		ModelAndView mv = new ModelAndView("showUserProfiles");
		mv.addObject("userProfilesList", userProfileRepository.findAll());

	
		return mv;
	}
	
	@PostMapping(value="/userProfileView")
	public ModelAndView userProfileView (int idUser) {
		
		ModelAndView mv = new ModelAndView("profile"); //ZMIENIĆ NA WŁAŚCIWA NAZWE PLIKU .JSP
		
		mv.addObject("currentUse", usersRepository.findById(idUser).get());
		mv.addObject("currentUserProfile", userProfileRepository.findByIduser(idUser).get(0));
		
		return mv;
		
	}
	@GetMapping(value="/userProfileView")
	public ModelAndView userProfileView () {

		ModelAndView mv = new ModelAndView("profile"); //ZMIENIĆ NA WŁAŚCIWA NAZWE PLIKU .JSP
		String username = securityService.findLoggedInUsername();
		Users currentUser = usersRepository.findByLogin(username);
		mv.addObject("currentUserId", currentUser);
		//mv.addObject("currentUserId", securityService.findLoggedInUserId());

		return mv;

	}

}
