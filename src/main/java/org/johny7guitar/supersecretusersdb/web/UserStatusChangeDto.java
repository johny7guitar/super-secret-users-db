package org.johny7guitar.supersecretusersdb.web;

import org.johny7guitar.supersecretusersdb.entities.UserStatus;

public class UserStatusChangeDto{

    private long userId;
    private UserStatus oldUserStatus;
    private UserStatus newUserStatus;

    public UserStatusChangeDto(long userId, UserStatus oldUserStatus, UserStatus newUserStatus){
        this.userId = userId;
        this.oldUserStatus = oldUserStatus;
        this.newUserStatus = newUserStatus;
    }

    public long getUserId(){
        return userId;
    }

    public void setUserId(long userId){
        this.userId = userId;
    }

    public UserStatus getOldUserStatus(){
        return oldUserStatus;
    }

    public void setOldUserStatus(UserStatus oldUserStatus){
        this.oldUserStatus = oldUserStatus;
    }

    public UserStatus getNewUserStatus(){
        return newUserStatus;
    }

    public void setNewUserStatus(UserStatus newUserStatus){
        this.newUserStatus = newUserStatus;
    }

}
