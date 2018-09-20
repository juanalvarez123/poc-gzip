package com.yp.poc.gzip.service;

import com.yp.poc.gzip.dto.WSGetResponseDto;
import com.yp.poc.gzip.dto.WSPostRequestDto;
import com.yp.poc.gzip.dto.WSPostResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallerService {

    private static final String BASE_URL = "http://unicomer-gateway-server:8080/unicomer/user-service/poc-gzip";

    private RestTemplate restTemplate;

    @Autowired
    public CallerService() {
        restTemplate = new RestTemplate();
    }

    public WSGetResponseDto processGetCall(String personaName) {
        String getResourceUrl = BASE_URL + "/get";
        return restTemplate.getForObject(getResourceUrl + "/" + personaName, WSGetResponseDto.class);
    }

    public WSPostResponseDto processPostCall() {
        String postResourceUrl = BASE_URL + "/post";

        WSPostRequestDto wsPostRequestDto = new WSPostRequestDto();
        wsPostRequestDto.setFirstName("Katy");
        wsPostRequestDto.setLastName("Perry");
        wsPostRequestDto.setPhone("111222333");

        HttpEntity<WSPostRequestDto> request = new HttpEntity<>(wsPostRequestDto);
        return restTemplate.postForObject(postResourceUrl, request, WSPostResponseDto.class);
    }
}
