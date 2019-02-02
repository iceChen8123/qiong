package com.ice.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HelloPageController {

  @RequestMapping("/index")
  public ModelAndView toIndexPage() {
    return new ModelAndView("index");
  }

  @RequestMapping("/me")
  public ModelAndView toMePage() {
    return new ModelAndView("me");
  }

}
