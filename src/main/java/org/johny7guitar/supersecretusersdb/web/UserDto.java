package org.johny7guitar.supersecretusersdb.web;

import org.johny7guitar.supersecretusersdb.entities.UserStatus;

import java.net.URI;

public class UserDto{

    private long id;
    private String username;
    private String email;

    private String userpic;

    private UserStatus userStatus;

    public UserDto(){
        this.userStatus = UserStatus.ONLINE;
    }

    public UserDto(long id, String username, String email, String userpic, UserStatus userStatus){
        this.id = id;
        this.username = username;
        this.email = email;
        this.userpic = userpic;
        this.userStatus = userStatus;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUserpic(){
        return userpic;
    }

    public void setUserpic(String userpic){
        this.userpic = userpic;
    }

    public UserStatus getUserStatus(){
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus){
        this.userStatus = userStatus;
    }

}
