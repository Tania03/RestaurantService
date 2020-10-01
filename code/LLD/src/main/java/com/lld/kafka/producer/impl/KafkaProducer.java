package com.lld.kafka.producer.impl;

import com.lld.kafka.common.service.KafkaService;
import com.lld.kafka.producer.Producer;
import com.lld.kafka.producer.model.ProducerRecord;
import lombok.Getter;
import lombok.ToString;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
@Getter
public class KafkaProducer implements Producer {

    String clientId;

    KafkaService kafkaService;


    public KafkaProducer(String clientId, KafkaService kafkaService) {
        this.clientId = clientId;
        this.kafkaService = kafkaService;
    }

    @Override
    public void send(ProducerRecord producerRecord) {
        kafkaService.addRecordToTopic(producerRecord);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KafkaProducer{");
        sb.append("clientId='").append(clientId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
