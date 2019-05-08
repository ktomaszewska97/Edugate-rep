package edugate.demo.services.impl;

import edugate.demo.model.Users;
import edugate.demo.repositories.UsersRepository;
import edugate.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private edugate.demo.repositories.UsersRepository UsersRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Users save(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return UsersRepository.save(users);
    }

    @Override
    public Boolean delete(int id) {
        if (UsersRepository.existsById((long)id)) {
            UsersRepository.deleteById((long)id);
            return true;
        }
        return false;
    }

    @Override
    public Users update(Users users) {
        return UsersRepository.save(users);
    }

    @Override
    public Users findById(int id) {
        return UsersRepository.findById((long)id).get();
    }

    @Override
    public Users findByLogin(String usersname) {
        return UsersRepository.findByLogin(usersname);
    }

    @Override
    public Users findByEmail(String email) {
        return UsersRepository.findByEmail(email);
    }

    @Override
    public Collection<Users> findAll() {
        Iterable<Users> itr = UsersRepository.findAll();
        return (Collection<Users>) itr;
    }
}
