package com.ice.sanguosha;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(App.class);
    Banner banner = (environment, sourceClass, out) -> {
      out.println("*************************************");
      out.println("*                                   *");
      out.println("*                                   *");
      out.println("*   Welcome To Three Country Kill   *");
      out.println("*                                   *");
      out.println("*                                   *");
      out.println("*************************************");
    };
    application.setBanner(banner);
    application.run(args);
  }

}
