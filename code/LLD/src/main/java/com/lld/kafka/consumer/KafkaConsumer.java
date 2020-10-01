package com.lld.kafka.consumer;

import com.lld.kafka.common.model.Topic;
import com.lld.kafka.common.service.KafkaService;
import com.lld.kafka.consumer.model.ConsumerRecord;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
@Getter
public class KafkaConsumer implements Consumer {

    String clientId;

    KafkaService kafkaService;

    public KafkaConsumer(String clientId, KafkaService kafkaService) {
        this.clientId = clientId;
        this.kafkaService = kafkaService;
    }

    @Override
    public void subscribe(List<String> topicList) {
        kafkaService.subscribe(this, topicList);
    }

    @Override
    public Optional<List<ConsumerRecord>> poll(String topic, long offset) {
        return kafkaService.consume(this, topic, offset);
    }

    @Override
    public void unsubscribe(Topic topic) {

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KafkaConsumer{");
        sb.append("clientId='").append(clientId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
