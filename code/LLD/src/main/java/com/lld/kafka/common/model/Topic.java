package com.lld.kafka.common.model;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tania.gupta
 * @date 12/07/20
 */

@Getter
@Setter
public class Topic {

    private String name;
    private int noOfPartitions;
    private int replicationFactor;
    private int[] partitions;
    private AtomicInteger offset = new AtomicInteger(0);

    public Topic(String name, int noOfPartitions, int replicationFactor) {
        this.name = name;
        this.noOfPartitions = noOfPartitions;
        this.replicationFactor = replicationFactor;
        this.partitions = new int[noOfPartitions];
        offset.getAndIncrement();
    }
}
