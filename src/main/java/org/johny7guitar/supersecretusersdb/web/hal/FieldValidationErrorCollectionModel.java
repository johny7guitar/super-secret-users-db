package org.johny7guitar.supersecretusersdb.web.hal;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.johny7guitar.supersecretusersdb.util.WebRequestUrlExtractor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.context.request.WebRequest;

import java.util.Collection;

public class FieldValidationErrorCollectionModel extends RepresentationModel<FieldValidationErrorCollectionModel>{

    @JsonProperty("errors")
    private Collection<FieldValidationErrorModel> errors;

    public FieldValidationErrorCollectionModel(@JsonProperty("errors") Collection<FieldValidationErrorModel> errors, WebRequest request){
        super(Link.of(WebRequestUrlExtractor.getRequestUrl(request)).withSelfRel());
        this.errors = errors;
    }

    public Collection<FieldValidationErrorModel> getErrors(){
        return errors;
    }

}
