package org.johny7guitar.supersecretusersdb.web.hal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.johny7guitar.supersecretusersdb.web.UserController;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@JsonRootName("user_id")
public class UserIdOnlyModel extends RepresentationModel<UserIdOnlyModel>{
    private long id;

    public UserIdOnlyModel(@JsonProperty(value = "user_id") long id){
        super();
        this.id = id;
        super.add(linkTo(methodOn(UserController.class).getUser(id)).withSelfRel());
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

}
