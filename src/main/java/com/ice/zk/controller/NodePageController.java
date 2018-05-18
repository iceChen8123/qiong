package com.ice.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/zk/node")
public class NodePageController {

  @RequestMapping("/manage")
  public ModelAndView toZkManagePage() {
    return new ModelAndView("zkhello");
  }

}
