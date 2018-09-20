package com.yp.poc.gzip.controller;

import com.yp.poc.gzip.dto.WSGetResponseDto;
import com.yp.poc.gzip.dto.WSPostResponseDto;
import com.yp.poc.gzip.model.GetResponse;
import com.yp.poc.gzip.model.PostResponse;
import com.yp.poc.gzip.service.CallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contains methods that CALLS the Unicomer user-service end-points
 */
@RestController
public class CallerController {

    @Autowired
    private CallerService callerService;

    @GetMapping(value = "/call")
    public GetResponse getCall() {
        WSGetResponseDto wsGetResponseDto = callerService.processGetCall("Sebastian");

        GetResponse getResponse = new GetResponse();
        getResponse.setMessage(wsGetResponseDto.getMessage());
        return getResponse;
    }

    @PostMapping(value = "/call")
    public PostResponse postCall() {
        WSPostResponseDto WSPostResponseDto = callerService.processPostCall();

        PostResponse postResponse = new PostResponse();
        postResponse.setGreeting(WSPostResponseDto.getGreeting());
        postResponse.setContact(WSPostResponseDto.getContact());
        return postResponse;
    }

}
