package org.johny7guitar.supersecretusersdb.util;

import javax.persistence.Entity;

public class EntityNameExtractor{

    private EntityNameExtractor(){}

    public static String get(Class<?> entityClass){

        if(!entityClass.isAnnotationPresent(Entity.class)) return null;

        String entityName = entityClass.getAnnotation(Entity.class).name();

        return entityName.isEmpty() ? entityClass.getSimpleName() : entityName;

    }

}
