package com.yp.poc.gzip.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class WSPostResponseDto implements Serializable {

    private String greeting;

    private String contact;
}
