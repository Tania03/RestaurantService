package com.restaurant.core.impl;

import com.restaurant.core.DeliveryPersonService;
import com.restaurant.core.helper.OrderServiceHelper;
import com.restaurant.model.CreatedOrderDetails;
import com.restaurant.model.DeliveryPersonDetails;
import com.restaurant.model.Location;
import com.restaurant.model.enums.DeliveryPersonStatus;
import com.restaurant.model.enums.OrderDeliveryStatus;
import com.restaurant.model.OrderDetails;
import com.restaurant.repository.OrderRepository;
import com.restaurant.core.OrderService;
import com.restaurant.repository.entity.DeliveryPersonStatusDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author tania.gupta
 * @date 27/06/20
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    DeliveryPersonService deliveryPersonService;

    @Autowired
    OrderServiceHelper orderServiceHelper;



    /**
     * Steps -  1. Create a new order object
     *          2. Find a delivery Person
     *          3. Persist the new order
     *          4. Return the created order
     */
    @Override
    public CreatedOrderDetails createOrder(String customerId, Location location, Map<String, Integer> items) {

        //Create a new Order
        OrderDetails orderDetails = orderServiceHelper.createNewOrderDetails(customerId, location, items);

        //Assign order to available delivery person
        DeliveryPersonDetails deliveryPersonDetails = deliveryPersonService.assignDeliveryPerson(orderDetails);

        if(deliveryPersonDetails == null)
            return new CreatedOrderDetails(OrderDeliveryStatus.REJECTED);

        orderDetails.setDeliveryPersonId(deliveryPersonDetails.getDeliveryPersonId());
        orderDetails.setOrderStatus(OrderDeliveryStatus.ACCEPTED);

        //persist order
        orderRepository.save(orderDetails);

        return orderServiceHelper.createDeliveryOrderDetails(orderDetails, deliveryPersonDetails);
    }

    @Override
    public OrderDetails getOrderStatus(String orderId) {

       OrderDetails orderDetails = orderRepository.getOrderDetailsByOrderId(orderId);

       if(orderDetails == null)
           return null;

       String deliveryPersonId = orderDetails.getDeliveryPersonId();

       //Find delivery person status when order is out for delivery
       if(orderDetails.getOrderStatus() != null &&
               orderDetails.getOrderStatus().equals(OrderDeliveryStatus.OUT_FOR_DELIVERY)) {

           //Find active delivery person status
           DeliveryPersonStatusDetails deliveryPersonStatusDetails =
                   deliveryPersonService.findActiveDeliveryPersonStatus(deliveryPersonId);
           orderDetails.setDeliveryPersonLocation(deliveryPersonStatusDetails.getLocation());

           //Calculate ETA
           Long etaInSeconds = deliveryPersonService.calculateETA(
                   orderDetails.getOrderId(), deliveryPersonStatusDetails.getLocation());

           orderDetails.setPromisedDeliveryTime(etaInSeconds);
       }

       return orderDetails;
    }

    @Override
    public DeliveryPersonStatusDetails updateDeliveryStatus(String deliveryPersonId, Location location, OrderDeliveryStatus orderStatus) {

        //Find active delivery person status
        DeliveryPersonStatusDetails deliveryPersonStatusDetails =
                deliveryPersonService.findActiveDeliveryPersonStatus(deliveryPersonId);

        if(deliveryPersonStatusDetails == null)
            return null;

        deliveryPersonStatusDetails.setLocation(location);

        //Find active order details
        OrderDetails orderDetails = orderRepository.getOrderDetailsByOrderId(deliveryPersonStatusDetails.getOrderId());

        if(orderDetails == null)
            return null;

        orderServiceHelper.updateOrderDetails(orderDetails, orderStatus, location);

        //update delivery status
        if(orderStatus.equals(OrderDeliveryStatus.DELIVERED)
                || orderStatus.equals(OrderDeliveryStatus.UNDELIVERED)) {

            deliveryPersonService.updateDeliveryPersonStatus(deliveryPersonStatusDetails, "",
                    DeliveryPersonStatus.AVAILABLE);

        } else if(orderStatus.equals(OrderDeliveryStatus.OUT_FOR_DELIVERY)){

            Long etaInSeconds = deliveryPersonService.calculateETA(orderDetails.getOrderId(), location);
            orderDetails.setPromisedDeliveryTime(etaInSeconds);

        }

        orderRepository.updateOrderDetails(orderDetails);

        return deliveryPersonStatusDetails;
    }


    @Override
    public Location getOrderLocationByOrderId(String orderId) {
        return orderRepository.getOrderLocationByOrderId(orderId);
    }


}
