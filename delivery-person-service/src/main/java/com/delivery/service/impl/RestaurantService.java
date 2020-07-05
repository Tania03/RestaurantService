package com.delivery.service.impl;

import com.delivery.client.RestaurantClient;
import com.delivery.client.model.DeliveryPersonRegisterResponse;
import com.delivery.controller.request.DeliveryStatusUpdateRequest;
import com.delivery.controller.response.ServiceResponse;
import com.delivery.model.DeliveryPersonDetails;
import com.delivery.service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Service
public class RestaurantService {

    @Autowired
    RestaurantClient restaurantClient;

    @Autowired
    DeliveryPersonService deliveryPersonService;

    public void registerClient(DeliveryPersonDetails deliveryPersonDetails) throws Exception{

        DeliveryPersonRegisterResponse deliveryPersonRegisterResponse = restaurantClient.
                registerDeliveryPerson(deliveryPersonDetails);
        if(deliveryPersonRegisterResponse != null)
            deliveryPersonService.setDeliveryPersonId(deliveryPersonRegisterResponse.getDeliveryPersonId());
        else
            throw new Exception("Error occurred while registering to restaurant service");


    }

    public String updateDeliveryStatus(DeliveryStatusUpdateRequest deliveryStatusUpdateRequest) {

        ServiceResponse serviceResponse =restaurantClient.updateDeliveryStatus(deliveryStatusUpdateRequest);

        if(serviceResponse.getCode() != HttpStatus.OK)
            return null;

        return deliveryStatusUpdateRequest.getDeliveryPersonId();
    }
}
