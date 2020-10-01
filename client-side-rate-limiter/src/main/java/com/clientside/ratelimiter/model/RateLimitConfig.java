package com.clientside.ratelimiter.model;

import java.util.List;

/**
 * @author tania.gupta
 * @date 08/09/20
 */
public class RateLimitConfig {

    List<ServiceLimit> serviceLimits;

    public List<ServiceLimit> getServiceLimits() {
        return serviceLimits;
    }

    public void setServiceLimits(List<ServiceLimit> serviceLimits) {
        this.serviceLimits = serviceLimits;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RateLimitConfig{");
        sb.append("serviceLimits=").append(serviceLimits);
        sb.append('}');
        return sb.toString();
    }
}
