package com.restaurant.core.helper;

import com.restaurant.model.CreatedOrderDetails;
import com.restaurant.model.DeliveryPersonDetails;
import com.restaurant.model.Location;
import com.restaurant.model.OrderDetails;
import com.restaurant.model.enums.OrderDeliveryStatus;
import com.restaurant.util.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
@Service
public class OrderServiceHelper {

    public OrderDetails createNewOrderDetails(String customerId, Location location, Map<String, Integer> items) {

        String orderId = CommonUtil.generateNewUUID();

        return new OrderDetails(orderId, customerId, location, items);

    }

    public CreatedOrderDetails createDeliveryOrderDetails(OrderDetails orderDetails, DeliveryPersonDetails deliveryPersonDetails) {

        CreatedOrderDetails createdOrderDetails = new CreatedOrderDetails(orderDetails.getOrderStatus());

        createdOrderDetails.setOrderId( orderDetails.getOrderId());
        createdOrderDetails.setDeliveryPersonId( deliveryPersonDetails.getDeliveryPersonId() );
        createdOrderDetails.setDeliveryPersonPhone( deliveryPersonDetails.getPhoneNumber() );
        createdOrderDetails.setPromisedDeliveryTime( orderDetails.getPromisedDeliveryTime());
        createdOrderDetails.setDeliveryPersonPhone(deliveryPersonDetails.getPhoneNumber());

        return createdOrderDetails;

    }

    public void updateOrderDetails(OrderDetails orderDetails, OrderDeliveryStatus orderStatus, Location location) {

        orderDetails.setDeliveryPersonLocation(location);

        if(orderStatus.equals(OrderDeliveryStatus.OUT_FOR_DELIVERY)) {
            orderDetails.setOrderStatus(OrderDeliveryStatus.OUT_FOR_DELIVERY);
        }
        else if(orderStatus.equals(OrderDeliveryStatus.DELIVERED)) {
            orderDetails.setOrderStatus(OrderDeliveryStatus.DELIVERED);
            orderDetails.setDeliveredAt(System.currentTimeMillis());
        }
        else if(orderStatus.equals(OrderDeliveryStatus.UNDELIVERED)) {
            orderDetails.setOrderStatus(OrderDeliveryStatus.UNDELIVERED);

        }
    }
}
