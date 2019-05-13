package edugate.demo.model;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
        //@UniqueConstraint(columnNames = "iduser")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer iduser;

    @Column
    Integer IDSchool;

    @Column(nullable = false)
    String login;

    @Column(nullable = false)
    String password;

    @Transient
    private String passwordConfirm;

    @Column(nullable = false)
    String email;

    @Column
    Date dateregistered;

    @Column
    Integer accountstatus;

    @Column
    Integer accounttype;

    @Column
    Double overallrating;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Date getdateregistered() {
        return dateregistered;
    }

    public void setdateregistered(Date dateregistered) {
        this.dateregistered = dateregistered;
    }

    public Integer getaccountstatus() {
        return accountstatus;
    }

    public void setaccountstatus(Integer accountstatus) {
        this.accountstatus = accountstatus;
    }

    public Integer getaccounttype() {
        return accounttype;
    }

    public void setaccounttype(Integer accounttype) {
        this.accounttype = accounttype;
    }

    public Double getoverallrating() {
        return overallrating;
    }

    public void setoverallrating(Double overallrating) {
        this.overallrating = overallrating;
    }

    public Integer getiduser() {
        return iduser;
    }

    public Integer getIDSchool() {
        return IDSchool;
    }

    public void setIDSchool(Integer IDSchool) {
        IDSchool = IDSchool;
    }

    public void setiduser(Integer iduser) {
        this.iduser = iduser;
    }


}
