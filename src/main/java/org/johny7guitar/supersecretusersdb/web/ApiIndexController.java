package org.johny7guitar.supersecretusersdb.web;

import org.johny7guitar.supersecretusersdb.web.hal.ApiIndexModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApiIndexController{

    @GetMapping
    public HttpEntity<ApiIndexModel> apiIndex(){
        return new ResponseEntity<>(new ApiIndexModel(), HttpStatus.OK);
    }

}
