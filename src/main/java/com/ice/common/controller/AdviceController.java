package com.ice.common.controller;

import com.ice.common.BaseResponse;
import com.ice.common.service.AdviceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("advice")
public class AdviceController {

  @Autowired
  private AdviceService adviceService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public ModelAndView toIndexPage() {
    return new ModelAndView("advice");
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  @ResponseBody
  public BaseResponse advice(@RequestParam(value = "numberType", required = false) String numberType,
                             @RequestParam(value = "number", required = false) String number,
                             @RequestParam("advice") String advice) {
    if (StringUtils.isBlank(advice)) {
      return BaseResponse.builder().isSuccess(false).msg("advice is null.").build();
    }
    adviceService.record(numberType, number, advice);
    return BaseResponse.builder().isSuccess(true).data("Thank you ~").build();
  }

}
