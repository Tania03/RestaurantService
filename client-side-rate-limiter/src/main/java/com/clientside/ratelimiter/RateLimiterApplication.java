package com.clientside.ratelimiter;

import com.clientside.ratelimiter.internal.RateLimitService;
import com.clientside.ratelimiter.internal.RateLimitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RateLimiterApplication {



    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext =  SpringApplication.run(RateLimiterApplication.class, args);
        RateLimitService rateLimitService = applicationContext.getBean(RateLimitServiceImpl.class);

        //first 20 request will be allowed and 21st request will fail
        for(int i =1; i<= 21; i++){
            String result = rateLimitService.validateLimit(
                    "OrderService",
                    "CreateOrder",
                    "GET");
            System.out.println(result);
            Thread.sleep(500);
        }

        //wait for 1 min
        Thread.sleep(1000);

        //This will pass
        for(int i =0; i< 1; i++){
            String result = rateLimitService.validateLimit(
                    "OrderService",
                    "CreateOrder",
                    "POST");
            System.out.println(result);
        }
    }
}
