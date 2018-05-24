package com.ice.picmanage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/pic")
public class PicPageController {

  @RequestMapping("/manage")
  public ModelAndView toPicManagePage() {
    return new ModelAndView("picmanage");
  }
}
