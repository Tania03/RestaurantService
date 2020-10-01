package com.lld.kafka.common.model;

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
public class Record {

    String topicName;
    int partitionId;
    Object key;
    Object value;
    long offset;

}
