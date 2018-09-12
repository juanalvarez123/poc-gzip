package com.yp.poc.gzip.controller;

import com.yp.poc.gzip.model.GetResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetResponse> getMapping() {
        GetResponse getResponse = new GetResponse();
        getResponse.setGreeting("Hola mundo !!!");
        return ResponseEntity.ok(getResponse);
    }
}
