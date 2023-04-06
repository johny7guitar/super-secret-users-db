package org.johny7guitar.supersecretusersdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URI;
import java.util.Objects;

@Entity
public class User{

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private URI userpic;

    public User(){
        //jpa-required empty public constructor
    }

    public User(long id, String username, String email, URI userpic){
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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id
                && Objects.equals(username, user.username)
                && Objects.equals(email, user.email)
                && Objects.equals(userpic, user.userpic);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, username, email, userpic);
    }

}
