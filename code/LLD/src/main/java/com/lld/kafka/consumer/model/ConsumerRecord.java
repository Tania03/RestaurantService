package com.lld.kafka.consumer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tania.gupta
 * @date 12/07/20
 */

@ToString
@Getter
@Setter
public class ConsumerRecord {

    private String topicName;
    private int partition;
    private long offset;
    private Object key;
    private Object value;
    private long timeStamp;

    public ConsumerRecord(String topicName, int partition, long offset, Object key, Object value) {
        this.topicName = topicName;
        this.partition = partition;
        this.offset = offset;
        this.key = key;
        this.value = value;
        this.timeStamp = System.currentTimeMillis();
    }
}
