package com.delivery.controller.response;

import com.delivery.enums.DeliveryPersonStatus;
import com.delivery.enums.OrderDeliveryStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author tania.gupta
 * @date 29/06/20
 */

@Getter
@Setter
public class DeliveryPersonAcceptOrderResponse extends ServiceResponse{

    OrderDeliveryStatus orderDeliveryStatus;

    public DeliveryPersonAcceptOrderResponse(String message, HttpStatus code) {
        super(message, code);
    }

    public DeliveryPersonAcceptOrderResponse(String message, HttpStatus code, OrderDeliveryStatus orderDeliveryStatus) {
        super(message, code);
        this.orderDeliveryStatus = orderDeliveryStatus;
    }
}
