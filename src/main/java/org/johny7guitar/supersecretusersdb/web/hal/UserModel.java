package org.johny7guitar.supersecretusersdb.web.hal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.johny7guitar.supersecretusersdb.web.UserController;
import org.johny7guitar.supersecretusersdb.web.UserDto;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@JsonRootName("user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel extends RepresentationModel<UserModel>{

    private UserDto user;

    public UserModel(UserDto user, Long id){
        super();
        this.user = user;
        super.add(linkTo(methodOn(UserController.class).getUser(id)).withSelfRel());
    }

    public UserDto getUser(){
        return user;
    }

    public void setUser(UserDto user){
        this.user = user;
    }

}
