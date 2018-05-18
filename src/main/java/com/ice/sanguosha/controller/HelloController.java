package com.ice.sanguosha.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
public class HelloController {

  static final String name = RandomStringUtils.randomAlphabetic(10);
  static int time = 0;
  static int time1 = 0;

  @RequestMapping("/hello")
  public String hello() {
    log.info(name + "------" + (++time));
    try {
      Thread.sleep(30000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "hello,Time is " + LocalDateTime.now();
  }

  @RequestMapping("/hello1")
  public String hello1() {
    log.info(name + "------" + (++time1));
    return "hello,Time1 is " + LocalDateTime.now();
  }
}
