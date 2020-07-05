package com.delivery.service;

import com.delivery.controller.request.DeliveryStatusUpdateRequest;
import com.delivery.enums.DeliveryPersonStatus;
import com.delivery.enums.OrderDeliveryStatus;
import com.delivery.model.DeliveryPersonDetails;
import com.delivery.model.Location;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
public interface DeliveryPersonService {
    
    OrderDeliveryStatus deliveryOrder(String orderId, Location location);

    DeliveryPersonDetails getDeliveryPersonStatus();

    void setDeliveryPersonId(String deliveryPersonId);

    String updateDeliveryStatus(OrderDeliveryStatus orderDeliveryStatus, Location location);
}
