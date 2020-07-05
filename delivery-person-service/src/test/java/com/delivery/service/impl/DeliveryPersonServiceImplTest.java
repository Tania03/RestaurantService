package com.delivery.service.impl;

import com.delivery.controller.request.DeliveryStatusUpdateRequest;
import com.delivery.enums.DeliveryPersonStatus;
import com.delivery.enums.DeliveryServiceConstant;
import com.delivery.enums.OrderDeliveryStatus;
import com.delivery.model.DeliveryPersonDetails;
import com.delivery.model.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * @author tania.gupta
 * @date 01/07/20
 */
class DeliveryPersonServiceImplTest {

    @Mock
    DeliveryPersonDetails deliveryPersonDetails;
    @Mock
    DeliveryServiceHelper deliveryServiceHelper;
    @Mock
    RestaurantService restaurantService;
    @InjectMocks
    DeliveryPersonServiceImpl deliveryPersonServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testInit() {
        try {
            deliveryPersonServiceImpl.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDeliveryOrder() {

        String orderId = "Order123";
        Location location = new Location(34.23,67.23);

        OrderDeliveryStatus result = deliveryPersonServiceImpl.deliveryOrder(orderId, location);
        Assertions.assertEquals(OrderDeliveryStatus.ACCEPTED, result);
    }

    @Test
    void testSetDeliveryPersonId() {
        deliveryPersonServiceImpl.setDeliveryPersonId("DeliveryPerson123");
    }

}
