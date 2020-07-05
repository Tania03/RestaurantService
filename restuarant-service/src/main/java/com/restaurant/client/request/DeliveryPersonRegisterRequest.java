package com.restaurant.client.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurant.model.Location;
import com.restaurant.model.enums.DeliveryPersonStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryPersonRegisterRequest {

    String host;
    String port;
    String name;
    String phoneNumber;
    Location location;
    DeliveryPersonStatus status;

    public DeliveryPersonRegisterRequest() {
    }
}