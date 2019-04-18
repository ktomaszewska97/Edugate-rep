CREATE TABLE Users (
  IDUser         int(5) NOT NULL AUTO_INCREMENT, 
  IDSchool       int(3) NOT NULL, 
  Login          varchar(10), 
  Password       varchar(30), 
  Email          varchar(50), 
  DateRegistered date, 
  AccountStatus  binary(1), 
  AccountType    int(10), 
  OverallRating  real, 
  PRIMARY KEY (IDUser));
CREATE TABLE Privilege (
  IDPrivilege int(5) NOT NULL AUTO_INCREMENT, 
  Name        varchar(50), 
  PRIMARY KEY (IDPrivilege));
CREATE TABLE Comment (
  IDComment           int(5) NOT NULL AUTO_INCREMENT, 
  IDUser              int(5) NOT NULL, 
  IDCourseRealization int(6) NOT NULL, 
  Message             varchar(255), 
  IsVisible           tinyint(1), 
  PRIMARY KEY (IDComment));
CREATE TABLE UserProfile (
  IDUserProfile int(5) NOT NULL AUTO_INCREMENT, 
  IDUser        int(5) NOT NULL, 
  FirstName     varchar(50), 
  LastName      varchar(50), 
  Gender        varchar(1), 
  About         varchar(255), 
  PRIMARY KEY (IDUserProfile));
CREATE TABLE CourseRealization (
  IDCourseRealization int(6) NOT NULL AUTO_INCREMENT, 
  IDUser              int(5) NOT NULL, 
  IDCourse            int(5) NOT NULL, 
  GroupFunction       int(11), 
  Year                int(11), 
  Note                varchar(255), 
  About               varchar(255), 
  CourseStatus        int(11), 
  PRIMARY KEY (IDCourseRealization));
CREATE TABLE School (
  IDSchool    int(3) NOT NULL AUTO_INCREMENT, 
  Name        varchar(50), 
  Description varchar(255), 
  About       varchar(255), 
  PRIMARY KEY (IDSchool));
CREATE TABLE Location (
  IDLocation int(3) NOT NULL AUTO_INCREMENT, 
  IDSchool   int(3) NOT NULL, 
  Number     int(5), 
  Street     varchar(50), 
  City       varchar(50), 
  ZipCode    varchar(6), 
  State      varchar(30), 
  PRIMARY KEY (IDLocation));
CREATE TABLE Favourite (
  IDFavourite int(6) NOT NULL AUTO_INCREMENT, 
  IDUser      int(5) NOT NULL, 
  URL         varchar(100), 
  Name        varchar(50), 
  PRIMARY KEY (IDFavourite));
CREATE TABLE Department (
  IDDepartment int(3) NOT NULL AUTO_INCREMENT, 
  IDSchool     int(3) NOT NULL, 
  Name         varchar(50), 
  About        varchar(255), 
  PRIMARY KEY (IDDepartment));
CREATE TABLE CourseEvaluation (
  IDCourseEvaluation int(5) NOT NULL AUTO_INCREMENT, 
  IDUser             int(5) NOT NULL, 
  IDCourse           int(6) NOT NULL, 
  Rating             int(1), 
  Description        varchar(255), 
  PRIMARY KEY (IDCourseEvaluation));
CREATE TABLE `File` (
  IDFIle   int(3) NOT NULL AUTO_INCREMENT, 
  IDUser   int(5) NOT NULL, 
  Category varchar(20), 
  Title    varchar(50), 
  Link     varchar(255), 
  PRIMARY KEY (IDFIle));
CREATE TABLE Course (
  IDCourse       int(5) NOT NULL AUTO_INCREMENT, 
  IDFieldOfStudy int(11) NOT NULL, 
  Semester       int(1), 
  Level          int(1), 
  Name           varchar(50), 
  About          varchar(255), 
  PRIMARY KEY (IDCourse));
CREATE TABLE FieldOfStudy (
  IDFieldOfStudy int(11) NOT NULL AUTO_INCREMENT, 
  IDDepartment   int(3) NOT NULL, 
  Name           varchar(50), 
  About          varchar(255), 
  PRIMARY KEY (IDFieldOfStudy));
CREATE TABLE Administrator (
  IDAdministrator int(11) NOT NULL AUTO_INCREMENT, 
  IDUser          int(5) NOT NULL, 
  PRIMARY KEY (IDAdministrator));
CREATE TABLE AsssignSchool (
  IDAssignSchool int(11) NOT NULL AUTO_INCREMENT, 
  IDPrivilege    int(5) NOT NULL, 
  IDUser         int(5) NOT NULL, 
  IDSchool       int(3) NOT NULL, 
  PRIMARY KEY (IDAssignSchool));
