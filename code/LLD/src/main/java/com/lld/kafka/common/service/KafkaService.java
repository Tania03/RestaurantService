package com.lld.kafka.common.service;

import com.lld.kafka.common.model.Topic;
import com.lld.kafka.consumer.KafkaConsumer;
import com.lld.kafka.consumer.model.ConsumerRecord;
import com.lld.kafka.producer.model.ProducerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public interface KafkaService {

    void addTopics(ArrayList<Topic> topics);

    void addRecordToTopic(ProducerRecord producerRecord);

    void subscribe(KafkaConsumer kafkaConsumer, List<String> topicList);

    Optional<List<ConsumerRecord>> consume(KafkaConsumer kafkaConsumer, String topic, long offset);
}
