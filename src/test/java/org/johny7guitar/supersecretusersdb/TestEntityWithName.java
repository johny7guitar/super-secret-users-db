package org.johny7guitar.supersecretusersdb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "test_entity_name")
public class TestEntityWithName{

    @Id
    private long id;

    public TestEntityWithName(){
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

}
