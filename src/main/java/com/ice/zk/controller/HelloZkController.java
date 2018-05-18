package com.ice.zk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/zk")
public class HelloZkController {

  @RequestMapping("")
  public String helloZk() {
    return "hello Zk,Time is " + LocalDateTime.now();
  }

}
