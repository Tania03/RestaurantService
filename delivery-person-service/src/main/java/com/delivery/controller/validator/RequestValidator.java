package com.delivery.controller.validator;

import com.delivery.controller.AcceptOrderRequest;
import com.delivery.controller.enums.ErrorCode;
import com.delivery.model.Location;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Component
public class RequestValidator {
    public ErrorCode isValidDeliverOrderRequest(AcceptOrderRequest acceptOrderRequest) {

        if(StringUtils.isEmpty(acceptOrderRequest.getOrderId()))
            return ErrorCode.EMPTY_ORDER_ID;

        if(StringUtils.isEmpty(acceptOrderRequest.getLocation()))
            return ErrorCode.EMPTY_LOCATION;

        return null;
    }
}
