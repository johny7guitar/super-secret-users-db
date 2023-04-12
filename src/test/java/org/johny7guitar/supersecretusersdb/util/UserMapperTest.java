package org.johny7guitar.supersecretusersdb.util;

import org.johny7guitar.supersecretusersdb.entities.User;
import org.johny7guitar.supersecretusersdb.web.UserDto;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest{

    @Test
    void userToDtoTest(){

        User user = new User(
                -1,
                "testuser",
                "testuser@email.com",
                URI.create("testuri")
        );

        UserMapper userMapper = UserMapper.INSTANCE;
        assertNotNull(userMapper);

        UserDto userDto = userMapper.userToUserDto(user);
        assertNotNull(userDto);
        assertEquals(user.getId(), userDto.getId());
        assertEquals(user.getUsername(), userDto.getUsername());
        assertEquals(user.getEmail(), userDto.getEmail());
        assertEquals(user.getUserpic().toString(), userDto.getUserpic());

    }

}