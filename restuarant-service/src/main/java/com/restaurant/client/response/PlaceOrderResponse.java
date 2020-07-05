package com.restaurant.client.response;

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
public class PlaceOrderResponse  extends ServiceResponse{

    String orderId;
    String deliveryPersonId;
    String deliveryPersonPhoneNumber;
    OrderDeliveryStatus orderStatus;
    Long expectedDeliveryTime;



    public PlaceOrderResponse() {
    }


    public PlaceOrderResponse(String message, OrderDeliveryStatus orderStatus) {
        super(message);
        this.orderStatus = orderStatus;
    }

    public PlaceOrderResponse(String message, HttpStatus code) {
        super(message, code);
    }


}
