package com.restaurant.repository.impl;


import com.restaurant.model.Location;
import com.restaurant.model.OrderDetails;
import com.restaurant.repository.OrderRepository;
import com.restaurant.repository.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
@Repository("orderRepository")
public class OrderRepositoryImpl implements OrderRepository {

    Map<String, OrderEntity> orderMap;

    @PostConstruct
    public void init(){
        orderMap = new HashMap<>();
    }

    @Override
    public void save(OrderDetails orderDetails) {

        OrderEntity orderEntity = createOrderEntity(orderDetails);
        orderMap.put(orderDetails.getOrderId(), orderEntity);
    }

    @Override
    public Location getOrderLocationByOrderId(String orderId) {
        return orderMap.get(orderId).getLocation();
    }

    @Override
    public OrderDetails getOrderDetailsByOrderId(String orderId) {

        if(!orderMap.containsKey(orderId))
            return null;

        OrderEntity order = orderMap.get(orderId);

        OrderDetails orderDetails = getOrderDetailsFromOrderEntity(order);

        return orderDetails;
    }

    @Override
    public void updateOrderDetails(OrderDetails orderDetails) {
        if(!orderMap.containsKey(orderDetails.getOrderId()))
            return;

        OrderEntity order = orderMap.get(orderDetails.getOrderId());
        order.setOrderStatus(orderDetails.getOrderStatus());
        order.setPromisedDeliveryTime(orderDetails.getPromisedDeliveryTime());

    }

    private OrderDetails getOrderDetailsFromOrderEntity(OrderEntity order) {

        OrderDetails orderDetails = new OrderDetails(order.getOrderId(), order.getCustomerId(), order.getLocation(), order.getItems());
        orderDetails.setDeliveryPersonId(order.getDeliveryPersonId());
        orderDetails.setOrderStatus(order.getOrderStatus());
        orderDetails.setCreatedAt(order.getCreatedAt());
        orderDetails.setDeliveredAt(order.getDeliveredAt());
        orderDetails.setPromisedDeliveryTime(order.getPromisedDeliveryTime());
        return orderDetails;
    }

    private OrderEntity createOrderEntity(OrderDetails orderDetails) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderDetails.getOrderId());
        orderEntity.setCustomerId(orderDetails.getCustomerId());
        orderEntity.setLocation(orderDetails.getCustomerLocation());
        orderEntity.setDeliveryPersonId(orderDetails.getDeliveryPersonId());
        orderEntity.setItems(orderDetails.getItems());
        orderEntity.setCreatedAt(orderDetails.getCreatedAt());
        orderEntity.setPromisedDeliveryTime(orderDetails.getPromisedDeliveryTime());
        orderEntity.setOrderStatus(orderDetails.getOrderStatus());
        return orderEntity;

    }


}
