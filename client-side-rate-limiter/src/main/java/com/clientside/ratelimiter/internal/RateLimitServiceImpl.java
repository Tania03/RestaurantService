package com.clientside.ratelimiter.internal;

import com.clientside.ratelimiter.constants.RateLimitConstants;
import com.clientside.ratelimiter.convertor.RateLimitConfigReader;
import com.clientside.ratelimiter.model.ApiLimit;
import com.clientside.ratelimiter.model.MethodTypeValues;
import com.clientside.ratelimiter.model.RateLimitConfig;
import com.clientside.ratelimiter.model.ServiceLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.clientside.ratelimiter.constants.RateLimitConstants.*;

/**
 * @author tania.gupta
 * @date 08/09/20
 */
@Component
public class RateLimitServiceImpl implements RateLimitService {

    @Autowired
    RateLimitConfigReader configReader;

    RateLimitConfig rateLimitConfig;

    Map<String, List<Long>> allowedRequestMap;

    private String maxTimeLimitToKeep = LIMIT_TYPE_MINUTES;

    @PostConstruct
    public void init() throws IOException {
        rateLimitConfig = configReader.readConfig();
        allowedRequestMap = new ConcurrentHashMap<>();
    }

    @Override
    public String validateLimit(String serviceName, String apiName, String method) {

        Optional<ServiceLimit> serviceLimitConfig = getServiceLimit(serviceName);
        if (!serviceLimitConfig.isPresent())
            return RATE_LIMIT_FAILED;

        //Get limits from config
        MethodTypeValues globalLimits = serviceLimitConfig.get().getGlobalLimits().get(method);
        MethodTypeValues apiLimit = getApiLimit(serviceLimitConfig.get(), apiName, method);

        //create validation list
        List<MethodTypeValues> validationList = new ArrayList<>();
        validationList.add(globalLimits);
        validationList.add(apiLimit);

        //create key for allowedRequestMap
        String key = getAllowedRequestKey(serviceName, apiName, method);

        //validate config limit
        if (validateLimit(validationList, key)) {
            return RATE_LIMIT_SUCCESS;
        }
        return RATE_LIMIT_FAILED;
    }

    private synchronized boolean validateLimit(List<MethodTypeValues> validationList, String key) {
        List<Long> allowedRequests = allowedRequestMap.get(key);
        if (allowedRequests == null) {
            allowedRequests = new ArrayList<>();
        }

        for (MethodTypeValues config : validationList) {
            Long limit = config.getLimit();
            String granularity = config.getGranularity();

            if (allowedRequests != null) {
                long starTime = getStartTime(granularity);
                long currentAllowedRequest = allowedRequests.stream().filter(e -> e.longValue() >= starTime).count();
                if (currentAllowedRequest >= limit)
                    return false;
            }
        }

        //Trim requests older than a minute
        Long epochValue = getStartTime(maxTimeLimitToKeep);
        List<Long> trimmedAllowedRequest = allowedRequests
                .stream()
                .filter(e -> e > epochValue)
                .collect(Collectors.toList());

        //add current request in trimmedAllowedRequest
        trimmedAllowedRequest.add(System.currentTimeMillis());
        allowedRequestMap.put(key, trimmedAllowedRequest);
        return true;
    }

    private Optional<ServiceLimit> getServiceLimit(String serviceName1) {
        return rateLimitConfig.getServiceLimits()
                .stream()
                .filter(s -> s.getService().equals(serviceName1))
                .findFirst();
    }

    private MethodTypeValues getApiLimit(ServiceLimit serviceLimitConfig, String apiName, String method) {
        Optional<ApiLimit> first = serviceLimitConfig.getApiLimits()
                                    .stream()
                                    .filter(e -> e.getApi().equals(apiName))
                                    .findFirst();

        if (!first.isPresent()) return null;

        return first.get().getMethods().get(method);
    }

    private String getAllowedRequestKey(String serviceName, String apiName, String method) {
        return serviceName + KEY_SEPARATOR + apiName + KEY_SEPARATOR + method;
    }

    private Long getStartTime(String granularity) {
        Long startTime = 0l;

        switch (granularity) {
            case LIMIT_TYPE_SECONDS:
                startTime = System.currentTimeMillis() - 1000;
                break;
            case LIMIT_TYPE_MINUTES:
                startTime = System.currentTimeMillis() - 60 * 1000;
                break;
            default:
                startTime = System.currentTimeMillis();
        }
        return startTime;
    }
}