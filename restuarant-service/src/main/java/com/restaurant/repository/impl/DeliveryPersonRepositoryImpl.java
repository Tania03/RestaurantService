package com.restaurant.repository.impl;

import com.restaurant.model.DeliveryPersonDetails;
import com.restaurant.model.enums.DeliveryPersonStatus;
import com.restaurant.repository.DeliveryPersonRepository;
import com.restaurant.repository.entity.DeliveryPerson;
import com.restaurant.repository.entity.DeliveryPersonStatusDetails;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
@Repository
public class DeliveryPersonRepositoryImpl implements DeliveryPersonRepository {

    Map<String, DeliveryPerson> deliveryPersonMap;

    Map<String, DeliveryPersonStatusDetails> deliveryPersonStatusMap;

    @PostConstruct
    public void init(){
        deliveryPersonMap = new HashMap<>();
        deliveryPersonStatusMap = new HashMap<>();
    }


    @Override
    public DeliveryPerson saveDeliveryPersonDetails(DeliveryPersonDetails deliveryPersonDetails) {

        DeliveryPerson deliveryPerson = new DeliveryPerson();
        deliveryPerson.setDeliveryPersonId(deliveryPersonDetails.getDeliveryPersonId());
        deliveryPerson.setName(deliveryPersonDetails.getName());
        deliveryPerson.setPhoneNumber(deliveryPersonDetails.getPhoneNumber());
        deliveryPerson.setHost(deliveryPersonDetails.getHost());
        deliveryPerson.setPort(deliveryPersonDetails.getPort()
        );

        deliveryPersonMap.put(deliveryPerson.getDeliveryPersonId(), deliveryPerson);

        return deliveryPerson;

    }

    @Override
    public DeliveryPersonStatusDetails saveDeliveryPersonStatusDetails(DeliveryPersonDetails deliveryPersonDetails) {

        DeliveryPersonStatusDetails deliveryPersonStatusDetails = new DeliveryPersonStatusDetails();
        deliveryPersonStatusDetails.setStatus(deliveryPersonDetails.getDeliveryPersonStatus());
        deliveryPersonStatusDetails.setLocation(deliveryPersonDetails.getLocation());
        deliveryPersonStatusDetails.setDeliveryPersonId(deliveryPersonDetails.getDeliveryPersonId());

        deliveryPersonStatusMap.put(deliveryPersonStatusDetails.getDeliveryPersonId(), deliveryPersonStatusDetails);

        return deliveryPersonStatusDetails;
    }

    @Override
    public void updateDeliveryPersonStatus(DeliveryPersonStatusDetails deliveryPersonStatusDetails, String orderId, DeliveryPersonStatus deliveryPersonStatusCode) {

        String deliveryPersonId = deliveryPersonStatusDetails.getDeliveryPersonId();

        if(!deliveryPersonStatusMap.containsKey(deliveryPersonId))
            return;

        DeliveryPersonStatusDetails currentDeliveryPersonStatusDetails = deliveryPersonStatusMap.get(deliveryPersonId);

        currentDeliveryPersonStatusDetails.setOrderId(orderId);
        currentDeliveryPersonStatusDetails.setStatus(deliveryPersonStatusCode);
    }

    @Override
    public List<DeliveryPersonDetails> findAllAvailableDeliveryPerson(){

        if(deliveryPersonMap.size() == 0)
            return null;

         List<DeliveryPersonStatusDetails> deliveryPersonStatusDetailsList = deliveryPersonStatusMap.values().stream()
                .filter( e -> e.getStatus().equals(DeliveryPersonStatus.AVAILABLE) )
                .collect(Collectors.toList());

        return createDeliveryPersonDetails(deliveryPersonStatusDetailsList);
    }

    private List<DeliveryPersonDetails> createDeliveryPersonDetails(List<DeliveryPersonStatusDetails> deliveryPersonStatusDetailsList) {

        List<DeliveryPersonDetails> deliveryPersonDetailsList = new ArrayList<>();

        for(DeliveryPersonStatusDetails deliveryPersonStatusDetails : deliveryPersonStatusDetailsList){
            DeliveryPersonDetails deliveryPersonDetails = new DeliveryPersonDetails();
            deliveryPersonDetails.setLocation(deliveryPersonStatusDetails.getLocation());
            deliveryPersonDetails.setDeliveryPersonId(deliveryPersonStatusDetails.getDeliveryPersonId());

            DeliveryPerson deliveryPerson = getDeliveryPersonByDeliveryPersonId(
                    deliveryPersonStatusDetails.getDeliveryPersonId());
            deliveryPersonDetails.setHost(deliveryPerson.getHost());
            deliveryPersonDetails.setPort(deliveryPerson.getPort());
            deliveryPersonDetails.setName(deliveryPerson.getName());
            deliveryPersonDetails.setPhoneNumber(deliveryPerson.getPhoneNumber());

            deliveryPersonDetailsList.add(deliveryPersonDetails);
        }
        return deliveryPersonDetailsList;
    }

    private DeliveryPerson getDeliveryPersonByDeliveryPersonId(String deliveryPersonId) {
        if(!deliveryPersonMap.containsKey(deliveryPersonId))
            return null;

        return deliveryPersonMap.get(deliveryPersonId);
    }

    @Override
    public DeliveryPersonStatusDetails findDeliveryPersonStatusById(String deliveryPersonId) {

        if(deliveryPersonStatusMap.size() == 0)
            return null;

        if(deliveryPersonStatusMap.containsKey(deliveryPersonId))
            return deliveryPersonStatusMap.get(deliveryPersonId);

        return null;
    }

    @Override
    public DeliveryPerson findDeliveryPersonById(String deliveryPersonId) {

        if(deliveryPersonMap.containsKey(deliveryPersonId))
            return deliveryPersonMap.get(deliveryPersonId);

        return null;
    }

    @Override
    public List<DeliveryPersonStatusDetails> findAllActiveDeliveryPerson() {

        return deliveryPersonStatusMap.values().stream()
                .filter( e -> e.getStatus().equals(DeliveryPersonStatus.ACTIVE) )
                .collect(Collectors.toList());
    }



}
