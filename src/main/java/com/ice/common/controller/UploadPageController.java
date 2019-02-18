package com.ice.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("upload")
public class UploadPageController {

  @RequestMapping("")
  public ModelAndView toIndexPage() {
    return new ModelAndView("upload");
  }

}
