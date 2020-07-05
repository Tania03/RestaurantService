package com.restaurant.core.impl;

import com.restaurant.core.DeliveryPersonService;
import com.restaurant.core.helper.OrderServiceHelper;
import com.restaurant.model.CreatedOrderDetails;
import com.restaurant.model.DeliveryPersonDetails;
import com.restaurant.model.Location;
import com.restaurant.model.OrderDetails;
import com.restaurant.model.enums.DeliveryPersonStatus;
import com.restaurant.model.enums.OrderDeliveryStatus;
import com.restaurant.repository.OrderRepository;
import com.restaurant.repository.entity.DeliveryPersonStatusDetails;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * @author tania.gupta
 * @date 01/07/20
 */
class OrderServiceImplTest {
    @Mock
    OrderRepository orderRepository;
    @Mock
    DeliveryPersonService deliveryPersonService;
    @Mock
    OrderServiceHelper orderServiceHelper;
    @InjectMocks
    OrderServiceImpl orderServiceImpl;

    OrderDetails orderDetails;

    DeliveryPersonDetails deliveryPersonDetails;

    DeliveryPersonStatusDetails deliveryPersonStatusDetails;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        orderDetails = new OrderDetails(
                "Order123",
                "Customer123",
                new Location(23.32,32.43),
                new HashMap<String, Integer>(){{put("Cheese", 1);}}
        );

        deliveryPersonDetails = new DeliveryPersonDetails();
        deliveryPersonDetails.setPhoneNumber("6574869811");
        deliveryPersonDetails.setOrderDeliveryStatus(OrderDeliveryStatus.ACCEPTED);
        deliveryPersonDetails.setName("John");
        deliveryPersonDetails.setDeliveryPersonId("DeliveryPerson123");
        deliveryPersonDetails.setLocation(new Location(43.23, 23.43));

