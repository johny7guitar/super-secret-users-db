package org.johny7guitar.supersecretusersdb.util;

import org.johny7guitar.supersecretusersdb.entities.User;
import org.johny7guitar.supersecretusersdb.web.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends UriToStringConverter{

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);

}
