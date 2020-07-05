package com.restaurant.model;

import com.restaurant.model.enums.DeliveryPersonStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 29/06/20
 */

@Getter
@Setter
public class ActiveDeliveryStatus {

    String personId;
    String orderId;
    Location location;
    long etaInSeconds;
    DeliveryPersonStatus deliveryPersonStatus;

}
