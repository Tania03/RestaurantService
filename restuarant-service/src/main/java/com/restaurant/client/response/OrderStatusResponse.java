package com.restaurant.client.response;

import com.restaurant.model.Location;
import com.restaurant.model.enums.OrderDeliveryStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author tania.gupta
 * @date 27/06/20
 */
@Getter
@Setter
public class OrderStatusResponse extends ServiceResponse {

    String deliveryPersonId;
    String orderId;
    Location location;
    OrderDeliveryStatus status;
    long expectedDeliveryTime;

    public OrderStatusResponse() {
    }

    public OrderStatusResponse(String message) {
        super(message);
    }

    public OrderStatusResponse(String message, HttpStatus code) {
       super(message,code);
    }
}
