package ru.netology.springboothomeworkauthorize.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springboothomeworkauthorize.enums.Authorities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<String, String> repository = new HashMap<>();
    private Map<String, List<Authorities>> authoritiesRepository = new HashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> result = new ArrayList<>();
        if(repository.containsKey(user)){
            if(repository.get(user).equals(password)){
                result.addAll(authoritiesRepository.get(user));
            }
        }
        return result;
    }

    public boolean addUser(String user, String password, String authoritie){
        if(repository.containsKey(user)){
            return authoritiesRepository.get(user).add(convertAuthorities(authoritie));
        }else{
            List<Authorities> list = new ArrayList<>();
            list.add(convertAuthorities(authoritie));
            repository.put(user, password);
            authoritiesRepository.put(user, list);
            return true;
        }
    }

    private Authorities convertAuthorities(String authoritie){
        return switch (authoritie.toUpperCase()) {
            case "READ" -> Authorities.READ;
            case "WRITE" -> Authorities.WRITE;
            case "DELETE" -> Authorities.DELETE;
            default -> null;
        };
    }
}