        deliveryPersonStatusDetails = new DeliveryPersonStatusDetails();
        deliveryPersonStatusDetails.setLocation(deliveryPersonDetails.getLocation());
        deliveryPersonStatusDetails.setStatus(deliveryPersonDetails.getDeliveryPersonStatus());
        deliveryPersonStatusDetails.setDeliveryPersonId(deliveryPersonDetails.getDeliveryPersonId());

    }

    @Test
    void testCreateOrderWhenDeliveryPersonAvailable() {

        String customerId = "Customer123";
        Location location = new Location(23.32,32.43);
        Map<String, Integer> items = new HashMap<String, Integer>(){{put("Cheese", 1);}};

        CreatedOrderDetails createdOrderDetails = new CreatedOrderDetails(OrderDeliveryStatus.ACCEPTED);
        createdOrderDetails.setOrderId(orderDetails.getOrderId());
        createdOrderDetails.setDeliveryPersonPhone(deliveryPersonDetails.getPhoneNumber());
        createdOrderDetails.setDeliveryPersonId(deliveryPersonDetails.getDeliveryPersonId());

        when(orderServiceHelper.createNewOrderDetails(customerId, location, items)).thenReturn(orderDetails);

        when(deliveryPersonService.assignDeliveryPerson(orderDetails)).thenReturn(deliveryPersonDetails);

        when(orderServiceHelper.createDeliveryOrderDetails(orderDetails, deliveryPersonDetails)).thenReturn(createdOrderDetails);

        CreatedOrderDetails result = orderServiceImpl.createOrder(customerId, location, items);

        Assertions.assertEquals(createdOrderDetails.getOrderStatus(), OrderDeliveryStatus.ACCEPTED);
    }

    @Test
    void testCreateOrderWhenDeliveryPersonNotAvailable() {

        String customerId = "Customer123";
        Location location = new Location(23.32,32.43);
        Map<String, Integer> items = new HashMap<String, Integer>(){{put("Cheese", 1);}};

        when(orderServiceHelper.createNewOrderDetails(customerId, location, items)).thenReturn(orderDetails);

        when(deliveryPersonService.assignDeliveryPerson(orderDetails)).thenReturn(null);

        CreatedOrderDetails result = orderServiceImpl.createOrder(customerId, location, items);

        Assertions.assertEquals(result.getOrderStatus(), OrderDeliveryStatus.REJECTED);
    }

    @Test
    void testGetOrderStatusForValidOrderIdInAcceptedState() {

        String orderId = "Order123";
        String deliveryPersonId = "DeliveryPerson123";
        orderDetails.setOrderStatus(OrderDeliveryStatus.ACCEPTED);
        deliveryPersonStatusDetails.setOrderId(orderId);

        when(orderRepository.getOrderDetailsByOrderId(orderId)).thenReturn(orderDetails);

        when(deliveryPersonService.findActiveDeliveryPersonStatus(deliveryPersonId)).thenReturn(deliveryPersonStatusDetails);

        OrderDetails result = orderServiceImpl.getOrderStatus(orderId);

        Assertions.assertEquals(orderDetails, result);
    }

    @Test
    void testGetOrderStatusForValidOrderIdInOutForDeliveryState() {

        String orderId = orderDetails.getOrderId();
        String deliveryPersonId = deliveryPersonDetails.getDeliveryPersonId();
        orderDetails.setDeliveryPersonId(deliveryPersonDetails.getDeliveryPersonId());
        orderDetails.setOrderStatus(OrderDeliveryStatus.OUT_FOR_DELIVERY);
        deliveryPersonStatusDetails.setOrderId(orderId);

        when(orderRepository.getOrderDetailsByOrderId(orderId)).thenReturn(orderDetails);

        when(deliveryPersonService.findActiveDeliveryPersonStatus(deliveryPersonId)).thenReturn(deliveryPersonStatusDetails);

        OrderDetails result = orderServiceImpl.getOrderStatus(orderId);

        Assertions.assertEquals(orderDetails, result);
    }

    @Test
    void testGetOrderStatusForInValidOrderId() {

        String orderId = "Order124";

        orderDetails.setOrderStatus(OrderDeliveryStatus.ACCEPTED);
        deliveryPersonStatusDetails.setOrderId(orderId);

        when(orderRepository.getOrderDetailsByOrderId(orderId)).thenReturn(null);

        OrderDetails result = orderServiceImpl.getOrderStatus(orderId);

        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateDeliveryStatusToOutForDelivery() {

        String deliveryPersonId = deliveryPersonDetails.getDeliveryPersonId();
        String orderId = orderDetails.getOrderId();
        Location updatedLocation = new Location(34.42,32.78);
        OrderDeliveryStatus updatedOrderDeliveryStatus = OrderDeliveryStatus.OUT_FOR_DELIVERY;


        when(orderRepository.getOrderDetailsByOrderId(deliveryPersonStatusDetails.getOrderId())).thenReturn(orderDetails);

        when(deliveryPersonService.findActiveDeliveryPersonStatus(deliveryPersonId)).thenReturn(deliveryPersonStatusDetails);

        when(deliveryPersonService.calculateETA(orderId, updatedLocation)).thenReturn(123L);

        DeliveryPersonStatusDetails result = orderServiceImpl.updateDeliveryStatus(deliveryPersonId, updatedLocation, updatedOrderDeliveryStatus);

        Assertions.assertEquals(deliveryPersonStatusDetails, result);
    }

    @Test
    void testUpdateDeliveryStatusToDelivered() {

        String deliveryPersonId = deliveryPersonDetails.getDeliveryPersonId();
        String orderId = orderDetails.getOrderId();
        Location updatedLocation = new Location(34.42,32.78);
        OrderDeliveryStatus updatedOrderDeliveryStatus = OrderDeliveryStatus.DELIVERED;


        when(orderRepository.getOrderDetailsByOrderId(deliveryPersonStatusDetails.getOrderId())).thenReturn(orderDetails);

        when(deliveryPersonService.findActiveDeliveryPersonStatus(deliveryPersonId)).thenReturn(deliveryPersonStatusDetails);

        when(deliveryPersonService.calculateETA(orderId, updatedLocation)).thenReturn(123L);

        DeliveryPersonStatusDetails result = orderServiceImpl.updateDeliveryStatus(deliveryPersonId, updatedLocation, updatedOrderDeliveryStatus);

        Assertions.assertEquals(deliveryPersonStatusDetails, result);
    }

    @Test
    void testGetOrderLocationByOrderId() {

        when(orderRepository.getOrderLocationByOrderId(orderDetails.getOrderId())).thenReturn(orderDetails.getCustomerLocation());

        Location result = orderServiceImpl.getOrderLocationByOrderId(orderDetails.getOrderId());
        Assertions.assertEquals(orderDetails.getCustomerLocation(), result);
    }
}
