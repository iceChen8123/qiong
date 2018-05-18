package com.ice.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApp {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(RedisApp.class);
    application.run(args);
  }

}
