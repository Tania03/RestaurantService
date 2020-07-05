package com.delivery.model;

import com.delivery.enums.DeliveryPersonStatus;
import com.delivery.enums.OrderDeliveryStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 27/06/20
 */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryPersonDetails {


    String host;
    String port;
    String name;
    String phoneNumber;
    Location location;
    DeliveryPersonStatus deliveryPersonStatus;
    OrderDeliveryStatus orderDeliveryStatus;
    String orderId;
    String deliveryPersonId;
    Location customerLocation;


    public DeliveryPersonDetails() {
    }
}
