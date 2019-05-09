#Edugate_rep
Aplikacja mająca służyć do wymiany opinii na temat kursów oraz prowadzących, oraz do dzielenia się wiedzą/materiałami.
___
##Install
1. Git clone repository.
2. Create a database called "edugate".
3. Start MySql server, start Tomcat server.
___
##Backend

Aplikacja od strony backendu używa technologii Spring MVC. Projekt Edugate zawiera 8 paczek plików: config, controller, exception, model, payload, repository, security oraz util.
###Config
Config zawiera klasy odpowiedzialne za zapewnienie właściwej konfiguracji systemu w celu właściwej współpracy z bazą danych i frontenedem oraz ustawienia autoryzacji logowania użytkownika.
###Controller
Controller zawiera klasy odpowiedzialne za obsługę zapytań z frontendu. Stanowi API do łączenia się z bazą danych; przy użyciu metod CRUD komunikuje się z bazą. Każde żądanie z frontendu charakteryzuje konkretny ciąg URL, który informuje o akcji jaka ma zostać wykonana. Jest on przechwytywany przy pomocy adnotacji @RequestMapping lub adnotacji dla konkretnych metod HTTP (@GetMappping, @PostMapping, itd.) i kierowany do odpowiedniej klasy-kontrolera, gdzie wykonywana jest właściwa metoda.
###Model
Model zawiera klasy będące zmapowanymi odpowiednikami encji w bazie danych. Umożliwiają konwersję danych z bazy (rekordów) na konkretne, odpowiadające im, obiekty w javie.
###Repository
Repository zawiera interfejsy używane przez Spring do obsługi operacji CRUD w bazie danych. Definiowane za pomocą adnotacji @Repository oraz rozszerzające interfejs JpaRepository domyślnie pozwalają na realizacje podstawowych i szablonowych operacji CRUD, można jednak definiować nagłówki własnych metod w celu wykonywania skonkretyzowanych operacji czytania, zapisu, usuwania i edycji w bazie.
###Security
Security zawiera klasy obsługujące poprawną autoryzację użytkownika.

##Controllers

###CommentController
public ModelAndView commentslistLink() {
}

Zwraca listę wszystkich komentarzy.

###CourseController
public ModelAndView courseslistLink() {
}

Zwraca listę wszystkich kursów.
	
public ModelAndView addCourse(String name, int semester, int level, String note, String about) {
}
Dodaje kurs.
	
public ModelAndView showCourseView(int IDCourseRealization) {

		List<UserProfile> listOfUserProfiles = userProfileRepository.findAll();
		List<Comment> listOfComments = commentRepository.findAll();
		List<File> listOfFiles = fileRepository.findAll();
		
		CourseRealization currentCourseRealization = courseRealizationRepository.findById((long)IDCourseRealization).get();
		Course currentCourseRealizationCourse = courseRepository.findById((int)currentCourseRealization.getIdcourse()).get();
		String currentCourseName = currentCourseRealizationCourse.getName();
		
		ModelAndView mv = new ModelAndView("courseview");
		mv.addObject("commentList", listOfComments);
		mv.addObject("userProfileList", listOfUserProfiles);
		mv.addObject("fileList", listOfFiles);
		mv.addObject("currentCourseRealization", currentCourseRealization);
		mv.addObject("currentCourseName", currentCourseName);
}
Zwraca listę komentarzy, profili użytkowników, pliki oraz nazwę dla wybranej realizacji kursu.

###CourseRealizationController

public ModelAndView signUpForACourse(int IDUser, int IDCourseRealization) {
}
Umożliwa zapisanie się na kurs.

###FileController
public ModelAndView fileslistLink() {
}
Zwraca listę kursów.

###GlobalController
public Users getLoginUsers() {
}
Zwraca zalogowanego użytkownika.

###LoginController
public String registrationLink() {
}
Przekierowuje na stronę "Home" po zalogowaniu.

###SchoolController
public ModelAndView addSchool(String name, String about, String description) {
}
Umożliwia dodanie szkoły do bazy danych.

###SignupController
public class SignUpController {
}
Przekierowuje na stronę "Index" po rejestracji.

###UserController
public String registration(Model model) {
}
Dodaje nowego użytkownika do bazy danych.


public String registration(@ModelAttribute("userForm") Users userForm, BindingResult bindingResult) {
}
Sprawdza poprawność wprowadzonych danych przy rejestracji.

public String login(Model model, String error, String logout) {
}
Zwraca infromację o błędnym/pomyślnym zalogowaniu.

___
##Frontend

###Features:

##Logowanie/wylogowywanie
##Rejestracja
##Przeglądanie kursów
##Przeglądanie Uczelni
##Przeglądanie wydziałów
##Dodawanie uczelni
##Dodawanie wydziałów
##Dodawanie kursów
##Dodawanie prowadzącego do kursu
##Dodawanie studenta do kursu
##Wizytówka kursu




