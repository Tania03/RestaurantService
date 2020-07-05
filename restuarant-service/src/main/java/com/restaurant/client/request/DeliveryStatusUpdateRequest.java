package com.restaurant.client.request;

import com.restaurant.model.Location;
import com.restaurant.model.enums.OrderDeliveryStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 29/06/20
 */

@Getter
@Setter
public class DeliveryStatusUpdateRequest {

    private String deliveryPersonId;
    private Location location;
    private OrderDeliveryStatus orderStatus;

}
