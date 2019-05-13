package edugate.demo.controllers;

import edugate.demo.model.Users;
import edugate.demo.repositories.CourseRealizationRepository;
import edugate.demo.repositories.CourseRepository;
import edugate.demo.repositories.UsersRepository;
import edugate.demo.security.SecurityService;
import edugate.demo.services.UserService;
import edugate.demo.services.UserValidator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private UsersRepository usersRepository;
    
	@Autowired
	CourseRealizationRepository courseRealizationRepository;

	@Autowired
	CourseRepository courseRepository;
	
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new Users());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") Users userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getLogin(), userForm.getPasswordConfirm());

        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/home"})
    public String welcome(Model model) {
        return "home";
    }
    
}