package com.ice.taidong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("taidong")
public class TaidongPageController {

  @RequestMapping("")
  public ModelAndView toIndexPage() {
    return new ModelAndView("taidong/shutaidong");
  }

}
