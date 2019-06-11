package edugate.demo.controllers;

import edugate.demo.model.*;
import edugate.demo.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CourseRealizationController {
	
	@Autowired
	CourseRealizationRepository courseRealizationRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	UserCourseRepository userCourseRepository;
	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	FileRepository fileRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	CourseEvaluationRepository courseEvaluationRepository;
	@Autowired
	AssignFileToCourseRealizationRepository assignFileToCourseRealizationfileRepository;
	@Autowired
	AssignCourseRealizationRepository assignCourseRealizationRepository;

	@RequestMapping(value="/signupforacourseLink")
	public ModelAndView homeLink(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("signupforacourse");
		
		List<CourseRealization> listOfCourseRealizations = courseRealizationRepository.findAll();
		
		Map<CourseRealization, String> courseRealizations = new HashMap<>();
		
		for(CourseRealization courseRealization : listOfCourseRealizations) {

			courseRealizations.put(courseRealization, courseRepository.findById((int)courseRealization.getIdcourse()).get().getName());
		}
		
		mv.addObject("courseRealizations", courseRealizations);
		mv.addObject("confirmation", request.getParameter("confirmation"));
		
		return mv;
	}
	
    @PostMapping(value="/signupforacourse")
	public ModelAndView signUpForACourse(Principal principal, int IDCourseRealization) {
    	
    	userCourseRepository.save(new UserCourse(usersRepository.findByLogin(principal.getName()).getIduser(), IDCourseRealization));
    	
    	ModelAndView mv = new ModelAndView("redirect:/signupforacourseLink");
    	mv.addObject("confirmation", "Dodano do grupy!");
    	
    	return mv;
	}
    
	@RequestMapping(value="/courseView")
	public ModelAndView showCourseView(Integer IDCourseRealization, HttpServletRequest request, Principal principal) {
		
		int currentCourseRealizationId;
		
		if(IDCourseRealization == null) {
			
			currentCourseRealizationId = Integer.parseInt(request.getParameter("currentCourseRealization"));
		}
		else {
			
			currentCourseRealizationId = IDCourseRealization;
		}		
		
//		COMMENTS
		List<Comment> listOfComments = commentRepository.findByIdcourserealization(currentCourseRealizationId);
		
		Map<Comment, UserProfile> commentsAndUsers = new HashMap<>();
		
		for(Comment comment : listOfComments) {
			
			commentsAndUsers.put(comment, userProfileRepository.findByIduser(comment.getIduser()));
		}

//		FILES
//		List<AssignFileToCourseRealization> filesAssigned =
//				assignFileToCourseRealizationfileRepository.findByIdcourserealization(currentCourseId);
//
//		List<File> listOfFiles = new ArrayList<>();
//
//		for(AssignFileToCourseRealization fileAssigned : filesAssigned) {
//
//			listOfFiles.add(fileRepository.findById(fileAssigned.getIdfile()).get());
//		}

//		COURSEREALIZATION ID
		CourseRealization currentCourseRealization = courseRealizationRepository.findById(currentCourseRealizationId).get();

//		ASSIGNED STUDENTS
		List<UserCourse> assignedUserCourseList = userCourseRepository.findByIdcourserealization(currentCourseRealizationId);

		Map<Users, UserProfile> usersAndProfiles = new HashMap<>();

		for(UserCourse userCourse : assignedUserCourseList) {

			Users user = usersRepository.findById(userCourse.getIduser()).get();
			usersAndProfiles.put(user, userProfileRepository.findByIduser(user.getIduser()));
		}
		
//		SREDNIA
		List <CourseEvaluation> evaluations = courseEvaluationRepository.findByIdcourse(currentCourseRealizationId);
		int evaluationsListSize = evaluations.size();
		boolean hasEvaluated = false;
		double mean = 0;
		
		if(evaluationsListSize > 0) {
	
			hasEvaluated = courseEvaluationRepository.existsByIduserAndIdcourse(usersRepository.findByLogin(principal.getName()).getIduser(),
					currentCourseRealizationId);
		
			for(CourseEvaluation evaluation : evaluations) {
			
				mean += evaluation.getRating();
			}
			
			mean /= evaluationsListSize;
		}

		//PRIVILEGES
		int idUser = usersRepository.findByLogin(principal.getName()).getIduser();
		List<AssignCourseRealization> privilegesList = assignCourseRealizationRepository.findAllByIduserAndIdcourserealization(idUser,currentCourseRealization.getIdcourserealization());
		boolean saveFiles = false;
		boolean readFiles = false;
		boolean modifyCourse = false;
		if(!privilegesList.isEmpty()){
			for (AssignCourseRealization acr: privilegesList)
			{
				if(acr.getIdprivilege()==1) saveFiles=true;
				else{
					if(acr.getIdprivilege()==2) readFiles=true;
					else {
						if (acr.getIdprivilege() == 3) modifyCourse = true;

					}
				}

			}
		}
		
		
//		MODELANDVIEW
		ModelAndView mv = new ModelAndView("courseview");
		mv.addObject("lecturer", userProfileRepository.findAllByIduser(currentCourseRealization.getIdlecturer()).get(0));
		mv.addObject("users", usersAndProfiles);
		mv.addObject("comments", commentsAndUsers);
//		mv.addObject("fileList", listOfFiles);
		mv.addObject("currentCourseRealization", currentCourseRealization);
		mv.addObject("currentCourse", courseRepository.findById(currentCourseRealization.getIdcourse()).get());
		mv.addObject("mean", mean);
		mv.addObject("hasEvaluated", hasEvaluated);

		mv.addObject("saveFiles", saveFiles);
		mv.addObject("readFiles", readFiles);
		mv.addObject("modifyCourse", modifyCourse);
		mv.addObject("idUser", idUser);

		return mv;
	}

	@RequestMapping(value = "/saveprivilege/{idUser}/{idPrivilege}/{idCourserealization}", method = RequestMethod.POST)
	@ResponseBody
	public void addPrivilege(@PathVariable("idUser") Integer idUser, @PathVariable("idPrivilege") Integer idPrivilege, @PathVariable("idCourserealization") Integer idCourserealization) {

//		AssignCourseRealization acr = new AssignCourseRealization(idUser, idPrivilege, idCourserealization);
//		assignCourseRealizationRepository.save(acr);


		AssignCourseRealization acr2= new AssignCourseRealization();
		acr2.setIduser(idUser);
		acr2.setIdprivilege(idPrivilege);
		acr2.setIdcourserealization(idCourserealization);
		assignCourseRealizationRepository.save(acr2);
	}

    @GetMapping(value="/addlecturerview")
	public ModelAndView addLecturerView(HttpServletRequest request) {

//    	List<Users> lecturersList = usersRepository.findByAccounttype(1);
    	List<Users> lecturersList = usersRepository.findAll();

		Map<Users, UserProfile> usersAndProfiles = new HashMap<>();

		for(Users lecturer : lecturersList) {

			usersAndProfiles.put(lecturer, userProfileRepository.findAllByIduser(lecturer.getIduser()).get(0));
		}

		ModelAndView mv = new ModelAndView("addlecturer");
		mv.addObject("lecturers", usersAndProfiles);

		mv.addObject("confirmation", request.getParameter("confirmation"));

//
//	Do usunięcia (zmiany)
		List<CourseRealization> listOfCourseRealizations = courseRealizationRepository.findAll();

		Map<CourseRealization, String> courseRealizations = new HashMap<>();

		for(CourseRealization courseRealization : listOfCourseRealizations) {

			courseRealizations.put(courseRealization, courseRepository.findById((int)courseRealization.getIdcourse()).get().getName());
		}

		mv.addObject("courseRealizations", courseRealizations);
//
//
		
		return mv;
	}
    
	@RequestMapping(value="/addlecturer")
	public ModelAndView addLecturer(int idLecturer, int idCourseRealization) {	
		
		CourseRealization currentCourseRealization = courseRealizationRepository.findById(idCourseRealization).get();
		
		currentCourseRealization.setIdlecturer(idLecturer);
		
		courseRealizationRepository.save(currentCourseRealization);
		
		
    	
    	ModelAndView mv = new ModelAndView("redirect:/addlecturerview");
    	mv.addObject("confirmation", "Przypisano prowadzącego!");
	
		return mv;
	}
	
	@RequestMapping(value="/editcourseview")
	public ModelAndView editCourseView(int idCourseRealization, Principal principal) {
		
		CourseRealization currentCourseRealization = courseRealizationRepository.findById(idCourseRealization).get();
		Course currentCourse = courseRepository.findById(currentCourseRealization.getIdcourse()).get();
		Users currentLecturer = usersRepository.findById(currentCourseRealization.getIdlecturer()).get();
		
//    	List<Users> lecturersList = usersRepository.findByAccounttype(1);
    	List<Users> lecturersList = usersRepository.findAll();

		Map<Users, UserProfile> lecturersProfiles = new HashMap<>();

		for(Users lecturer : lecturersList) {

			lecturersProfiles.put(lecturer, userProfileRepository.findByIduser(lecturer.getIduser()));
		}
		
		List<UserCourse> assignedUserCourseList = userCourseRepository.findByIdcourserealization(idCourseRealization);

		Map<Users, UserProfile>studentsProfiles = new HashMap<>();

		for(UserCourse userCourse : assignedUserCourseList) {

			Users user = usersRepository.findById(userCourse.getIduser()).get();
			studentsProfiles.put(user, userProfileRepository.findAllByIduser(user.getIduser()).get(0));
		}

		//
//		int idUser = usersRepository.findByLogin(principal.getName()).getIduser();
//		boolean privilege = false;
//		List<AssignCourseRealization> courseRealizationList =assignCourseRealizationRepository.findAll();
//		for(int i=0; i<courseRealizationList.size();i++){
//			if(courseRealizationList.get(i).getIduser()==idUser && courseRealizationList.get(i).getIdprivilege()==3 && courseRealizationList.get(i).getIdcourserealization()==idCourseRealization){
//				privilege=true;
//			}
//		}

ModelAndView mv;
//		if(privilege==true) {
			 mv = new ModelAndView("editcourseview");

			mv.addObject("currentCourseRealization", currentCourseRealization);
			mv.addObject("currentCourse", currentCourse);
			mv.addObject("lecturer", currentLecturer);
			mv.addObject("lecturers", lecturersProfiles);
			mv.addObject("students", studentsProfiles);
//		}else{
//			 mv = new ModelAndView("redirect:/home");
//
//		}
		
		return mv;
	}
	
	@RequestMapping(value="/addcourseevaluation")
	public ModelAndView addCourseEvaluation(int courseEvaluation, int idCourseRealization, Principal principal) {
		
		courseEvaluationRepository.save(new CourseEvaluation(usersRepository.findByLogin(principal.getName()).getIduser(), 
				idCourseRealization, courseEvaluation));
		
		ModelAndView mv = new ModelAndView("redirect:/courseView");
		mv.addObject("currentCourseRealization", idCourseRealization);
		
		return mv;
	}
	
	@RequestMapping(value="/editcourse")
	public ModelAndView editCourse(int idCourseRealization, String lecturer, String note) {
		
		CourseRealization currentCourseRealization = courseRealizationRepository.findById(idCourseRealization).get(); 
		
		int idLecturer = Integer.parseInt(lecturer.replaceAll("[^0-9]+", ""));
		
		currentCourseRealization.setIdlecturer(idLecturer);
		currentCourseRealization.setNote(note);
		
		courseRealizationRepository.save(currentCourseRealization);
		
		AssignCourseRealization acr= new AssignCourseRealization();
        acr.setIduser(idLecturer);
        acr.setIdprivilege(1);
        acr.setIdcourserealization(idCourseRealization);
        assignCourseRealizationRepository.save(acr);

        AssignCourseRealization acr1= new AssignCourseRealization();
        acr1.setIduser(idLecturer);
        acr1.setIdprivilege(2);
        acr1.setIdcourserealization(idCourseRealization);
        assignCourseRealizationRepository.save(acr1);

        AssignCourseRealization acr2= new AssignCourseRealization();
        acr2.setIduser(idLecturer);
        acr2.setIdprivilege(3);
        acr2.setIdcourserealization(idCourseRealization);
        assignCourseRealizationRepository.save(acr2);
		
		ModelAndView mv = new ModelAndView("redirect:/courseView");
		mv.addObject("currentCourseRealization", idCourseRealization);
		
		return mv;
	}
}
