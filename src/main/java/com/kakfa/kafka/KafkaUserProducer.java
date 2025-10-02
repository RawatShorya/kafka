package com.kakfa.kafka;

import com.kakfa.models.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaUserProducer {
  private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

  private KafkaTemplate<String, User> kafkaUserTemplate;

  @Value("${com.kafka.topic}")
  private String kafkaTopic;

  public KafkaUserProducer(KafkaTemplate<String, User> kafkaUserTemplate) {
    this.kafkaUserTemplate = kafkaUserTemplate;
  }

  public void sendMessage(User user) {
    log.info("User Message Sent : {}", user);
    kafkaUserTemplate.send(
        MessageBuilder.withPayload(user)
            .setHeader(KafkaHeaders.TOPIC, kafkaTopic + "_json")
            .build());
  }
}
