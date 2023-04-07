package org.johny7guitar.supersecretusersdb.web;

import java.net.URI;

public class UserDto{

    private long id;
    private String username;
    private String email;
    private URI userpic;

    public UserDto(long id, String username, String email, URI userpic){
        this.id = id;
        this.username = username;
        this.email = email;
        this.userpic = userpic;
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

}
