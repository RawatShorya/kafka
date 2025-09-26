package com.kakfa.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

  private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

  private KafkaTemplate<String, String> kafkaTemplate;

  @Value("${com.kafka.topic}")
  private String kafkaTopic;

  public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String message) {
    log.info("Message Sent : {}", message);
    kafkaTemplate.send(kafkaTopic, message);
  }
}
