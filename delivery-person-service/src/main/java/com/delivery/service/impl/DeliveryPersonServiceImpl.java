package com.delivery.service.impl;

import com.delivery.controller.request.DeliveryStatusUpdateRequest;
import com.delivery.enums.DeliveryPersonStatus;
import com.delivery.enums.DeliveryServiceConstant;
import com.delivery.enums.OrderDeliveryStatus;
import com.delivery.model.DeliveryPersonDetails;
import com.delivery.model.Location;
import com.delivery.service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Service
public class DeliveryPersonServiceImpl implements DeliveryPersonService {

    private DeliveryPersonDetails deliveryPersonDetails;

    @Autowired
    DeliveryServiceHelper deliveryServiceHelper;

    @Autowired
    RestaurantService restaurantService;

    @Value(value = "${delivery.person.service.host}")
    String deliveryPersonServiceHost;

    @Value(value = "${delivery.person.service.port}")
    String deliveryPersonServicePort;

    @PostConstruct
    public void init() throws Exception{
        deliveryPersonDetails = new DeliveryPersonDetails();
        deliveryPersonDetails.setHost(deliveryPersonServiceHost);
        deliveryPersonDetails.setPort(deliveryPersonServicePort);
        deliveryPersonDetails.setName(DeliveryServiceConstant.DELIVERY_PERSON_NAME);
        deliveryPersonDetails.setPhoneNumber(DeliveryServiceConstant.DELIVERY_PERSON_PHONE_NUMBER);
        deliveryPersonDetails.setLocation(new Location(24.56, 78.89));
        deliveryPersonDetails.setDeliveryPersonStatus(DeliveryPersonStatus.AVAILABLE);
        restaurantService.registerClient(deliveryPersonDetails);
    }


    @Override
    public OrderDeliveryStatus deliveryOrder(String orderId, Location location) {

        //Assuming to always accept the order
        deliveryPersonDetails.setDeliveryPersonStatus(DeliveryPersonStatus.ACTIVE);
        deliveryPersonDetails.setOrderDeliveryStatus(OrderDeliveryStatus.ACCEPTED);
        deliveryPersonDetails.setOrderId(orderId);
        deliveryPersonDetails.setCustomerLocation(location);
        return OrderDeliveryStatus.ACCEPTED;
    }

    @Override
    public DeliveryPersonDetails getDeliveryPersonStatus() {
        return deliveryPersonDetails;
    }


    @Override
    public void setDeliveryPersonId(String deliveryPersonId) {
        deliveryPersonDetails.setDeliveryPersonId(deliveryPersonId);
    }

    @Override
    public String updateDeliveryStatus(OrderDeliveryStatus orderDeliveryStatus, Location location) {

        if(orderDeliveryStatus.equals(OrderDeliveryStatus.DELIVERED))
            deliveryPersonDetails.setDeliveryPersonStatus(DeliveryPersonStatus.AVAILABLE);

        deliveryPersonDetails.setOrderDeliveryStatus(orderDeliveryStatus);
        deliveryPersonDetails.setLocation(location);
        
        DeliveryStatusUpdateRequest deliveryStatusUpdateRequest =
                deliveryServiceHelper.createDeliveryStatusUpdateRequest(deliveryPersonDetails);
        String response = restaurantService.updateDeliveryStatus(deliveryStatusUpdateRequest);
        
        if(StringUtils.isEmpty(response))
            return null;
        
        return response;
    }


}
