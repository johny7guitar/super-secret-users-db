package org.johny7guitar.supersecretusersdb.exception;

import org.johny7guitar.supersecretusersdb.entities.User;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;

import static org.junit.jupiter.api.Assertions.*;

class EntityNotFoundExceptionTest{

    @Entity private static class TestEntity{};

    @Test
    void testExceptionMessages(){

        try{
            throw new EntityNotFoundException(TestEntity.class, 1);
        }catch(EntityNotFoundException e){
            assertEquals("unable to find testentity with id 1", e.getMessage().toLowerCase());
        }

        try{
            throw new EntityNotFoundException(Object.class, 1);
        }catch(EntityNotFoundException e){
            assertEquals("item not found", e.getMessage().toLowerCase());
        }

    }

}