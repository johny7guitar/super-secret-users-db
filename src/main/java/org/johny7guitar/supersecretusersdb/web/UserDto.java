package org.johny7guitar.supersecretusersdb.web;

import org.johny7guitar.supersecretusersdb.entities.UserStatus;

import java.net.URI;

public class UserDto{

    private long id;
    private String username;
    private String email;
    private URI userpic;

    private UserStatus userStatus;

    public UserDto(long id, String username, String email, URI userpic, UserStatus userStatus){
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

    public URI getUserpic(){
        return userpic;
    }

    public void setUserpic(URI userpic){
        this.userpic = userpic;
    }

    public UserStatus getUserStatus(){
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus){
        this.userStatus = userStatus;
    }

}
