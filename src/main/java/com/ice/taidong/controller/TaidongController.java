package com.ice.taidong.controller;

import com.ice.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
@RequestMapping("taidong")
@Slf4j
public class TaidongController {

  @RequestMapping(value = "/caculate", method = {RequestMethod.POST, RequestMethod.GET})
  public BaseResponse caculate(String info, String starttime, String endtime) {
    LinkedList<Integer> infoList = analysisInfo(info);
    int effectiveTime = 1;
    for (Integer ii : infoList) {
      if (ii > 60) {
        effectiveTime++;
      }
    }
    return BaseResponse.builder().isSuccess(true).data("开发中").build();
  }

  private static LinkedList<Integer> analysisInfo(String info) {
    LinkedList<Integer> infoList = new LinkedList<>();
    infoList.add(1);
    infoList.add(2);
    for (int i = 1; i < info.length(); i++) {
      if (info.charAt(i) == '.') {
        infoList.add(infoList.getLast() + 1);
      } else if (info.charAt(i) == ' ') {

      } else {
        infoList.set(infoList.size() - 1, infoList.getLast() + 1);
      }

    }
    infoList.removeLast();
    return infoList;
  }

  public static void main(String[] args) {
    System.out.println(analysisInfo(".----.---.-----...-.---.--------"));
    System.out.println(analysisInfo(".----.---.-----...-.---.------."));
    System.out.println(analysisInfo(".----.---.-----...-.---.------------------------------------------------."));
    System.out.println(analysisInfo(".----.---.-----...-.---.-------------------------------......-.----.."));
  }

}
