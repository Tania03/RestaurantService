package com.lld.kafka.common.service.impl;

import com.lld.kafka.common.model.Record;
import com.lld.kafka.common.model.Topic;
import com.lld.kafka.common.service.KafkaService;
import com.lld.kafka.consumer.KafkaConsumer;
import com.lld.kafka.consumer.model.ConsumerRecord;
import com.lld.kafka.producer.model.ProducerRecord;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
@Service
public class KafkaServiceImpl implements KafkaService {

    Map<String, Topic> stringTopicMap;
    Map<String, List<Record>> topicToRecordMap;
    Map<String, List<String>> consumerToTopicMap;

    public KafkaServiceImpl() {
        this.stringTopicMap = new HashMap<>();
        this.topicToRecordMap = new HashMap<>();
        this.consumerToTopicMap = new HashMap<>();
    }

    @Override
    public void addTopics(ArrayList<Topic> topics) {

        for (Topic topic : topics) {
            stringTopicMap.putIfAbsent(topic.getName(), topic);
        }
    }

    @Override
    public void addRecordToTopic(ProducerRecord producerRecord) {

        Record record = createRecord(producerRecord);
        System.out.println("Record added : " + record);

        topicToRecordMap.putIfAbsent(record.getTopicName(), new ArrayList<>());
        topicToRecordMap.get(record.getTopicName()).add(record);

    }

    @Override
    public void subscribe(KafkaConsumer kafkaConsumer, List<String> topicList) {

        for (String topic : topicList) {
            consumerToTopicMap.putIfAbsent(kafkaConsumer.getClientId(), new ArrayList<>());
            consumerToTopicMap.get(kafkaConsumer.getClientId()).add(topic);

            System.out.println("Consumer : " + kafkaConsumer + " subscribed : " + topic);
        }
    }

    @Override
    public Optional<List<ConsumerRecord>> consume(KafkaConsumer kafkaConsumer, String topic, long offset) {

        if (!consumerToTopicMap.containsKey(kafkaConsumer.getClientId())) {
            System.out.println("No such consumer exists");
            return Optional.empty();
        }

        List<String> topics = consumerToTopicMap.get(kafkaConsumer.getClientId());
        if (!topics.contains(topic)) {
            System.out.println("Consumer : " + kafkaConsumer.getClientId() + " has not subscribed to topic : " + topic);
            return Optional.empty();
        }

        if (!topicToRecordMap.containsKey(topic)) {
            System.out.println("No record exists for this topic");
            return Optional.empty();
        }

        List<Record> records = topicToRecordMap.get(topic);

        List<ConsumerRecord> consumerRecordList = new ArrayList<>();

        for (Record record : records) {
            if (record.getOffset() >= offset) {
                ConsumerRecord consumerRecord = createConsumerRecord(record);
                consumerRecordList.add(consumerRecord);
                System.out.println("Consumer : " + kafkaConsumer.getClientId() + " consumed record : " + consumerRecord);
            } else {
                System.out.println("No new message for consumer : " + kafkaConsumer.getClientId() + " in topic : " + topic);
            }
        }
        return Optional.of(consumerRecordList);

    }

    private ConsumerRecord createConsumerRecord(Record record) {

        return new ConsumerRecord(
                record.getTopicName(),
                record.getPartitionId(),
                record.getOffset(),
                record.getKey(),
                record.getValue()
        );
    }

    private Record createRecord(ProducerRecord producerRecord) {

        Record record = new Record();

        String topic = producerRecord.getTopicName();
        Topic currentTopic = stringTopicMap.get(topic);
        int partitionId = producerRecord.getPartition() != null
                ? producerRecord.getPartition()
                : new Random().nextInt(currentTopic.getNoOfPartitions());

        record.setTopicName(producerRecord.getTopicName());
        record.setPartitionId(partitionId);
        record.setKey(producerRecord.getKey());
        record.setValue(producerRecord.getValue());
        record.setOffset(currentTopic.getOffset().longValue());

        return record;

    }
}
