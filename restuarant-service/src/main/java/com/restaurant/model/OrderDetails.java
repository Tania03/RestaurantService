package com.restaurant.model;

import com.restaurant.constant.Constant;
import com.restaurant.model.enums.OrderDeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author tania.gupta
 * @date 26/06/20
 */
@Getter
@Setter
public class OrderDetails {

    private String orderId;
    private String customerId;
    private Location customerLocation;
    private String deliveryPersonId;
    private Location deliveryPersonLocation;

    private Map<String, Integer> items;
    private OrderDeliveryStatus orderStatus;

    private long createdAt;
    private long promisedDeliveryTime;
    private long deliveredAt;

    public OrderDetails(String orderId, String customerId, Location customerLocation, Map<String, Integer> items) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerLocation = customerLocation;
        this.items = items;
        this.createdAt = System.currentTimeMillis();
        this.promisedDeliveryTime = createdAt + Constant.DEFAULT_PROMISE_TIME;

    }
}
