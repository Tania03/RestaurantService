package com.restaurant.repository.entity;

import com.restaurant.model.Location;
import com.restaurant.model.enums.DeliveryPersonStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 29/06/20
 */

@Getter
@Setter
public class DeliveryPersonStatusDetails {

    private String deliveryPersonId;
    private String orderId;
    private Location location;
    private DeliveryPersonStatus status;

    public DeliveryPersonStatusDetails() {
    }

    public DeliveryPersonStatusDetails(String deliveryPersonId, Location location, DeliveryPersonStatus status) {
        this.deliveryPersonId = deliveryPersonId;
        this.location = location;
        this.status = status;
    }
}
