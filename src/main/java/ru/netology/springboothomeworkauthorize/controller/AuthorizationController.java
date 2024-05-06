package ru.netology.springboothomeworkauthorize.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springboothomeworkauthorize.domain.Account;
import ru.netology.springboothomeworkauthorize.enums.Authorities;
import ru.netology.springboothomeworkauthorize.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getStatus(@Valid Account user) {
        return "App is ready!";
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid Account user) {
        return service.getAuthorities(user);
    }


    @GetMapping("/addUser")
    public List<Authorities> addUser(@Valid Account user, @RequestParam("authority") Authorities authorities){
        return service.addUser(user, authorities);
    }





}