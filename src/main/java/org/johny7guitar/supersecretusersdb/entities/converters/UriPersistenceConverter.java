package org.johny7guitar.supersecretusersdb.entities.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.net.URI;

@Converter(autoApply = true)
public class UriPersistenceConverter implements AttributeConverter<URI, String>{

    @Override
    public String convertToDatabaseColumn(URI attribute){
        return attribute == null ? "" : attribute.toString();
    }

    @Override
    public URI convertToEntityAttribute(String dbData){
        return URI.create(dbData);
    }

}
