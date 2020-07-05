package com.restaurant.controller.validator;

import com.restaurant.client.response.*;
import com.restaurant.controller.enums.ErrorCode;
import com.restaurant.controller.enums.ResponseCode;
import com.restaurant.model.ActiveDeliveryStatus;
import com.restaurant.model.CreatedOrderDetails;
import com.restaurant.model.OrderDetails;
import com.restaurant.model.enums.OrderDeliveryStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Component
public class ResponseGenerator {

    public PlaceOrderResponse invalidPlaceOrderResponse(ErrorCode errorCode) {
        return new PlaceOrderResponse(errorCode.getMessage(), HttpStatus.BAD_REQUEST);
    }

    public PlaceOrderResponse PlaceOrderSuccessResponse(CreatedOrderDetails orderDetails){

        PlaceOrderResponse response = new PlaceOrderResponse();

        response.setMessage(ResponseCode.PLACE_ORDER_SUCCESS.getMessage());
        response.setCode(HttpStatus.OK);
        response.setOrderId(orderDetails.getOrderId());
        response.setOrderStatus(orderDetails.getOrderStatus());
        response.setDeliveryPersonId(orderDetails.getDeliveryPersonId());
        response.setDeliveryPersonPhoneNumber(orderDetails.getDeliveryPersonPhone());
        response.setExpectedDeliveryTime(orderDetails.getPromisedDeliveryTime());

        return response;

    }

    public PlaceOrderResponse PlaceOrderFailureResponse(ErrorCode errorCode) {
        return new PlaceOrderResponse(errorCode.getMessage(), OrderDeliveryStatus.REJECTED);
    }

    public OrderStatusResponse invalidOrderIdResponse(ErrorCode errorCode) {
        return new OrderStatusResponse(errorCode.getMessage(), HttpStatus.BAD_REQUEST);
    }

    public OrderStatusResponse getOrderStatusSuccessResponse(OrderDetails orderDetails) {

        OrderStatusResponse orderStatusResponse = new OrderStatusResponse();
        orderStatusResponse.setStatus(orderDetails.getOrderStatus());
        orderStatusResponse.setOrderId(orderDetails.getOrderId());
        orderStatusResponse.setDeliveryPersonId(orderDetails.getDeliveryPersonId());
        if(orderDetails.getOrderStatus().equals(OrderDeliveryStatus.OUT_FOR_DELIVERY))
            orderStatusResponse.setLocation(orderDetails.getDeliveryPersonLocation());
        if(!orderDetails.getOrderStatus().equals(OrderDeliveryStatus.DELIVERED))
            orderStatusResponse.setExpectedDeliveryTime(orderDetails.getPromisedDeliveryTime());
        return orderStatusResponse;

    }

    public OrderStatusResponse getOrderStatusFailureResponse(ErrorCode errorOccurred) {
        return new OrderStatusResponse(errorOccurred.getMessage());
    }

    public ServiceResponse invalidUpdateDeliveryResponse(ErrorCode errorCode) {
        return new ServiceResponse(errorCode.getMessage(), HttpStatus.BAD_REQUEST);
    }

    public ServiceResponse updateDeliverySuccessResponse() {
        return new ServiceResponse(ResponseCode.DELIVERY_STATUS_UPDATE_SUCCESS.getMessage(), HttpStatus.OK);
    }

    public ServiceResponse updateDeliveryFailureResponse(ErrorCode errorCode) {
        return new ServiceResponse(errorCode.getMessage());
    }

    public List<ActiveDeliveryStatusResponse> activeDeliveryStatusResponse(
            List<ActiveDeliveryStatus> activeDeliveryStatusList) {

        List<ActiveDeliveryStatusResponse> activeDeliveryStatusResponseList = new ArrayList<>();

        for(ActiveDeliveryStatus activeDeliveryStatus : activeDeliveryStatusList){

            ActiveDeliveryStatusResponse activeDeliveryStatusResponse = new ActiveDeliveryStatusResponse();
            activeDeliveryStatusResponse.setOrderId(activeDeliveryStatus.getOrderId());
            activeDeliveryStatusResponse.setPersonId(activeDeliveryStatus.getPersonId());
            activeDeliveryStatusResponse.setLocation(activeDeliveryStatus.getLocation());
            activeDeliveryStatusResponse.setEtaInSeconds(activeDeliveryStatus.getEtaInSeconds());

            activeDeliveryStatusResponseList.add(activeDeliveryStatusResponse);
        }

        return activeDeliveryStatusResponseList;
    }


    public DeliveryPersonRegisterResponse invalidDeliveryPersonRegisterRequest(ErrorCode errorCode) {
        return new DeliveryPersonRegisterResponse(errorCode.getMessage(), HttpStatus.BAD_REQUEST);
    }

    public DeliveryPersonRegisterResponse registerDeliveryPersonSuccessResponse(String deliveryPersonId) {
        return new DeliveryPersonRegisterResponse( ResponseCode.DELIVERY_PERSON_REGISTRATION_SUCCESS.getMessage(),
                HttpStatus.OK, deliveryPersonId);
    }

    public DeliveryPersonRegisterResponse registerDeliveryPersonErrorResponse(ErrorCode errorCode) {
        return new DeliveryPersonRegisterResponse(errorCode.getMessage());
    }

}
