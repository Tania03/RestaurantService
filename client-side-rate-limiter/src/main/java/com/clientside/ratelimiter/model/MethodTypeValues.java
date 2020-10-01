package com.clientside.ratelimiter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author tania.gupta
 * @date 08/09/20
 */
@JsonIgnoreProperties

public class MethodTypeValues {

    private Long limit;
    //TODO enum
    private  String granularity;

    public MethodTypeValues() {
    }

    public MethodTypeValues(Long limit, String granularity) {
        this.limit = limit;
        this.granularity = granularity;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MethodTypeValues{");
        sb.append("limit=").append(limit);
        sb.append(", granularity='").append(granularity).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
