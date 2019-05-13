package edugate.demo.controllers;

import edugate.demo.model.Users;
import edugate.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GlobalController {

    @Autowired
    private UserService userService;

    private Users loginUsers;

    public Users getLoginUsers() {
        if (loginUsers == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            loginUsers = userService.findByLogin(auth.getName());
        }
        return loginUsers;
    }
}