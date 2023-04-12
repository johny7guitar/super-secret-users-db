package org.johny7guitar.supersecretusersdb.web.hal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.johny7guitar.supersecretusersdb.util.WebRequestUrlExtractor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.context.request.WebRequest;

@JsonRootName("field_validation_error")
public class FieldValidationErrorModel extends RepresentationModel<FieldValidationErrorModel>{

    private String fieldName;
    private String errorMessage;

    public FieldValidationErrorModel(
            @JsonProperty("field") String fieldName,
            @JsonProperty("error_message") String errorMessage,
            WebRequest request
    ){
        super(Link.of(WebRequestUrlExtractor.getRequestUrl(request)).withSelfRel());
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
    }

    public String getFieldName(){
        return fieldName;
    }

    public void setFieldName(String fieldName){
        this.fieldName = fieldName;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

}
