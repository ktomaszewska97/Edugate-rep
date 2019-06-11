package edugate.demo.controllers;


import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;


import edugate.demo.model.AssignFileToCourseRealization;
import edugate.demo.repositories.AssignFileToCourseRealizationRepository;
import edugate.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edugate.demo.model.File;
//import java.io.File;
import edugate.demo.repositories.FileRepository;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class FileController {

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	AssignFileToCourseRealizationRepository assignFileToCourseRealizationRepository;
	@Autowired
	FileRepository fileRepository;

	@RequestMapping(value="/filelistLink")
	public ModelAndView courseslistLink() {

		List<File> listOfFiles = fileRepository.findAll();

		ModelAndView mv = new ModelAndView("showfiles");
		mv.addObject("filesList", listOfFiles);

		return mv;
	}

	@RequestMapping(value = "/download/{name}", method = GET)
	@ResponseBody
	public ResponseEntity<Object> downloadFile(@PathVariable("name") String name) throws IOException {
		String filename = fileRepository.findByTitle(name).getTitle();
		java.io.File file = ResourceUtils.getFile("classpath:files/"+filename);
		//new java.io.File(ClassPath.getClassPath()+ "/" + filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object>
				responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
				MediaType.parseMediaType("application/txt")).body(resource);
		System.out.println("Wysyłam " +"classpath:"+filename);
		return responseEntity;
	}


	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ModelAndView submit(@RequestParam("file") MultipartFile file, ModelMap modelMap, Principal principal,int idCourseRealization) {
		modelMap.addAttribute("file", file);
		System.out.println("Uploaded");
		ModelAndView mv = new ModelAndView("redirect:/courseView");
		try {

			File uploaded = new File();
			uploaded.setLink("/download/"+file.getOriginalFilename());
			uploaded.setCategory("Dokument");
			uploaded.setTitle(file.getOriginalFilename());
			uploaded.setIduser(usersRepository.findByLogin(principal.getName()).getIduser());
			fileRepository.save(uploaded);
			File toAssign = fileRepository.findByLink(uploaded.getLink());
			AssignFileToCourseRealization assign  = new AssignFileToCourseRealization();
			assign.setIdcourse(idCourseRealization);
			assign.setIdfile(toAssign.getIdfile());
			assignFileToCourseRealizationRepository.save(assign);
			System.out.println("Uploaded file");
			java.io.File transferFile = new java.io.File("C:\\Users\\DominikBabinski\\Desktop\\Edugate_rep\\target\\classes\\files\\" + file.getOriginalFilename());
			file.transferTo(transferFile);

		} catch (Exception e) {System.out.println(e.getMessage());	}
		mv.addObject("currentCourseRealization", idCourseRealization);
		return mv;
	}

}



