package com.delivery.controller.validator;

import com.delivery.controller.enums.ErrorCode;
import com.delivery.controller.enums.ResponseCode;
import com.delivery.controller.response.ServiceResponse;
import com.delivery.enums.DeliveryPersonStatus;
import com.delivery.controller.response.DeliveryPersonAcceptOrderResponse;
import com.delivery.enums.OrderDeliveryStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Component
public class ResponseGenerator {

    public DeliveryPersonAcceptOrderResponse invalidAcceptOrderResponse(ErrorCode errorCode) {
        return new DeliveryPersonAcceptOrderResponse(errorCode.getMessage(), HttpStatus.BAD_REQUEST);
    }

    public DeliveryPersonAcceptOrderResponse acceptOrderResponse(OrderDeliveryStatus orderDeliveryStatus) {
        return  new DeliveryPersonAcceptOrderResponse("Success", HttpStatus.OK, orderDeliveryStatus);
    }

    public ServiceResponse updateDeliveryStatusSuccessResponse(ResponseCode response) {
        return new ServiceResponse(response.getMessage(), HttpStatus.OK);
    }

    public ServiceResponse updateDeliveryStatusFailureResponse(ErrorCode errorOccurred) {
        return new ServiceResponse(errorOccurred.getMessage(), HttpStatus.OK);
    }
}
