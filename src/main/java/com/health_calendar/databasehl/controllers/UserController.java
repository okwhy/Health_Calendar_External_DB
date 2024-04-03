package com.health_calendar.databasehl.controllers;

import com.health_calendar.databasehl.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/users")
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public boolean register(@RequestParam String login,
                            @RequestParam String password,
                            @RequestParam String name){
        return userService.addUser(login,password,name);
    }
    @GetMapping("/login")
    public String login(@RequestParam String login,
                         @RequestParam String password){
        return userService.auth(login, password);
    }
}
