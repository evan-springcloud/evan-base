package org.evan.springcloud.base;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TestRecordMqConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestRecordMqConsumer.class);


    @KafkaListener(topics = "test")
    public void receive(ConsumerRecord<?, ?> consumer) {

    }
}
