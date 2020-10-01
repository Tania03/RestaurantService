package com.lld.kafka.producer;

import com.lld.kafka.producer.model.ProducerRecord;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public interface Producer {

    void send(ProducerRecord producerRecord);
}
