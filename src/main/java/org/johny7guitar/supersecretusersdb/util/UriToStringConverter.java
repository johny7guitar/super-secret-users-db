package org.johny7guitar.supersecretusersdb.util;

import java.net.URI;

public interface UriToStringConverter{

    default String map(URI value){
        return value == null ? "" : value.toString();
    }

    default URI map(String value){
        return URI.create(value != null ? value : "");
    }

}
