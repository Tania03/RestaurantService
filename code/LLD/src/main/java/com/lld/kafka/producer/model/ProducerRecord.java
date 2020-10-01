package com.lld.kafka.producer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
@Getter
@Setter
@ToString
public class ProducerRecord {

    private String topicName;
    private Integer partition;
    private Object key;
    private Object value;
    private long timeStamp;

    public ProducerRecord(String topicName, Integer partition, Object key, Object value) {
        this.topicName = topicName;
        this.partition = partition;
        this.key = key;
        this.value = value;
        this.timeStamp = System.currentTimeMillis();
    }
}
