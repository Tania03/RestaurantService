package com.delivery.controller.enums;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
public enum ErrorCode {

    EMPTY_ORDER_ID("OrderId is empty"),
    EMPTY_LOCATION("Location is empty"),
    ERROR_OCCURRED("Error occurred while processing request. Please try after sometime.");

    String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
