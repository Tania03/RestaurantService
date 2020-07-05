package com.delivery.client.model;

import com.delivery.controller.response.ServiceResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tania.gupta
 * @date 30/06/20
 */
@Getter
@Setter
@ToString
public class DeliveryPersonRegisterResponse extends ServiceResponse {

    String deliveryPersonId;

}
