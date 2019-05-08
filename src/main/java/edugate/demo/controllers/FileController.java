package edugate.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edugate.demo.model.File;
import edugate.demo.model.Course;
import edugate.demo.repositories.FileRepository;

@Controller
public class FileController {
	
	@Autowired
	FileRepository fileRepository;
	
	@RequestMapping(value="/filelistLink")
	public ModelAndView courseslistLink() {
	
		List<File> listOfFiles = fileRepository.findAll();
	
		ModelAndView mv = new ModelAndView("showfiles");
		mv.addObject("filesList", listOfFiles);
	
		return mv;
	}

}
