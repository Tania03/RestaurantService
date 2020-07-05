package com.restaurant.repository.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
@Getter
@Setter
@RequiredArgsConstructor
public class DeliveryPerson {

    String host;
    String port;
    String deliveryPersonId;
    String name;
    String phoneNumber;


    public DeliveryPerson(String deliveryPersonId, String name, String phoneNumber) {
        this.deliveryPersonId = deliveryPersonId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
