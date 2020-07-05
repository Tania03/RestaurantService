package com.restaurant.core;

import com.restaurant.model.ActiveDeliveryStatus;
import com.restaurant.model.DeliveryPersonDetails;
import com.restaurant.model.Location;
import com.restaurant.model.OrderDetails;
import com.restaurant.model.enums.DeliveryPersonStatus;
import com.restaurant.repository.entity.DeliveryPersonStatusDetails;
import com.restaurant.client.request.DeliveryPersonRegisterRequest;

import java.util.List;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
public interface DeliveryPersonService {

    DeliveryPersonDetails assignDeliveryPerson(OrderDetails orderDetails);

    void updateDeliveryPersonStatus(DeliveryPersonStatusDetails deliveryPersonStatusDetails, String orderId,
                                    DeliveryPersonStatus deliveryPersonStatusCode);

    DeliveryPersonStatusDetails findActiveDeliveryPersonStatus(String deliveryPersonId);

    List<ActiveDeliveryStatus> fetchAllActiveDeliveryPersonDetails();

    String populateDeliveryPersonDetails(DeliveryPersonRegisterRequest deliveryPersonRegisterRequest);

    Long calculateETA(String orderId, Location deliveryPersonLocation);
}
