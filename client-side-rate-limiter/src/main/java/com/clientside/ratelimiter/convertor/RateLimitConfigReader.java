package com.clientside.ratelimiter.convertor;

import com.clientside.ratelimiter.model.RateLimitConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @author tania.gupta
 * @date 08/09/20
 */
@Component
public class RateLimitConfigReader {

    public RateLimitConfig readConfig() throws IOException {
        File file = new File("src/main/resources/config.json");
       return  new ObjectMapper().readValue(file, RateLimitConfig.class);
    }
}
