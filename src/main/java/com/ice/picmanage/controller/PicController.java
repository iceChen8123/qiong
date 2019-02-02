package com.ice.picmanage.controller;

import com.ice.common.BaseResponse;
import com.ice.picmanage.PicService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pic")
public class PicController {

  /**
   * example: http://localhost:28181/pic/list?path=D:/ph/sgp
   */
  @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
  public BaseResponse getFileList(String path) {
    if (StringUtils.isBlank(path)) {
      return BaseResponse.builder().isSuccess(false).msg("path must not be blank").build();
    }
    return BaseResponse.builder().isSuccess(true).data(PicService.getFileList(path)).build();
  }

}
