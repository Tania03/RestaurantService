package com.clientside.ratelimiter.internal;

/**
 * @author tania.gupta
 * @date 08/09/20
 */
public interface RateLimitService {
    String validateLimit(String serviceName, String apiName, String method);
}
