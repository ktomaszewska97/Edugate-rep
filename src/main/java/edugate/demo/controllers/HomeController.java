package edugate.demo.controllers;

import edugate.demo.model.*;
import edugate.demo.repositories.*;
import edugate.demo.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	UserCourseRealizationRepository userCourseRealizationRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	FieldOfStudyRepository fieldOfStudyRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	CourseRealizationRepository courseRealizationRepository;
	@Autowired
	SecurityService securityService;

	@RequestMapping(value="/home")
	public ModelAndView selectionBar (Principal principal) {

		ModelAndView mv;
		mv = new ModelAndView("home");
		int idUser = usersRepository.findByLogin(principal.getName()).getIduser();

		Integer idSchool =usersRepository.findByLogin(principal.getName()).getIDSchool();
		if(idSchool==null)
			mv.addObject("currentUserSchool","brak");
		else
			mv.addObject("currentUserSchool", schoolRepository.findByIDSchool(idSchool));

		List<UserCourseRealization> userCourseRealization= userCourseRealizationRepository.findAllByIduser(idUser);
		List<Course> course = new ArrayList<Course>();
		List<CourseRealization> courseRealizations = new ArrayList<CourseRealization>();
		List<FieldOfStudy> fieldOfStudy = new ArrayList<FieldOfStudy>();
		List<Department> departments = new ArrayList<Department>();
		if(!userCourseRealization.isEmpty()){
			for (UserCourseRealization ucr: userCourseRealization
			) {
				CourseRealization cr= courseRealizationRepository.findByIdcourserealization(ucr.getIdcourse());
				Course c =courseRepository.findByIDCourse(cr.getIdcourse());
				FieldOfStudy fos=fieldOfStudyRepository.findByIDFieldOfStudy(c.getIDFieldOfStudy());
				Department d = departmentRepository.findByIDDepartament(fos.getIDDepartment());

				if(!course.contains(c))
					course.add(c);
				if(!courseRealizations.contains(cr))
					courseRealizations.add(cr);
				if(!fieldOfStudy.contains((fos)))
					fieldOfStudy.add(fos);
				if(!departments.contains(d))
					departments.add(d);
			}
		}
		mv.addObject("currentUserCourseRealizations", courseRealizations);
		mv.addObject("currentUserCourses", course);
		mv.addObject("currentUserFieldOfStudy", fieldOfStudy);
		mv.addObject("currentUserDepartment", departments);


		return mv;

	}


	@RequestMapping(value = "/home/{school}/{departament}/{field}/{course}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getHarm(@PathVariable("school") Integer school, @PathVariable("departament") Integer departament, @PathVariable("field") Integer field, @PathVariable("course") Integer course ) {


		if (school == -1) {
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}
		else{
			if (departament == -1) {
				return new ResponseEntity<Object>(schoolRepository.findByIDSchool(school).getAboute(),HttpStatus.OK);
			}
			else
			if(field == -1){
				return new ResponseEntity<Object>(departmentRepository.findByIDDepartament(departament).getAbout(),HttpStatus.OK);
			}
			else
			if (course == -1){
				return  new ResponseEntity<Object>(fieldOfStudyRepository.findByIDFieldOfStudy(field).getAbout(),HttpStatus.OK);
			}
			else
				return new ResponseEntity<Object>(courseRepository.findByIDCourse(course).getAbout(), HttpStatus.OK);
		}

	}



	@RequestMapping(value="/departmentLink")
	public String addDepartmentLink() {
	
		System.out.println("departmentLink");
		return "adddepartment";
	}
	
	@RequestMapping(value="/schoolLink")
	public String addSchoolLink() {
	
		System.out.println("schoolLink");
		return "addschool";
	}
	
	@RequestMapping(value="/courseLink")
	public String addCourseLink() {
	
		System.out.println("courseLink");
		return "addcourse";
	}
}
