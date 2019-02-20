package com.ice.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class QrCodeController {

  @RequestMapping("/qrcode")
  public ModelAndView toIndexPage() {
    return new ModelAndView("qrcode");
  }

  @RequestMapping("/erweima")
  public ModelAndView toMePage() {
    return new ModelAndView("qrcode");
  }

}
