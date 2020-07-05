package com.restaurant.controller;

import com.restaurant.client.response.*;
import com.restaurant.constant.URIConstant;
import com.restaurant.controller.enums.ErrorCode;
import com.restaurant.controller.validator.ResponseGenerator;
import com.restaurant.controller.validator.RequestValidator;
import com.restaurant.core.DeliveryPersonService;
import com.restaurant.model.ActiveDeliveryStatus;
import com.restaurant.model.CreatedOrderDetails;
import com.restaurant.model.Location;
import com.restaurant.model.OrderDetails;
import com.restaurant.model.enums.OrderDeliveryStatus;
import com.restaurant.repository.entity.DeliveryPersonStatusDetails;
import com.restaurant.client.request.DeliveryPersonRegisterRequest;
import com.restaurant.client.request.DeliveryStatusUpdateRequest;
import com.restaurant.core.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author tania.gupta
 * @date 26/06/20
 */
@RestController
@RequestMapping(URIConstant.BASE)
public class RestaurantController {

    @Autowired
    OrderService orderService;
    
    @Autowired
    DeliveryPersonService deliveryPersonService;

    @Autowired
    RequestValidator requestValidator;
    
    @Autowired
    ResponseGenerator responseGenerator;

    /**
     * Assuming payment is taken by payment service and payment is mandatory to place an order
     * @param customerId id of the customer ordering food
     * @param location location of the customer
     * @param sessionId id for the current session, to validate payment is already done
     * @param items a map of item id and the quantity
     * @return
     */
    @PostMapping(URIConstant.ORDER_PLACE)
    public PlaceOrderResponse placeOrder(String customerId, Location location, String sessionId, Map<String, Integer> items){

        //validate place order request
        ErrorCode errorCode = requestValidator.validate(customerId, location, items);
        if(errorCode != null)
            return responseGenerator.invalidPlaceOrderResponse(errorCode);

        //create order and assign delivery person
        CreatedOrderDetails orderDetails = orderService.createOrder(customerId, location, items);
        
        if(orderDetails.getOrderStatus().equals(OrderDeliveryStatus.ACCEPTED))
            return responseGenerator.PlaceOrderSuccessResponse(orderDetails);

        return responseGenerator.PlaceOrderFailureResponse(ErrorCode.NO_DELIVERY_PERSON_AVAILABLE);
    }

    @GetMapping(URIConstant.ORDER_STATUS)
    public OrderStatusResponse getOrderStatus(String orderId){

        //validate orderId
        ErrorCode errorCode = requestValidator.validate(orderId);
        if(errorCode != null)
            return responseGenerator.invalidOrderIdResponse(errorCode);

        //Get order status
        OrderDetails orderDetails = orderService.getOrderStatus(orderId);

        if(!StringUtils.isEmpty(orderDetails))
            return responseGenerator.getOrderStatusSuccessResponse(orderDetails);

        return responseGenerator.getOrderStatusFailureResponse(ErrorCode.NO_SUCH_ORDER_ID_FOUND);

    }

    @PostMapping(URIConstant.ORDER_UPDATE)
    public ServiceResponse updateDeliveryStatus(@RequestBody DeliveryStatusUpdateRequest deliveryStatusUpdateRequest) {

        //validate orderId
        ErrorCode errorCode = requestValidator.validate(deliveryStatusUpdateRequest);
        if (errorCode != null)
            return responseGenerator.invalidUpdateDeliveryResponse(errorCode);

        DeliveryPersonStatusDetails deliveryPersonStatusDetails = orderService.updateDeliveryStatus(deliveryStatusUpdateRequest.getDeliveryPersonId(),
                deliveryStatusUpdateRequest.getLocation(), deliveryStatusUpdateRequest.getOrderStatus());

        if (deliveryPersonStatusDetails != null)
            return responseGenerator.updateDeliverySuccessResponse();

        return responseGenerator.updateDeliveryFailureResponse(ErrorCode.DELIVERY_STATUS_UPDATE_FAILED);
    }

    @GetMapping(URIConstant.ACTIVE_DELIVERY_PERSON)
    public List<ActiveDeliveryStatusResponse> getAllActiveDeliveryPerson(){

        List<ActiveDeliveryStatus> activeDeliveryStatusList = deliveryPersonService.fetchAllActiveDeliveryPersonDetails();
        return responseGenerator.activeDeliveryStatusResponse(activeDeliveryStatusList);

    }

    @PostMapping(URIConstant.REGISTER_DELIVERY_PERSON)
    public DeliveryPersonRegisterResponse registerDeliveryPerson(@RequestBody DeliveryPersonRegisterRequest deliveryPersonRegisterRequest){

        //validate delivery person register request
        ErrorCode errorCode = requestValidator.validate(deliveryPersonRegisterRequest);
        if(errorCode != null)
            return responseGenerator.invalidDeliveryPersonRegisterRequest(errorCode);

        String deliveryPersonId = deliveryPersonService.populateDeliveryPersonDetails(deliveryPersonRegisterRequest);

        if(deliveryPersonId != null)
           return responseGenerator.registerDeliveryPersonSuccessResponse(deliveryPersonId);

        return responseGenerator.registerDeliveryPersonErrorResponse(ErrorCode.REGISTRATION_FAILED);
    }
}
