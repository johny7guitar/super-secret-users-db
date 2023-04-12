package org.johny7guitar.supersecretusersdb.web.hal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.johny7guitar.supersecretusersdb.util.WebRequestUrlExtractor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@JsonRootName("error")
public class ErrorModel extends RepresentationModel<ErrorModel>{

    private String errorMessage;

    public ErrorModel(@JsonProperty(value = "message") String errorMessage, WebRequest request){
        super();
        super.add(Link.of(WebRequestUrlExtractor.getRequestUrl(request)).withSelfRel());
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

}
