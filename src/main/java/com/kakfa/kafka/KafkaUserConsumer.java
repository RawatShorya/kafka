package com.kakfa.kafka;

import com.kakfa.models.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaUserConsumer {

  private static final Logger log = LoggerFactory.getLogger(KafkaUserConsumer.class);

  @KafkaListener(topics = "${com.kafka.topic_json}", groupId = "myGroup")
  public void consume(User message) {
    log.info("Received value in consumer printing the same : {}", message.toString());
  }
}
