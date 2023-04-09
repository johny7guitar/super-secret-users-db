package org.johny7guitar.supersecretusersdb.entities.converters;

import org.johny7guitar.supersecretusersdb.entities.UserStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class UserStatusStringFormatterTest{

    static UserStatusStringFormatter formatter;

    @BeforeAll
    static void init(){
        formatter = new UserStatusStringFormatter();
    }

    @Test
    void toStringTest(){
        assertEquals("online", formatter.print(UserStatus.ONLINE, Locale.ENGLISH).toLowerCase());
        assertEquals("offline", formatter.print(UserStatus.OFFLINE, Locale.ENGLISH).toLowerCase());
    }

    @Test
    void toUserStatusTest() throws ParseException{
        assertEquals(UserStatus.ONLINE, formatter.parse("online", Locale.ENGLISH));
        assertEquals(UserStatus.ONLINE, formatter.parse("ONLINE", Locale.ENGLISH));
        assertEquals(UserStatus.ONLINE, formatter.parse("OnLiNE", Locale.ENGLISH));
        assertEquals(UserStatus.OFFLINE, formatter.parse("offline", Locale.ENGLISH));
        assertEquals(UserStatus.OFFLINE, formatter.parse("OFFLINE", Locale.ENGLISH));
        assertEquals(UserStatus.OFFLINE, formatter.parse("OffLiNE", Locale.ENGLISH));
    }

}