package edugate.demo.security;

import edugate.demo.model.Users;

public interface SecurityService {
    String findLoggedInUsername();
    Users findLoggedInUserId();

    void autoLogin(String username, String password);
}