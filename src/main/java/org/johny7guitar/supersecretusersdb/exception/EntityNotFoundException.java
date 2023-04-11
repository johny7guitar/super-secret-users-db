package org.johny7guitar.supersecretusersdb.exception;

import org.johny7guitar.supersecretusersdb.util.EntityNameExtractor;

import java.util.Optional;

public class EntityNotFoundException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Unable to find %s with id %d";
    private static final String DEFAULT_UNKNOWN_ENTITY_MESSAGE = "Item not found";

    public EntityNotFoundException(Class<?> entityClass, long id){
        super(
                Optional.ofNullable(entityClass)
                        .map(EntityNameExtractor::get)
                        .map(entityName -> String.format(DEFAULT_MESSAGE, entityName, id))
                        .orElse(DEFAULT_UNKNOWN_ENTITY_MESSAGE)
        );
    }

}
