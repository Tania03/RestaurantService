package com.clientside.ratelimiter.model;

import com.clientside.ratelimiter.model.MethodTypeValues;

import java.util.Map;

/**
 * @author tania.gupta
 * @date 08/09/20
 */
public class ApiLimit {

    private Map<String, MethodTypeValues> methods;
    private String api;

    public Map<String, MethodTypeValues> getMethods() {
        return methods;
    }

    public void setMethods(Map<String, MethodTypeValues> methods) {
        this.methods = methods;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
