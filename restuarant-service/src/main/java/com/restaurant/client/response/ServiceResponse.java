package com.restaurant.client.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.annotation.PostConstruct;

/**
 * @author tania.gupta
 * @date 27/06/20
 */

@Getter
@Setter
public class ServiceResponse {

    String message;
    HttpStatus code;

    @PostConstruct
    public void init(){
        this.message = "success";
        this.code = HttpStatus.OK;
    }
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
