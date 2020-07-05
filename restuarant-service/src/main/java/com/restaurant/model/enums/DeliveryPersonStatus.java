package com.restaurant.model.enums;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
public enum DeliveryPersonStatus {

    /**
     * ACTIVE - Currently delivering an order
     * AVAILABLE - Available to immediately deliver an order
     * OFFLINE - Unavailable to deliver an order currently
     */
    ACCEPTED, REJECTED, ACTIVE, AVAILABLE, OFFLINE;
}
