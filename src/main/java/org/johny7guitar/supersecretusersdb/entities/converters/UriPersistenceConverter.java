package org.johny7guitar.supersecretusersdb.entities.converters;

import org.johny7guitar.supersecretusersdb.util.UriToStringConverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.net.URI;

@Converter(autoApply = true)
public class UriPersistenceConverter implements AttributeConverter<URI, String>, UriToStringConverter{

    @Override
    public String convertToDatabaseColumn(URI attribute){
        return map(attribute);
    }

    @Override
    public URI convertToEntityAttribute(String dbData){
        return map(dbData);
    }

}
