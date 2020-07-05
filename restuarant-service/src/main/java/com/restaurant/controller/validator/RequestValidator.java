package com.restaurant.controller.validator;

import com.restaurant.controller.enums.ErrorCode;
import com.restaurant.core.OrderService;
import com.restaurant.model.Location;
import com.restaurant.client.request.DeliveryPersonRegisterRequest;
import com.restaurant.client.request.DeliveryStatusUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Component
public class RequestValidator {

    @Autowired
    OrderService orderService;

    public ErrorCode validate(String customerId, Location location, Map<String, Integer> items) {

        if(StringUtils.isEmpty(customerId))
            return ErrorCode.INVALID_CUSTOMER_ID;
        if(location.getLatitude() == null || location.getLongitude() == null)
            return ErrorCode.INVALID_ADDRESS_ID;
        if(items.size() < 1)
            return ErrorCode.INSUFFICIENT_ITEM;

        return null;
    }

    public ErrorCode validate(String orderId) {

        if(StringUtils.isEmpty(orderId))
            return ErrorCode.EMPTY_ORDER_ID;

        return null;
    }

    public ErrorCode validate(DeliveryStatusUpdateRequest deliveryStatusUpdateRequest) {

        if(StringUtils.isEmpty(deliveryStatusUpdateRequest.getDeliveryPersonId()))
            return ErrorCode.EMPTY_DELIVERY_PERSON_ID;

        if(StringUtils.isEmpty(deliveryStatusUpdateRequest.getLocation())
                && StringUtils.isEmpty(deliveryStatusUpdateRequest.getOrderStatus()))
            return ErrorCode.INSUFFICIENT_UPDATE_REQUEST;

        return null;
    }

    public ErrorCode validate(DeliveryPersonRegisterRequest deliveryPersonRegisterRequest) {

        if(StringUtils.isEmpty(deliveryPersonRegisterRequest.getHost()))
            return ErrorCode.EMPTY_HOST;

        if(StringUtils.isEmpty(deliveryPersonRegisterRequest.getPort()))
            return ErrorCode.EMPTY_PORT;

        if(StringUtils.isEmpty(deliveryPersonRegisterRequest.getPhoneNumber()))
            return ErrorCode.EMPTY_PHONE_NUMBER;

        if(StringUtils.isEmpty(deliveryPersonRegisterRequest.getLocation()))
            return ErrorCode.EMPTY_LOCATION;

        if(StringUtils.isEmpty(deliveryPersonRegisterRequest.getName()))
            return ErrorCode.EMPTY_NAME;

        return null;

    }
}
