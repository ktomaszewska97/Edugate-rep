package edugate.demo.model;




import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity(name = "location")
public class Location {


    @Id
    @Column(name = "IDLocation")
    Integer iDLocation;
    @Column(name = "IDSchool")
    Integer IDSchool;

    @Column
    Integer number;
    @Column
    String street;
    @Column
    String city;
    @Column
    String zipcode;
    @Column
    String state;

    public Integer getiDLocation() {
        return iDLocation;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getIDSchool() {
        return IDSchool;
    }

    public void setIDSchool(Integer IDSchool) {
        this.IDSchool = IDSchool;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZupcode() {
        return zipcode;
    }

    public void setZupcode(String zupcode) {
        this.zipcode = zupcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
