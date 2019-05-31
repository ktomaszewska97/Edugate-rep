package edugate.demo.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import edugate.demo.model.*;
import edugate.demo.repositories.*;
import edugate.demo.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	SchoolRepository schoolRepository;
	@Autowired
	UserCourseRepository userCourseRealizationRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	CourseRealizationRepository courseRealizationRepository;
	@Autowired
	SecurityService securityService;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	FieldOfStudyRepository fieldOfStudyRepository;
	
	@RequestMapping(value="/userprofileListLink")
	public ModelAndView userProfileListLink() {
	
		ModelAndView mv = new ModelAndView("showUserProfiles");
		mv.addObject("userProfilesList", userProfileRepository.findAll());
	
		return mv;
	}


	@RequestMapping(value="/profileLink")
	public ModelAndView userProfileView (Principal principal) {

		ModelAndView mv = new ModelAndView("profile");
		int idUser = usersRepository.findByLogin(principal.getName()).getIduser();
		mv.addObject("currentUserLogin",  principal.getName());
		mv.addObject("currentUserId", idUser);
		mv.addObject("currentUserEmail", usersRepository.findByLogin(principal.getName()).getEmail());
		mv.addObject("currentUserName", userProfileRepository.findByIduser(idUser).getFirstName());
		mv.addObject("currentUserLastname", userProfileRepository.findByIduser(idUser).getLastName());

//		mv.addObject("currentUserSchool", schoolRepository.findByIDSchool(usersRepository.findByLogin(principal.getName()).getIDSchool()).getName());
//		mv.addObject("currentUserSchoolID", usersRepository.findByLogin(principal.getName()).getIDSchool());

		Integer idSchool =usersRepository.findByLogin(principal.getName()).getIDSchool();
		if(idSchool==null)
			mv.addObject("currentUserSchool","brak");
		else
//		School s = schoolRepository.findByIDSchool(idSchool);
//		String schoolName= s.getName();
			mv.addObject("currentUserSchool", schoolRepository.findByIDSchool(idSchool).getName());



		List<Department> departments = new ArrayList<Department>();

		List<UserCourse> userCourseRealization= userCourseRealizationRepository.findByIduser(idUser);
		List<String> courseRealizationsName = new ArrayList<String>();
		if(!userCourseRealization.isEmpty()){
			for (UserCourse ucr: userCourseRealization
			) {

				CourseRealization cr= courseRealizationRepository.findByIdcourserealization(ucr.getIdcourserealization());
				Course c=courseRepository.findByIDCourse(cr.getIdcourse());
				String courseName=c.getName();
				courseRealizationsName.add(courseName);

				Department d = departmentRepository.findByIDDepartament(fieldOfStudyRepository.findByIDFieldOfStudy(courseRepository.findByIDCourse(courseRealizationRepository.findByIdcourserealization(ucr.getIdcourserealization()).getIdcourse()).getIDFieldOfStudy()).getIDDepartment());
				if(!departments.contains(d))
					departments.add(d);
			}
		}

		mv.addObject("currentUserCourses", courseRealizationsName);
		mv.addObject("currentUserDepartment", departments);


		return mv;

	}
	
    @PostMapping("/createuserprofile")
    public String addUserProfile(Principal principal, String firstName, String lastName, String gender, String about) {
        
    	userProfileRepository.save(new UserProfile(usersRepository.findByLogin(principal.getName()).getIduser(), firstName, lastName, gender, about));
    	
        return "redirect:/home";
    }
	
//	@RequestMapping(value="/profileLink")
//	public ModelAndView userProfileView (Principal principal) {
//
//		ModelAndView mv = new ModelAndView("profile");
//
//		Users currentUser = usersRepository.findByLogin(principal.getName());
//
//		int currentUserId = currentUser.getIduser();
//
//		UserProfile currentUserProfile = userProfileRepository.findAllByIduser(currentUserId).get(0);
//
//		mv.addObject("currentUser", currentUser);
//		mv.addObject("currentUserProfile", currentUserProfile);
//
//		List<UserCourse> userCourses = userCourseRepository.findAllByIduser(currentUserId);
//
//		Map<Course, CourseRealization> courses = new HashMap<>();
//
//		CourseRealization temp = null;
//
//		for(UserCourse userCourse : userCourses) {
//
//			temp = courseRealizationRepository.findById(userCourse.getIdcourserealization()).get();
//
//			courses.put(courseRepository.findById(temp.getIdcourse()).get(), temp);
//		}
//
//		mv.addObject("courses", courses);
//
//		return mv;
//
//	}

}
