package ru.netology.springboothomeworkauthorize.service;

import org.springframework.stereotype.Service;
import ru.netology.springboothomeworkauthorize.domain.Account;
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

    public List<Authorities> getAuthorities(Account user) {
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    public List<Authorities> addUser(Account user, Authorities authority){
        if (userRepository.addUser(user, authority)){
            return getAuthorities(user);
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
