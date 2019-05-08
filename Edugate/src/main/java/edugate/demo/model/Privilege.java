package edugate.demo.model;


import javax.persistence.*;

@Entity(name = "Privilege")
public class Privilege {

    @Id
    Integer IDPrivilege;

    @Column(nullable = false)
    String name;


}
