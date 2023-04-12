package org.johny7guitar.supersecretusersdb.util;

import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class WebRequestUrlExtractor{

    private WebRequestUrlExtractor(){}

    public static String getRequestUrl(WebRequest request){
        return request instanceof ServletWebRequest ?
                ((ServletWebRequest)request).getRequest().getRequestURL().toString() :
                request.getDescription(false);
    }

}
