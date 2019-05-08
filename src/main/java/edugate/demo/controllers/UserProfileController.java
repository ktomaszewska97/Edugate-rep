package edugate.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edugate.demo.model.UserProfile;
import edugate.demo.repositories.UserProfileRepository;

@Controller
public class UserProfileController {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@RequestMapping(value="/userprofileListLink")
	public ModelAndView courseslistLink() {
	
		List<UserProfile> listOfProfiles = userProfileRepository.findAll();
	
		ModelAndView mv = new ModelAndView("showUserProfiles");
		mv.addObject("userProfilesList", listOfProfiles);
	
		return mv;
	}

}