CREATE TABLE AssignDepartment (
  IDAssignDepartment int(11) NOT NULL AUTO_INCREMENT, 
  IDPrivilege        int(5) NOT NULL, 
  IDUser             int(5) NOT NULL, 
  IDDepartment      int(3) NOT NULL, 
  PRIMARY KEY (IDAssignDepartment));
CREATE TABLE AssignFieldOfStudy (
  IDAssignFieldOfStudy int(11) NOT NULL AUTO_INCREMENT, 
  IDPrivilege          int(5) NOT NULL, 
  IDUser               int(5) NOT NULL, 
  IDFieldOfStudy       int(11) NOT NULL, 
  PRIMARY KEY (IDAssignFieldOfStudy));
CREATE TABLE AssignCourseRealization (
  IDAssignCourseRealization int(11) NOT NULL AUTO_INCREMENT, 
  IDPrivilege               int(5) NOT NULL, 
  IDUser                    int(5) NOT NULL, 
  IDCourseRealization       int(6) NOT NULL, 
  PRIMARY KEY (IDAssignCourseRealization));
CREATE TABLE AssignFileToFieldOfStudy (
  IDAssignFileToFieldOfStudy int(11) NOT NULL AUTO_INCREMENT, 
  IDFIle                     int(3) NOT NULL, 
  IDFieldOfStudy             int(11) NOT NULL, 
  isPublic                   tinyint(1), 
  PRIMARY KEY (IDAssignFileToFieldOfStudy));
CREATE TABLE AssignFileToDepartment (
  IDAssignFileToDepartment int(11) NOT NULL AUTO_INCREMENT, 
  IDDepartment             int(3) NOT NULL, 
  IDFIle                   int(3) NOT NULL, 
  isPublic                 tinyint(1), 
  PRIMARY KEY (IDAssignFileToDepartment));
CREATE TABLE AssignFileToSchool (
  IDAssignFileToSchool int(11) NOT NULL AUTO_INCREMENT, 
  IDSchool             int(3) NOT NULL, 
  IDFIle               int(3) NOT NULL, 
  isPublic             tinyint(1), 
  PRIMARY KEY (IDAssignFileToSchool));
CREATE TABLE AssignFileToCourseRealization (
  IDAssignFileToCourseRealization int(11) NOT NULL AUTO_INCREMENT, 
  IDFIle                          int(3) NOT NULL, 
  IDCourse                        int(6) NOT NULL, 
  isPublic                        tinyint(1), 
  PRIMARY KEY (IDAssignFileToCourseRealization));
CREATE TABLE UserCourseRealization (
  IDUserCourseRealization int(11) NOT NULL AUTO_INCREMENT, 
  IDUser                  int(5) NOT NULL, 
  IDCourse                int(6) NOT NULL, 
  IsConfirm               tinyint(1), 
  PRIMARY KEY (IDUserCourseRealization));
CREATE TABLE FiileComment (
  IDFileComment int(11) NOT NULL AUTO_INCREMENT, 
  IDUser        int(5) NOT NULL, 
  IDFIle        int(3) NOT NULL, 
  Message       varchar(255), 
  IsVisible     tinyint(1), 
  PRIMARY KEY (IDFileComment));
