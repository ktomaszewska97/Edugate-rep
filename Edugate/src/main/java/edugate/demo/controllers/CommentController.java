package edugate.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edugate.demo.model.Comment;
import edugate.demo.model.Course;
import edugate.demo.repositories.CommentRepository;

@Controller
public class CommentController {
	
	@Autowired
	CommentRepository commentRepository;
	
	@RequestMapping(value="/commentlistLink")
	public ModelAndView courseslistLink() {
	
		List<Comment> listOfComments = commentRepository.findAll();
	
		ModelAndView mv = new ModelAndView("showcomments");
		mv.addObject("commentsList", listOfComments);
	
		return mv;
	}

}
