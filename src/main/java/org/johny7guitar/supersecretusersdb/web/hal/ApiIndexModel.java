package org.johny7guitar.supersecretusersdb.web.hal;

import org.johny7guitar.supersecretusersdb.web.ApiIndexController;
import org.johny7guitar.supersecretusersdb.web.UserController;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class ApiIndexModel extends RepresentationModel<ApiIndexModel>{

    public ApiIndexModel(){
        super();
        super.add(linkTo(methodOn(ApiIndexController.class).apiIndex()).withSelfRel());
        super.add(linkTo(UserController.class).withRel("users"));
    }

}
