package ru.netology.springboothomeworkauthorize.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springboothomeworkauthorize.enums.Authorities;
import ru.netology.springboothomeworkauthorize.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @GetMapping("/addUser")
    public List<Authorities> addUser(@RequestParam("user") String user, @RequestParam("password") String password,
                                     @RequestParam("authority") String authority){
        return service.addUser(user, password, authority);
    }





}