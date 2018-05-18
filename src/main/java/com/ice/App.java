package com.ice;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(App.class);
    Banner banner = (environment, sourceClass, out) -> {
      out.println("*************************************");
      out.println("*                                   *");
      out.println("*                                   *");
      out.println("*   Welcome To         ZK  CLIENT   *");
      out.println("*                                   *");
      out.println("*                                   *");
      out.println("*************************************");
    };
    application.setBanner(banner);
    application.run(args);
  }

}
