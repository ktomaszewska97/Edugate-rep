package edugate.demo.model;

import javax.persistence.*;

@Entity
@Table(name="administrator")
public class Administrator {
    @Id
    @Column(nullable = false,name="IDAdministrator")
    Integer IDAdministrator;


    //Ew zmienić na users gdy powstanie

    @Column(name = "IDUser")
    Integer IDUser;

    public Integer getIDAdministrator() {
        return IDAdministrator;
    }

    public void setIDAdministrator(Integer IDAdministrator) {
        this.IDAdministrator = IDAdministrator;
    }

    public Integer getIDUser() {
        return IDUser;
    }

    public void setIDUser(Integer IDUser) {
        IDUser = IDUser;
    }
}
