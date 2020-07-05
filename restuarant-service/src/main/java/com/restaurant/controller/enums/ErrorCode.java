package com.restaurant.controller.enums;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
public enum ErrorCode {

    // Create/Get/Update Order specific Error codes
    INVALID_CUSTOMER_ID("Please check the customer id."), INVALID_ADDRESS_ID("Please check the address."),
    INSUFFICIENT_ITEM("Insufficient items added to cart."),
    NO_DELIVERY_PERSON_AVAILABLE("All Delivery Person are occupied at the moment. Please try after some time."),
    NO_SUCH_ORDER_ID_FOUND("Please check the orderId."),
    EMPTY_ORDER_ID("Order Id is empty."),
    EMPTY_DELIVERY_PERSON_ID("Delivery Person Id is empty."),
    INSUFFICIENT_UPDATE_REQUEST("Insufficient parameters to update delivery status."),
    REGISTRATION_FAILED("Error occurred while registering delivery person."),
    DELIVERY_STATUS_UPDATE_FAILED("Error occurred while updating delivering status."),

    //Delivery Person Register Error codes
    EMPTY_HOST("Host cannot be empty."), EMPTY_PORT("Port cannot be empty."),
    EMPTY_PHONE_NUMBER("Please provide phone number."), EMPTY_LOCATION("Please provide current location."),
    EMPTY_NAME("Please provide name.");


    String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
