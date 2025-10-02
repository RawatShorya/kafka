package com.kakfa.service;

public interface TestService {
  Boolean sendPayloadToTopic(String payload);

  Boolean sendPayloadWithUserData(String firstName, String lastName);
}
