package com.delivery.client;

import com.delivery.client.model.DeliveryPersonRegisterResponse;
import com.delivery.controller.request.DeliveryStatusUpdateRequest;
import com.delivery.controller.response.ServiceResponse;
import com.delivery.model.DeliveryPersonDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author tania.gupta
 * @date 29/06/20
 */
@Component
@Slf4j
public class RestaurantClient {

    @Value(value = "${restaurant.service.url}")
    String restaurantServiceBaseUrl;

    @Value(value = "${restaurant.service.register.uri}")
    String registerURI;

    @Value(value = "${restaurant.service.delivery.status.update.uri}")
    String deliveryStatusUpdateURI;

    RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Autowired
    public void restTemplate(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public DeliveryPersonRegisterResponse registerDeliveryPerson(DeliveryPersonDetails registerRequest){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<DeliveryPersonDetails> requestEntity = new HttpEntity<>(registerRequest, headers);

        String url = restaurantServiceBaseUrl + registerURI;

        DeliveryPersonRegisterResponse deliveryPersonRegisterResponse =  null;

        try {
            log.info("Registering Delivery Service In Restaurant Service");

            long initiateCallTime = System.currentTimeMillis();

            deliveryPersonRegisterResponse = getRestTemplate()
                    .postForObject(url, requestEntity, DeliveryPersonRegisterResponse.class);

            log.info("Total time taken for initialising : {} ", initiateCallTime - System.currentTimeMillis());
            log.info("Response received from Restaurant Service : {} " , deliveryPersonRegisterResponse);

        } catch (Exception e){
            log.error("Exception occurred while registering service ", e);
        }

        return deliveryPersonRegisterResponse;
    }

    public ServiceResponse updateDeliveryStatus(DeliveryStatusUpdateRequest deliveryStatusUpdateRequest){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<DeliveryStatusUpdateRequest> requestEntity = new HttpEntity<>(deliveryStatusUpdateRequest, headers);

        String url = restaurantServiceBaseUrl + deliveryStatusUpdateURI;

        ServiceResponse serviceResponse =  null;

        try {
            log.info("Registering Delivery Service In Restaurant Service");

            long initiateCallTime = System.currentTimeMillis();

            serviceResponse = getRestTemplate()
                    .postForObject(url, requestEntity, ServiceResponse.class);

            log.info("Total time taken for initialising : {} ", initiateCallTime - System.currentTimeMillis());
            log.info("Response received from Restaurant Service : {} " , serviceResponse);

        } catch (Exception e){
            log.error("Exception occurred while registering service ", e);
        }

        return serviceResponse;

    }
}
