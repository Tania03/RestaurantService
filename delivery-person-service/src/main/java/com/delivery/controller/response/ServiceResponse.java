package com.delivery.controller.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Getter
@Setter
public class ServiceResponse {

    String message;
    HttpStatus code;

    public ServiceResponse() {
    }

    public ServiceResponse(String message) {
        this.message = message;
    }

    public ServiceResponse(String message, HttpStatus code) {
        this.message = message;
        this.code = code;
    }
}
