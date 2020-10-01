package com.clientside.ratelimiter.model;

import com.clientside.ratelimiter.model.ApiLimit;
import com.clientside.ratelimiter.model.MethodTypeValues;

import java.util.List;
import java.util.Map;

/**
 * @author tania.gupta
 * @date 08/09/20
 */
public class ServiceLimit {

    public String service;
    private Map<String, MethodTypeValues> globalLimits;
    private List<ApiLimit> apiLimits;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Map<String, MethodTypeValues> getGlobalLimits() {
        return globalLimits;
    }

    public void setGlobalLimits(Map<String, MethodTypeValues> globalLimits) {
        this.globalLimits = globalLimits;
    }

    public List<ApiLimit> getApiLimits() {
        return apiLimits;
    }

    public void setApiLimits(List<ApiLimit> apiLimits) {
        this.apiLimits = apiLimits;
    }
}
