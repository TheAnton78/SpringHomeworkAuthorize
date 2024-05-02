package ru.netology.springboothomeworkauthorize.configuretion;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ru.netology.springboothomeworkauthorize.enums.Authorities;

public  class StringToAuthorizatiesConverter implements Converter<String, Authorities> {

    @Override
    public Authorities convert(String authority) {
        return switch (authority.toUpperCase()) {
            case "READ" -> Authorities.READ;
            case "WRITE" -> Authorities.WRITE;
            case "DELETE" -> Authorities.DELETE;
            default -> null;
        };
    }



}
