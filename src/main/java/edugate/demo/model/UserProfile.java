package edugate.demo.model;

import javax.persistence.*;

@Entity(name = "userprofile")
public class UserProfile {

    @Id
    @Column(name = "IDuserprofile")
    Integer IDUserProfile;
    @Column
    Integer iduser;
    @Column(name = "firstname")
    String firstName;
    @Column(name="lastname")
    String lastName;
    @Column
    String gender;

    public Integer getIDUserProfile() {
        return IDUserProfile;
    }

    public void setIDUserProfile(Integer IDUserProfile) {
        this.IDUserProfile = IDUserProfile;
    }


    public String getFirstName() {
        return firstName;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer idUser) {
        iduser = idUser;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Column
    String about;
}
