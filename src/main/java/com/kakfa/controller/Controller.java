package com.kakfa.controller;

import com.kakfa.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1")
public class Controller {

  private static final Logger log = LoggerFactory.getLogger(Controller.class);

  private final TestService testService;

  public Controller(TestService testService) {
    this.testService = testService;
  }

  @PostMapping("/test")
  public ResponseEntity<Boolean> responseEntity(@RequestParam String payload) {
    log.info("Received payload in responseEntity : {}", payload);
    return new ResponseEntity<>(testService.sendPayloadToTopic(payload), HttpStatus.OK);
  }

  @PostMapping("/user/test")
  public ResponseEntity<Boolean> userResponseEntity(
      @RequestParam String firstName, @RequestParam String lastName) {
    log.info("Received firstName as : {} and lastName as : {}", firstName, lastName);
    return new ResponseEntity<>(
        testService.sendPayloadWithUserData(firstName, lastName), HttpStatus.OK);
  }
}
