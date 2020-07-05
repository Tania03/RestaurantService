package com.delivery.model;

import com.delivery.enums.OrderDeliveryStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 01/07/20
 */

@Getter
@Setter
public class DeliveryStatusUpdate {

    private String deliveryPersonId;
    private Location location;
    private OrderDeliveryStatus orderStatus;

}
