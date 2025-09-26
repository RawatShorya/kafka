package com.kakfa.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  @Value("${com.kafka.topic}")
  private String kafkaTopic;

  @Bean
  public NewTopic testSpringTopic() {
    return TopicBuilder.name(kafkaTopic).partitions(2).build();
  }
}
