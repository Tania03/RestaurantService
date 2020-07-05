package com.delivery.controller;

import com.delivery.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 30/06/20
 */
@Getter
@Setter
@AllArgsConstructor
public class AcceptOrderRequest {

    String orderId;
    Location Location;
}