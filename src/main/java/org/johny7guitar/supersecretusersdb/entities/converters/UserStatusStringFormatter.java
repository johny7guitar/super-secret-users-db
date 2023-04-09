package org.johny7guitar.supersecretusersdb.entities.converters;

import org.johny7guitar.supersecretusersdb.entities.UserStatus;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class UserStatusStringFormatter implements Formatter<UserStatus>{

    @Override
    public UserStatus parse(String text, Locale locale) throws ParseException{

        switch(text.toLowerCase(locale)){

            case "online": return UserStatus.ONLINE;
            case "offline": return UserStatus.OFFLINE;
            default: throw new IllegalArgumentException();

        }

    }

    @Override
    public String print(UserStatus object, Locale locale){
        return object.toString();
    }

}
