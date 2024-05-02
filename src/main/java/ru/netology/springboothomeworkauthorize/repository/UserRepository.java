package ru.netology.springboothomeworkauthorize.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springboothomeworkauthorize.domain.Account;
import ru.netology.springboothomeworkauthorize.enums.Authorities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<Account, List<Authorities>> authoritiesRepository = new HashMap<>();

    public List<Authorities> getUserAuthorities(Account user) {
        List<Authorities> result = new ArrayList<>();
        if(authoritiesRepository.containsKey(user)){
            if(authoritiesRepository.keySet().stream().filter(x -> x.equals(user)).findFirst()
                    .get().getPassword().equals(user.getPassword())){
                result.addAll(authoritiesRepository.get(user));
            }
        }
        return result;
    }

    public boolean addUser(Account user, Authorities authority){
        if(authoritiesRepository.containsKey(user)){
            if(!authoritiesRepository.get(user).contains(authority)){
                return authoritiesRepository.get(user).add(authority);
            }
            return true;
        }else{
            List<Authorities> list = new ArrayList<>();
            list.add(authority);
            authoritiesRepository.put(user, list);
            return true;
        }
    }

}
