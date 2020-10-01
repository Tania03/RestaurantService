package com.lld.kafka.consumer;

import com.lld.kafka.common.model.Topic;
import com.lld.kafka.consumer.model.ConsumerRecord;

import java.util.List;
import java.util.Optional;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public interface Consumer {

    void subscribe(List<String> topic);

    Optional<List<ConsumerRecord>> poll(String topic, long offset);

    void unsubscribe(Topic topic);

}
