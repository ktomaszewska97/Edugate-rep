package edugate.demo.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edugate.demo.model.Comment;
import edugate.demo.model.Course;
import edugate.demo.repositories.CommentRepository;
import edugate.demo.repositories.UsersRepository;

@Controller
public class CommentController {
	
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	UsersRepository usersRepository;
	
	@RequestMapping(value="/commentlistLink")
	public ModelAndView courseslistLink() {
	
		List<Comment> listOfComments = commentRepository.findAll();
	
		ModelAndView mv = new ModelAndView("showcomments");
		mv.addObject("commentsList", listOfComments);
	
		return mv;
	}
	
	@PostMapping(value="/addcomment")
	public ModelAndView addComment(int idCourseRealization, String message, Principal principal) {
		
    	Comment comment = new Comment(usersRepository.findByLogin(principal.getName()).getIduser(), idCourseRealization, message, new java.util.Date());
    	
		commentRepository.save(comment);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("currentCourseRealization", idCourseRealization);
		mv.setViewName("redirect:/courseView");
		
		return mv;
	}
}
