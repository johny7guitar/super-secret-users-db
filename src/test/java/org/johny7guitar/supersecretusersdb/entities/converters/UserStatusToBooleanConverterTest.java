package org.johny7guitar.supersecretusersdb.entities.converters;

import org.johny7guitar.supersecretusersdb.entities.UserStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserStatusToBooleanConverterTest{

    @Test
    void converterTest(){

        UserStatusToBooleanConverter converter = new UserStatusToBooleanConverter();

        assertTrue(converter.convertToDatabaseColumn(UserStatus.ONLINE));
        assertFalse(converter.convertToDatabaseColumn(UserStatus.OFFLINE));
        assertEquals(UserStatus.ONLINE, converter.convertToEntityAttribute(true));
        assertEquals(UserStatus.OFFLINE, converter.convertToEntityAttribute(false));

    }

}