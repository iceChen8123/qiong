package com.ice.redis.controller;

import com.ice.BaseResponse;
import com.ice.redis.service.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

  @Autowired
  private RedisService redisService;

  @RequestMapping("/env")
  public BaseResponse queryEnv() {
    return BaseResponse.builder().isSuccess(true).data(redisService.queryEnv()).build();
  }

  @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
  public BaseResponse list(@Param("namePrefix") String namePrefix) throws Exception {
    if (StringUtils.isBlank(namePrefix)) {
      return BaseResponse.builder().isSuccess(false).msg("请传入一个前缀").build();
    }
    return BaseResponse.builder().isSuccess(true).data(redisService.list(namePrefix)).build();
  }

}
