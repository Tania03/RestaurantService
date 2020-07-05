package com.restaurant.repository.entity;

import com.restaurant.model.Location;
import com.restaurant.model.enums.OrderDeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
@Getter
@Setter
public class OrderEntity {

    private String orderId;
    private String customerId;
    private Location location;
    private String deliveryPersonId;

    private Map<String, Integer> items;
    private OrderDeliveryStatus orderStatus;

    private long createdAt;
    private long promisedDeliveryTime;
    private long deliveredAt;

}
