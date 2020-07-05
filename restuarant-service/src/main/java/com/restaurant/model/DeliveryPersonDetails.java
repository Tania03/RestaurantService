package com.restaurant.model;

import com.restaurant.model.enums.DeliveryPersonStatus;
import com.restaurant.model.enums.OrderDeliveryStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
@Getter
@Setter
public class DeliveryPersonDetails {

    String host;
    String port;
    String deliveryPersonId;
    String phoneNumber;
    String name;
    String orderId;
    Location location;
    OrderDeliveryStatus orderDeliveryStatus;
    DeliveryPersonStatus deliveryPersonStatus;



}
