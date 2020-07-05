package com.delivery.controller;

import com.delivery.controller.enums.ErrorCode;
import com.delivery.controller.enums.ResponseCode;
import com.delivery.controller.enums.URIConstant;
import com.delivery.controller.response.ServiceResponse;
import com.delivery.controller.validator.RequestValidator;
import com.delivery.controller.validator.ResponseGenerator;
import com.delivery.enums.OrderDeliveryStatus;
import com.delivery.model.DeliveryPersonDetails;
import com.delivery.controller.response.DeliveryPersonAcceptOrderResponse;
import com.delivery.model.Location;
import com.delivery.service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * @author tania.gupta
 * @date 27/06/20
 */

@RestController
@RequestMapping(URIConstant.BASE)
public class DeliveryController {

    @Autowired
    DeliveryPersonService deliveryPersonService;

    @Autowired
    RequestValidator validator;

    @Autowired
    ResponseGenerator responseGenerator;

    @PostMapping(URIConstant.DELIVER_ORDER)
    public DeliveryPersonAcceptOrderResponse acceptOrder(@RequestBody AcceptOrderRequest acceptOrderRequest){

        ErrorCode errorCode = validator.isValidDeliverOrderRequest(acceptOrderRequest);

        if(errorCode != null)
            return responseGenerator.invalidAcceptOrderResponse(errorCode);

        OrderDeliveryStatus orderDeliveryStatus = deliveryPersonService.deliveryOrder(acceptOrderRequest.getOrderId(),
               acceptOrderRequest.getLocation());

        return responseGenerator.acceptOrderResponse(orderDeliveryStatus);
    }

    @GetMapping(URIConstant.DELIVERY_PERSON_STATUS)
    public DeliveryPersonDetails getDeliveryPersonStatus(){

        DeliveryPersonDetails deliveryPersonDetails = deliveryPersonService.getDeliveryPersonStatus();

        return deliveryPersonDetails;
    }

    @PostMapping(URIConstant.UPDATE_DELIVERY_STATUS)
    public ServiceResponse updateDeliveryStatus(OrderDeliveryStatus orderStatus, Location location){

        String response = deliveryPersonService.updateDeliveryStatus(orderStatus, location);

        if(!StringUtils.isEmpty(response))
            return responseGenerator.updateDeliveryStatusSuccessResponse(ResponseCode.DELIVERY_STATUS_UPDATE_SUCCESS);

        return responseGenerator.updateDeliveryStatusFailureResponse(ErrorCode.ERROR_OCCURRED);
    }

}
