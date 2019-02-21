package com.ice.common.service;

import com.ice.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class AdviceService {

  public void record(String fullname, String number, String advice) {
    log.info(convert(fullname, number, advice));
  }

  private String convert(String name, String number, String advice) {
    StringBuilder stringBuilder = new StringBuilder(System.lineSeparator())
            .append("-------------------msgStart-------------------").append(System.lineSeparator());
    stringBuilder.append("time : ").append(DateUtil.getSimpleDateFormat().format(new Date())).append(System.lineSeparator());
    stringBuilder.append("name : ").append(name).append(System.lineSeparator());
    stringBuilder.append("number : ").append(number).append(System.lineSeparator());
    stringBuilder.append("message : ").append(advice).append(System.lineSeparator());
    stringBuilder.append("-------------------msgEnd-------------------");
    return stringBuilder.toString();
  }

}
