package com.restaurant.client.response;

import com.restaurant.model.Location;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Getter
@Setter
public class ActiveDeliveryStatusResponse extends ServiceResponse {

    String personId;
    String orderId;
    Location location;
    long etaInSeconds;

    public ActiveDeliveryStatusResponse() {
    }

    public ActiveDeliveryStatusResponse(String message, HttpStatus code) {
        super(message, code);
    }
}