ALTER TABLE Comment ADD CONSTRAINT FKComment111483 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE UserProfile ADD CONSTRAINT FKUserProfil383028 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE CourseRealization ADD CONSTRAINT FKCourseReal48903 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE Location ADD CONSTRAINT FKLocation991578 FOREIGN KEY (IDSchool) REFERENCES School (IDSchool);
ALTER TABLE Comment ADD CONSTRAINT FKComment116000 FOREIGN KEY (IDCourseRealization) REFERENCES CourseRealization (IDCourseRealization);
ALTER TABLE Favourite ADD CONSTRAINT FKFavourite563452 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE Department ADD CONSTRAINT FKDepartment29458 FOREIGN KEY (IDSchool) REFERENCES School (IDSchool);
ALTER TABLE `File` ADD CONSTRAINT FKFile995379 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE CourseEvaluation ADD CONSTRAINT FKCourseEval431289 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE FieldOfStudy ADD CONSTRAINT FKFieldOfStu33079 FOREIGN KEY (IDDepartment) REFERENCES Department (IDDepartment);
ALTER TABLE Course ADD CONSTRAINT FKCourse195101 FOREIGN KEY (IDFieldOfStudy) REFERENCES FieldOfStudy (IDFieldOfStudy);
ALTER TABLE CourseRealization ADD CONSTRAINT FKCourseReal750547 FOREIGN KEY (IDCourse) REFERENCES Course (IDCourse);
ALTER TABLE Administrator ADD CONSTRAINT FKAdministra537493 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE Users ADD CONSTRAINT FKUsers316323 FOREIGN KEY (IDSchool) REFERENCES School (IDSchool);
ALTER TABLE AsssignSchool ADD CONSTRAINT FKAsssignSch410230 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE AsssignSchool ADD CONSTRAINT FKAsssignSch925602 FOREIGN KEY (IDSchool) REFERENCES School (IDSchool);
ALTER TABLE AsssignSchool ADD CONSTRAINT FKAsssignSch403381 FOREIGN KEY (IDPrivilege) REFERENCES Privilege (IDPrivilege);
ALTER TABLE AssignDepartment ADD CONSTRAINT FKAssignDepa478410 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE AssignDepartment ADD CONSTRAINT FKAssignDepa573159 FOREIGN KEY (IDDepartment) REFERENCES Department (IDDepartment);
ALTER TABLE AssignDepartment ADD CONSTRAINT FKAssignDepa471561 FOREIGN KEY (IDPrivilege) REFERENCES Privilege (IDPrivilege);
ALTER TABLE AssignFieldOfStudy ADD CONSTRAINT FKAssignFiel330663 FOREIGN KEY (IDFieldOfStudy) REFERENCES FieldOfStudy (IDFieldOfStudy);
ALTER TABLE AssignFieldOfStudy ADD CONSTRAINT FKAssignFiel212804 FOREIGN KEY (IDPrivilege) REFERENCES Privilege (IDPrivilege);
ALTER TABLE AssignFieldOfStudy ADD CONSTRAINT FKAssignFiel205955 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE AssignCourseRealization ADD CONSTRAINT FKAssignCour711685 FOREIGN KEY (IDPrivilege) REFERENCES Privilege (IDPrivilege);
ALTER TABLE AssignCourseRealization ADD CONSTRAINT FKAssignCour266754 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE AssignCourseRealization ADD CONSTRAINT FKAssignCour960728 FOREIGN KEY (IDCourseRealization) REFERENCES CourseRealization (IDCourseRealization);
ALTER TABLE AssignFileToFieldOfStudy ADD CONSTRAINT FKAssignFile58827 FOREIGN KEY (IDFIle) REFERENCES `File` (IDFIle);
ALTER TABLE AssignFileToFieldOfStudy ADD CONSTRAINT FKAssignFile6102 FOREIGN KEY (IDFieldOfStudy) REFERENCES FieldOfStudy (IDFieldOfStudy);
ALTER TABLE AssignFileToDepartment ADD CONSTRAINT FKAssignFile842535 FOREIGN KEY (IDDepartment) REFERENCES Department (IDDepartment);
ALTER TABLE AssignFileToDepartment ADD CONSTRAINT FKAssignFile135478 FOREIGN KEY (IDFIle) REFERENCES `File` (IDFIle);
ALTER TABLE AssignFileToSchool ADD CONSTRAINT FKAssignFile985746 FOREIGN KEY (IDSchool) REFERENCES School (IDSchool);
ALTER TABLE AssignFileToSchool ADD CONSTRAINT FKAssignFile690756 FOREIGN KEY (IDFIle) REFERENCES `File` (IDFIle);
ALTER TABLE AssignFileToCourseRealization ADD CONSTRAINT FKAssignFile54780 FOREIGN KEY (IDFIle) REFERENCES `File` (IDFIle);
ALTER TABLE AssignFileToCourseRealization ADD CONSTRAINT FKAssignFile776393 FOREIGN KEY (IDCourse) REFERENCES CourseRealization (IDCourseRealization);
ALTER TABLE CourseEvaluation ADD CONSTRAINT FKCourseEval899312 FOREIGN KEY (IDCourse) REFERENCES CourseRealization (IDCourseRealization);
ALTER TABLE UserCourseRealization ADD CONSTRAINT FKUserCourse449733 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE UserCourseRealization ADD CONSTRAINT FKUserCourse82243 FOREIGN KEY (IDCourse) REFERENCES CourseRealization (IDCourseRealization);
ALTER TABLE FiileComment ADD CONSTRAINT FKFiileComme38362 FOREIGN KEY (IDUser) REFERENCES Users (IDUser);
ALTER TABLE FiileComment ADD CONSTRAINT FKFiileComme848724 FOREIGN KEY (IDFIle) REFERENCES `File` (IDFIle);
