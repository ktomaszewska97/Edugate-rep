//package edugate.demo.controllers;
//
//import edugate.demo.model.*;
//import edugate.demo.repositories.*;
//import edugate.demo.security.SecurityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SelectionbarController {
//
//    @Autowired
//    UserProfileRepository userProfileRepository;
//    @Autowired
//    UsersRepository usersRepository;
//    @Autowired
//    SchoolRepository schoolRepository;
//    @Autowired
//    UserCourseRealizationRepository userCourseRealizationRepository;
//    @Autowired
//    CourseRepository courseRepository;
//    @Autowired
//    FieldOfStudyRepository fieldOfStudyRepository;
//    @Autowired
//    DepartmentRepository departmentRepository;
//    @Autowired
//    CourseRealizationRepository courseRealizationRepository;
//    @Autowired
//    SecurityService securityService;
//
//
//    @RequestMapping(value="/")//nie wiem co tu bedzie*******************************************************
//    public ModelAndView selectionBar (Principal principal) {
//
//        ModelAndView mv;
//        mv = new ModelAndView("home");
//        int idUser = usersRepository.findByLogin(principal.getName()).getiduser();
//
//        Integer idSchool =usersRepository.findByLogin(principal.getName()).getIDSchool();
//        if(idSchool==null)
//            mv.addObject("currentUserSchool","brak");
//        else
//            mv.addObject("currentUserSchool", schoolRepository.findByIDSchool(idSchool).getName());
//
//        List<UserCourseRealization> userCourseRealization= userCourseRealizationRepository.findAllByIduser(idUser);
//        List<Course> course = new ArrayList<Course>();
//        List<CourseRealization> courseRealizations = new ArrayList<CourseRealization>();
//        List<FieldOfStudy> fieldOfStudy = new ArrayList<FieldOfStudy>();
//        List<Department> departments = new ArrayList<Department>();
//        if(!userCourseRealization.isEmpty()){
//            for (UserCourseRealization ucr: userCourseRealization
//            ) {
//                CourseRealization cr= courseRealizationRepository.findByIdcourserealization(ucr.getIdcourse());
//                Course c =courseRepository.findByIDCourse(ucr.getIdcourse());
//                FieldOfStudy fos=fieldOfStudyRepository.findByIDFieldOfStudy(c.getIDFieldOfStudy());
//                Department d = departmentRepository.findByIDDepartament(fos.getIDDepartment());
//
//                course.add(c);
//                courseRealizations.add(cr);
//                fieldOfStudy.add(fos);
//                departments.add(d);
//            }
//        }
//        mv.addObject("currentUserCourseRealizations", courseRealizations);
//        mv.addObject("currentUserCourses", course);
//        mv.addObject("currentUserFieldOfStudy", fieldOfStudy);
//        mv.addObject("currentUserDepartment", departments);
//
//
//        return mv;
//
//    }
//}
