package org.johny7guitar.supersecretusersdb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestEntity{

    @Id
    private long id;

    private TestEntity(){}

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

}
