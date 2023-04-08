package org.johny7guitar.supersecretusersdb.entities.converters;

import org.johny7guitar.supersecretusersdb.entities.UserStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserStatusToBooleanConverter implements AttributeConverter<UserStatus, Boolean>{

    @Override
    public Boolean convertToDatabaseColumn(UserStatus attribute){
        return attribute.equals(UserStatus.ONLINE);
    }

    @Override
    public UserStatus convertToEntityAttribute(Boolean dbData){
        return dbData ? UserStatus.ONLINE : UserStatus.OFFLINE;
    }

}
