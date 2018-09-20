package com.yp.poc.gzip.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class WSPostRequestDto implements Serializable {

    private String firstName;

    private String lastName;

    private String phone;
}
