package com.cereb.restapi.cerebai_interview;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;
    private UserSessionRepository userSessionRepository;

    UserController(UserRepository repository, UserSessionRepository userSessionRepository) {
        this.repository = repository;
        this.userSessionRepository = userSessionRepository;
    }

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    UUID newUser(@RequestBody User user) {
        String emailRegex = "^(.+)@(.+)$";
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Boolean validateEmail = Pattern.matches(emailRegex, user.getEmail());
        Boolean validatePassword = Pattern.matches(passwordRegex, user.getPassword());
        UUID authToken = UUID.randomUUID();
        repository.save(user);
        userSessionRepository.save(new UserSession(user.getId(), authToken, new Timestamp((new Date()).getTime())));
        return authToken;

    }

    // String emailRegex = "^(.+)@(.+)$";
    @GetMapping("/userSession")
    List<UserSession> allSessions() {
        return userSessionRepository.findAll();
    }

    @PostMapping("/userSession")
    List<UserSession> allUserSession(@RequestBody String from, String to) {
        List<UserSession> selectUserSessions = userSessionRepository.findAll();
        
        for (UserSession userSession : selectUserSessions) {
            System.out.println();

        }

        return selectUserSessions;
    }

}
