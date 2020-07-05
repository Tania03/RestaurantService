package com.delivery.service.impl;

import com.delivery.controller.request.DeliveryStatusUpdateRequest;
import com.delivery.model.DeliveryPersonDetails;
import org.springframework.stereotype.Service;

/**
 * @author tania.gupta
 * @date 01/07/20
 */
@Service
public class DeliveryServiceHelper {


    public DeliveryStatusUpdateRequest createDeliveryStatusUpdateRequest(DeliveryPersonDetails deliveryPersonDetails) {
        DeliveryStatusUpdateRequest deliveryStatusUpdateRequest = new DeliveryStatusUpdateRequest();

        deliveryStatusUpdateRequest.setDeliveryPersonId(deliveryPersonDetails.getDeliveryPersonId());
        deliveryStatusUpdateRequest.setLocation(deliveryPersonDetails.getLocation());
        deliveryStatusUpdateRequest.setOrderStatus(deliveryPersonDetails.getOrderDeliveryStatus());

        return deliveryStatusUpdateRequest;
    }
}
