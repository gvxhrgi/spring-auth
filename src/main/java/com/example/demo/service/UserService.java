package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        users.put("admin", new User("admin", passwordEncoder.encode("admin123"), Set.of("ADMIN")));
        users.put("user", new User("user", passwordEncoder.encode("user123"), Set.of("USER")));
    }

    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, passwordEncoder.encode(password), Set.of("USER")));
        return true;
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public boolean validatePassword(String username, String password) {
        User user = findByUsername(username);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }
}