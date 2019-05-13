package edugate.demo.services;



import edugate.demo.model.Users;


import java.util.Collection;

public interface UserService {

    Users save(Users user);

    Boolean delete(int id);

    Users update(Users user);

    Users findById(int id);

    Users findByLogin(String username);

    Users findByEmail(String email);

    Collection<Users> findAll();
}
