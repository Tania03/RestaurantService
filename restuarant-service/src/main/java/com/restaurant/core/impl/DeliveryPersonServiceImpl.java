package com.restaurant.core.impl;

import com.restaurant.client.DeliveryServiceClient;
import com.restaurant.core.DeliveryPersonService;
import com.restaurant.core.helper.DeliveryServiceHelper;
import com.restaurant.model.ActiveDeliveryStatus;
import com.restaurant.model.DeliveryPersonDetails;
import com.restaurant.model.Location;
import com.restaurant.model.OrderDetails;
import com.restaurant.model.enums.DeliveryPersonStatus;
import com.restaurant.model.enums.OrderDeliveryStatus;
import com.restaurant.repository.DeliveryPersonRepository;
import com.restaurant.repository.entity.DeliveryPersonStatusDetails;
import com.restaurant.client.request.DeliveryPersonRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
@Service
public class DeliveryPersonServiceImpl implements DeliveryPersonService {

    DeliveryServiceHelper deliveryServiceHelper;

    DeliveryPersonRepository deliveryPersonRepository;

    DeliveryServiceClient deliveryServiceClient;

    @Autowired
    public DeliveryPersonServiceImpl(DeliveryServiceHelper deliveryServiceHelper, DeliveryPersonRepository
            deliveryPersonRepository, DeliveryServiceClient deliveryServiceClient) {
        this.deliveryServiceHelper = deliveryServiceHelper;
        this.deliveryPersonRepository = deliveryPersonRepository;
        this.deliveryServiceClient = deliveryServiceClient;
    }


    @Override
    public DeliveryPersonDetails assignDeliveryPerson(OrderDetails orderDetails) {

        //Fetch available delivery person
        List<DeliveryPersonDetails> deliveryPersonDetailsList = fetchAllAvailableDeliveryPerson();

        if(deliveryPersonDetailsList == null)
            return null;

        DeliveryPersonDetails assignedDeliveryPerson = null;

        //Iterating through all the delivery persons until the order is unaccepted
        for(DeliveryPersonDetails deliveryPersonDetails : deliveryPersonDetailsList) {
            OrderDeliveryStatus orderDeliveryStatus = deliveryServiceClient.deliverOrderRequest(deliveryPersonDetails, orderDetails);
            if(orderDeliveryStatus.equals(OrderDeliveryStatus.ACCEPTED)) {
                assignedDeliveryPerson = deliveryPersonDetails;
                break;
            }
        }

        if(assignedDeliveryPerson == null)
            return null;

        // Update Status of Assigned Delivery Person
        updatedAssignedDeliveryPersonStatus(assignedDeliveryPerson, orderDetails);

        return assignedDeliveryPerson;

    }

    private void updatedAssignedDeliveryPersonStatus(DeliveryPersonDetails assignedDeliveryPerson, OrderDetails orderDetails) {
        //Fetch delivery person details
        DeliveryPersonStatusDetails deliveryPersonStatusDetails = deliveryPersonRepository.
                findDeliveryPersonStatusById( assignedDeliveryPerson.getDeliveryPersonId());

        //Update delivery person status
        updateDeliveryPersonStatus(deliveryPersonStatusDetails,
                orderDetails.getOrderId(), DeliveryPersonStatus.ACTIVE);
    }


    @Override
    public void updateDeliveryPersonStatus(DeliveryPersonStatusDetails deliveryPersonStatusDetails, String orderId,
                                           DeliveryPersonStatus deliveryPersonStatusCode) {

       deliveryPersonRepository.updateDeliveryPersonStatus(deliveryPersonStatusDetails, orderId, deliveryPersonStatusCode);

    }

    @Override
    public DeliveryPersonStatusDetails findActiveDeliveryPersonStatus(String deliveryPersonId) {

        return  deliveryPersonRepository.findDeliveryPersonStatusById(deliveryPersonId);
    }


    private List<DeliveryPersonDetails> fetchAllAvailableDeliveryPerson() {

        return  deliveryPersonRepository.findAllAvailableDeliveryPerson();
    }

    @Override
    public List<ActiveDeliveryStatus> fetchAllActiveDeliveryPersonDetails() {

        List<DeliveryPersonStatusDetails> activeDeliveryList = deliveryPersonRepository.findAllActiveDeliveryPerson();
        return deliveryServiceHelper.createActiveDeliveryStatusList(activeDeliveryList);

    }

    @Override
    public String populateDeliveryPersonDetails(DeliveryPersonRegisterRequest deliveryPersonRegisterRequest) {
        DeliveryPersonDetails deliveryPersonDetails = deliveryServiceHelper
                .createDeliveryPersonDetails(deliveryPersonRegisterRequest);

        //update delivery person details
        deliveryPersonRepository.saveDeliveryPersonDetails(deliveryPersonDetails);

        //update delivery person status details
        deliveryPersonRepository.saveDeliveryPersonStatusDetails(deliveryPersonDetails);

        return deliveryPersonDetails.getDeliveryPersonId();
    }

    @Override
    public Long calculateETA(String orderId, Location deliveryPersonLocation) {
        return deliveryServiceHelper.calculateETA(orderId, deliveryPersonLocation);
    }

}
