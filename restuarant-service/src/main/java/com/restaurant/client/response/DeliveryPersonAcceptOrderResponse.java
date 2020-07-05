package com.restaurant.client.response;

import com.restaurant.model.enums.OrderDeliveryStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 30/06/20
 */
@Getter
@Setter
public class DeliveryPersonAcceptOrderResponse extends ServiceResponse{

    OrderDeliveryStatus orderDeliveryStatus;

}
