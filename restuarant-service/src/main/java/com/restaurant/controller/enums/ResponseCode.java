package com.restaurant.controller.enums;

/**
 * @author tania.gupta
 * @date 30/06/20
 */
public enum ResponseCode {

    PLACE_ORDER_SUCCESS("Order placed successfully."),
    DELIVERY_STATUS_UPDATE_SUCCESS("Delivery Status updated successfully."),
    DELIVERY_PERSON_REGISTRATION_SUCCESS("Delivery Person Registered Successfully.");

    String message;

    ResponseCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
