package org.johny7guitar.supersecretusersdb.web.hal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.johny7guitar.supersecretusersdb.entities.UserStatus;
import org.johny7guitar.supersecretusersdb.web.UserController;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@JsonRootName("status_change")
public class UserStatusChangeModel extends RepresentationModel<UserStatusChangeModel>{

    private long userId;
    private UserStatus oldStatus;
    private UserStatus newStatus;

    public UserStatusChangeModel(
            @JsonProperty(value = "user_id") long userId,
            @JsonProperty(value = "old_status") UserStatus oldStatus,
            @JsonProperty(value = "new_status") UserStatus newStatus
    ){
        super(linkTo(methodOn(UserController.class).updateUserStatus(userId, newStatus)).withSelfRel());
        this.userId = userId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public long getUserId(){
        return userId;
    }

    public void setUserId(long userId){
        this.userId = userId;
    }

    public UserStatus getOldStatus(){
        return oldStatus;
    }

    public void setOldStatus(UserStatus oldStatus){
        this.oldStatus = oldStatus;
    }

    public UserStatus getNewStatus(){
        return newStatus;
    }

    public void setNewStatus(UserStatus newStatus){
        this.newStatus = newStatus;
    }

}
