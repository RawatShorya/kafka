package com.kakfa.service.impl;

import com.kakfa.kafka.KafkaProducer;
import com.kakfa.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

  private final KafkaProducer kafkaProducer;

  public TestServiceImpl(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  @Override
  public Boolean sendPayloadToTopic(String payload) {
    kafkaProducer.sendMessage(payload);
    return Boolean.TRUE;
  }
}
