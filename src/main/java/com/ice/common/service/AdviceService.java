package com.ice.common.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class AdviceService {

  public void record(String numberType, String number, String advice) {
    log.info(convert(numberType, number, advice));
  }

  private String convert(String numberType, String number, String advice) {
    StringBuilder stringBuilder = new StringBuilder(System.lineSeparator())
            .append("-------------------msgStart-------------------").append(System.lineSeparator());
    stringBuilder.append("time : ").append(JSON.toJSONString(new Date())).append(System.lineSeparator());
    stringBuilder.append("contact way : ").append(numberType).append(System.lineSeparator());
    stringBuilder.append("contact number : ").append(number).append(System.lineSeparator());
    stringBuilder.append("advice : ").append(advice).append(System.lineSeparator());
    stringBuilder.append("-------------------msgEnd-------------------");
    return stringBuilder.toString();
  }

}
