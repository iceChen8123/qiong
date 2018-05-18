package com.ice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToPageController {

  @RequestMapping("/")
  public ModelAndView toZkManagePage() {
    return new ModelAndView("dashboard");
  }
}
