package ru.netology.springboothomeworkauthorize.service;

import org.springframework.stereotype.Service;
import ru.netology.springboothomeworkauthorize.enums.Authorities;
import ru.netology.springboothomeworkauthorize.exceptions.InvalidCredentials;
import ru.netology.springboothomeworkauthorize.exceptions.UnauthorizedUser;
import ru.netology.springboothomeworkauthorize.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    public List<Authorities> addUser(String user, String password, String authoritie){
        if (userRepository.addUser(user, password, authoritie)){
            return getAuthorities(user, password);
        }else{
            throw new UnauthorizedUser("Unknown user " + user);
        }
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
