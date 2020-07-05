package com.restaurant.client.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author tania.gupta
 * @date 30/06/20
 */

@Getter
@Setter
public class DeliveryPersonRegisterResponse extends ServiceResponse{

    String deliveryPersonId;

    public DeliveryPersonRegisterResponse(String message) {
        super(message);
    }

    public DeliveryPersonRegisterResponse(String message, HttpStatus badRequest) {
    }

    public DeliveryPersonRegisterResponse(String message, HttpStatus code, String deliveryPersonId) {
        super(message, code);
        this.deliveryPersonId = deliveryPersonId;
    }

}
