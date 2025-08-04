package com.example.demo.controller;

import com.example.demo.security.CustomAuthentication;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpRequest request){
        if (username.equals("Giorgi") && password.equals("password")){
            System.out.println("ssss");
        }
        return "SSHDSHDSH";
    }

    @GetMapping("/hello")
    public String hello(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        CustomAuthentication authentication = (CustomAuthentication)securityContext.getAuthentication();

        String name = authentication.getName();
        return name;
    }
}
