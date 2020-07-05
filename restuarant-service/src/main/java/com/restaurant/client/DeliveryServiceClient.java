package com.restaurant.client;

import com.restaurant.client.request.AcceptOrderRequest;
import com.restaurant.client.response.DeliveryPersonAcceptOrderResponse;
import com.restaurant.model.DeliveryPersonDetails;
import com.restaurant.model.OrderDetails;
import com.restaurant.model.enums.OrderDeliveryStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author tania.gupta
 * @date 30/06/20
 */
@Component
@Slf4j
public class DeliveryServiceClient {

    private final String URL_PREFIX = "http://";
    private final String DELIVERY_PERSON_ORDER_ACCEPT_URI = "/api/service/order/accept";

    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Autowired
    public void restTemplate(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public OrderDeliveryStatus deliverOrderRequest(DeliveryPersonDetails deliveryPersonDetails, OrderDetails orderDetails){

        String deliveryPersonServiceURL =  URL_PREFIX + deliveryPersonDetails.getHost() + ":" + deliveryPersonDetails.getPort() +
                DELIVERY_PERSON_ORDER_ACCEPT_URI;

        AcceptOrderRequest acceptOrderRequest = new AcceptOrderRequest(orderDetails.getOrderId(),
                orderDetails.getCustomerLocation());


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AcceptOrderRequest> requestEntity = new HttpEntity<>(acceptOrderRequest, headers);

        DeliveryPersonAcceptOrderResponse response = null;

        try {
            log.info("Calling Delivery Person Service to accept order request");

            long initiateCallTime = System.currentTimeMillis();

            response = getRestTemplate()
                    .postForObject(deliveryPersonServiceURL, requestEntity, DeliveryPersonAcceptOrderResponse.class);

            log.info("Total time taken for initialising : {} ", initiateCallTime - System.currentTimeMillis());
            log.info("Response received from Delivery Service : {} " , response.getOrderDeliveryStatus());

        } catch (Exception e){
            log.error("Exception occurred while registering service ", e);
        }

        return response.getOrderDeliveryStatus();
    }

}
