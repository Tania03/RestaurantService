package com.restaurant.core;

import com.restaurant.model.CreatedOrderDetails;
import com.restaurant.model.Location;
import com.restaurant.model.enums.OrderDeliveryStatus;
import com.restaurant.model.OrderDetails;
import com.restaurant.repository.entity.DeliveryPersonStatusDetails;

import java.util.Map;

/**
 * @author tania.gupta
 * @date 27/06/20
 */
public interface OrderService {

    CreatedOrderDetails createOrder(String customerId, Location location, Map<String, Integer> items);

    OrderDetails getOrderStatus(String orderId);

    Location getOrderLocationByOrderId(String orderId);

    DeliveryPersonStatusDetails updateDeliveryStatus(String deliveryPersonId, Location location, OrderDeliveryStatus orderStatus);
}
