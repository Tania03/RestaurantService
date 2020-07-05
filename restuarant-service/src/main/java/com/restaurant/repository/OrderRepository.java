package com.restaurant.repository;

import com.restaurant.model.Location;
import com.restaurant.model.OrderDetails;

/**
 * @author tania.gupta
 * @date 27/06/20
 */

public interface OrderRepository {

    void save(OrderDetails orderDetails);

    Location getOrderLocationByOrderId(String orderId);

    OrderDetails getOrderDetailsByOrderId(String orderId);

    void updateOrderDetails(OrderDetails orderDetails);
}
