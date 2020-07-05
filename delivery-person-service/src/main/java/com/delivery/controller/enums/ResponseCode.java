package com.delivery.controller.enums;

/**
 * @author tania.gupta
 * @date 01/07/20
 */
public enum ResponseCode {

    DELIVERY_STATUS_UPDATE_SUCCESS("Delivery Status updated successfully.");

    String message;

    ResponseCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
