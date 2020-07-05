package com.restaurant.core.helper;

import com.restaurant.constant.Constant;
import com.restaurant.core.OrderService;
import com.restaurant.model.ActiveDeliveryStatus;
import com.restaurant.model.DeliveryPersonDetails;
import com.restaurant.model.Location;
import com.restaurant.model.enums.DeliveryPersonStatus;
import com.restaurant.repository.entity.DeliveryPersonStatusDetails;
import com.restaurant.client.request.DeliveryPersonRegisterRequest;
import com.restaurant.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Component
public class DeliveryServiceHelper {

    @Autowired
    OrderService orderService;


    public List<ActiveDeliveryStatus> createActiveDeliveryStatusList(List<DeliveryPersonStatusDetails> deliveryStatusList) {

        List<ActiveDeliveryStatus> activeDeliveryStatusList = new ArrayList<>();

        for(DeliveryPersonStatusDetails deliveryStatus : deliveryStatusList){
            ActiveDeliveryStatus activeDeliveryStatus = new ActiveDeliveryStatus();
            activeDeliveryStatus.setOrderId(deliveryStatus.getOrderId());
            activeDeliveryStatus.setPersonId(deliveryStatus.getDeliveryPersonId());
            activeDeliveryStatus.setLocation(deliveryStatus.getLocation());
            activeDeliveryStatus.setDeliveryPersonStatus(deliveryStatus.getStatus());
            Long etaInSeconds = calculateETA(deliveryStatus.getOrderId(), deliveryStatus.getLocation());
            activeDeliveryStatus.setEtaInSeconds(etaInSeconds);

            activeDeliveryStatusList.add(activeDeliveryStatus);
        }
        return activeDeliveryStatusList;
    }

    public long calculateETA(String orderId, Location deliveryPersonLocation) {

        Double customerDeliveryPersonDistance = calculateDistance(orderId, deliveryPersonLocation);
        return Double.valueOf(customerDeliveryPersonDistance / Constant.DEDAULT_SPEED ).longValue();

    }


    private double calculateDistance(String orderId, Location deliveryPersonLocation) {

        Location customerLocation = orderService.getOrderLocationByOrderId(orderId);

        double longitudeDistance = deliveryPersonLocation.getLongitude() - customerLocation.getLongitude();
        double latitudeDistance = deliveryPersonLocation.getLatitude() - customerLocation.getLatitude();
        double a = Math.pow(Math.sin(latitudeDistance / 2), 2)
                + Math.cos(customerLocation.getLatitude()) * Math.cos(deliveryPersonLocation.getLatitude())
                * Math.pow(Math.sin(longitudeDistance / 2),2);

        double circumference = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers
        double radius = 6371;

        // calculate the result
        return(circumference * radius);

    }


    public DeliveryPersonDetails createDeliveryPersonDetails(DeliveryPersonRegisterRequest
                                                                     deliveryPersonRegisterRequest) {

        String deliveryPersonId = CommonUtil.generateNewUUID();

        DeliveryPersonDetails deliveryPersonDetails = new DeliveryPersonDetails();

        deliveryPersonDetails.setDeliveryPersonId(deliveryPersonId);
        deliveryPersonDetails.setHost(deliveryPersonRegisterRequest.getHost());
        deliveryPersonDetails.setPort(deliveryPersonRegisterRequest.getPort());
        deliveryPersonDetails.setDeliveryPersonStatus(deliveryPersonRegisterRequest.getStatus());
        deliveryPersonDetails.setPhoneNumber(deliveryPersonRegisterRequest.getPhoneNumber());
        deliveryPersonDetails.setName(deliveryPersonRegisterRequest.getName());
        deliveryPersonDetails.setLocation(deliveryPersonRegisterRequest.getLocation());
        deliveryPersonDetails.setDeliveryPersonStatus(DeliveryPersonStatus.AVAILABLE);

        return deliveryPersonDetails;

    }
}
