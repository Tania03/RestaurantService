package com.restaurant.repository;

import com.restaurant.model.DeliveryPersonDetails;
import com.restaurant.model.enums.DeliveryPersonStatus;
import com.restaurant.repository.entity.DeliveryPerson;
import com.restaurant.repository.entity.DeliveryPersonStatusDetails;

import java.util.List;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
public interface DeliveryPersonRepository {

    List<DeliveryPersonDetails> findAllAvailableDeliveryPerson();

    DeliveryPerson findDeliveryPersonById(String deliveryPersonId);

    DeliveryPersonStatusDetails findDeliveryPersonStatusById(String deliveryPersonId);

    List<DeliveryPersonStatusDetails> findAllActiveDeliveryPerson();

    DeliveryPerson saveDeliveryPersonDetails(DeliveryPersonDetails deliveryPersonDetails);

    DeliveryPersonStatusDetails saveDeliveryPersonStatusDetails(DeliveryPersonDetails deliveryPersonDetails);

    void updateDeliveryPersonStatus(DeliveryPersonStatusDetails deliveryPersonStatusDetails, String orderId, DeliveryPersonStatus deliveryPersonStatusCode);
}
