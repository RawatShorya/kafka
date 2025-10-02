package com.kakfa.service.impl;

import com.kakfa.kafka.KafkaProducer;
import com.kakfa.kafka.KafkaUserProducer;
import com.kakfa.models.dto.User;
import com.kakfa.service.TestService;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

  private final KafkaProducer kafkaProducer;
  private final KafkaUserProducer kafkaUserProducer;

  public TestServiceImpl(KafkaProducer kafkaProducer, KafkaUserProducer kafkaUserProducer) {
    this.kafkaProducer = kafkaProducer;
    this.kafkaUserProducer = kafkaUserProducer;
  }

  @Override
  public Boolean sendPayloadToTopic(String payload) {
    kafkaProducer.sendMessage(payload);
    return Boolean.TRUE;
  }

  @Override
  public Boolean sendPayloadWithUserData(String firstName, String lastName) {
    kafkaUserProducer.sendMessage(new User(String.valueOf(UUID.randomUUID()), firstName, lastName));
    return Boolean.TRUE;
  }
}
