package edugate.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edugate.demo.model.School;
import edugate.demo.repositories.SchoolRepository;

@RestController
public class SchoolController {
	
    @Autowired
    private SchoolRepository schoolRepository;
    
    @PostMapping(value="/addSchool")
	public ModelAndView addSchool(String name, String about, String description) {
		
    	School newSchool = new School(name, about, description);
		schoolRepository.save(newSchool);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("newSchool", newSchool);
		mv.setViewName("addschool");
		
		return mv;
	}
}
