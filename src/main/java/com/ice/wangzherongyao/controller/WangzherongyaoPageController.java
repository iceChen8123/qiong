package com.ice.wangzherongyao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hero")
public class WangzherongyaoPageController {

  @RequestMapping("")
  public ModelAndView toIndexPage() {
    return new ModelAndView("hero");
  }

}
