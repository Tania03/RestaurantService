package com.delivery.controller.request;

import com.delivery.enums.OrderDeliveryStatus;
import com.delivery.model.Location;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 01/07/20
 */
@Getter
@Setter
public class DeliveryStatusUpdateRequest {

    private String deliveryPersonId;
    private Location location;
    private OrderDeliveryStatus orderStatus;

}
