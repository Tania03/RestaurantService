package com.restaurant.model;

import com.restaurant.model.enums.OrderDeliveryStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Getter
@Setter
public class CreatedOrderDetails {

    private String orderId;
    private String deliveryPersonId;
    private String deliveryPersonPhone;
    private long promisedDeliveryTime;
    private OrderDeliveryStatus orderStatus;

    public CreatedOrderDetails(OrderDeliveryStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
