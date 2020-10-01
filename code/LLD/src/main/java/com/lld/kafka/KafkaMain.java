package com.lld.kafka;

import com.lld.kafka.common.model.Topic;
import com.lld.kafka.common.service.KafkaService;
import com.lld.kafka.common.service.impl.KafkaServiceImpl;
import com.lld.kafka.consumer.Consumer;
import com.lld.kafka.consumer.KafkaConsumer;
import com.lld.kafka.consumer.model.ConsumerRecord;
import com.lld.kafka.producer.Producer;
import com.lld.kafka.producer.impl.KafkaProducer;
import com.lld.kafka.producer.model.ProducerRecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class KafkaMain {

    public static void main(String[] args) {

        KafkaService kafkaService = new KafkaServiceImpl();

        Topic topic1 = new Topic("Topic1", 2, 2);
        Topic topic2 = new Topic("Topic2", 1, 2);
        Topic topic3 = new Topic("Topic3", 3, 2);

        kafkaService.addTopics(new ArrayList<>(Arrays.asList(topic1, topic2, topic3)));

        Producer producer2 = new KafkaProducer("Producer2", kafkaService);
        Producer producer3 = new KafkaProducer("Producer3", kafkaService);
        Producer producer1 = new KafkaProducer("Producer1", kafkaService);

        Consumer consumer1 = new KafkaConsumer("Consumer1", kafkaService);
        Consumer consumer2 = new KafkaConsumer("Consumer2", kafkaService);
        Consumer consumer3 = new KafkaConsumer("Consumer3", kafkaService);

        consumer1.subscribe(new ArrayList<>(Arrays.asList("Topic1", "Topic2", "Topic3")));
        consumer2.subscribe(new ArrayList<>(Arrays.asList("Topic1", "Topic3")));
        consumer3.subscribe(new ArrayList<>(Arrays.asList("Topic1", "Topic2")));


        ProducerRecord topic1Record = new ProducerRecord("Topic1", 1, null, "Hi! - Topic 1");
        ProducerRecord topic2Record = new ProducerRecord("Topic2", null, null, "Hi! - Topic 2");
        ProducerRecord topic3Record = new ProducerRecord("Topic3", 3, null, "Hi! - Topic 3");

        System.out.println("Producing Record");

        producer1.send(topic1Record);
        producer2.send(topic2Record);
        producer3.send(topic3Record);

        System.out.println();

        System.out.println("Consumer1 consuming Record");
        Optional<List<ConsumerRecord>> consumerRecord = consumer1.poll("Topic1", topic1.getOffset().longValue());

        System.out.println();
        System.out.println("Consumer2 consuming Record");
        Optional<List<ConsumerRecord>> consumerRecord2 = consumer2.poll("Topic2", topic2.getOffset().longValue());

        System.out.println();
        System.out.println("Consumer1 consuming Record");
        Optional<List<ConsumerRecord>> consumerRecord12 = consumer1.poll("Topic1", 2);

        System.out.println();
        System.out.println("Consumer3 consuming Record");
        Optional<List<ConsumerRecord>> consumerRecord3 = consumer3.poll("Topic2", topic2.getOffset().longValue());

        System.out.println();
        System.out.println("Consumer1 consuming Record");
        Optional<List<ConsumerRecord>> consumerRecord13 = consumer3.poll("Topic3", topic3.getOffset().longValue());

    }
}
