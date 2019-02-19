package com.ice.common.util;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.model.OSSObjectSummary;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OssUtilTest {

  public static void main(String[] args) {
    listObject();
  }

  private static void simpleUpload() {
    String content = "Hello OSS123," + new Date().toString();
    String objectName = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +
            "-test-" + RandomStringUtils.randomAlphabetic(15);
    OssUtil.simpleUpload(objectName, content);

  }

  private static void listObject() {
    //b50234dafb7f48438a2e064d4a6d7cc2686631
    for (OSSObjectSummary ossObjectSummary : OssUtil.listObject("b50234dafb7f48438a2e064d4a6d7cc2686631")) {
      System.out.println(JSON.toJSONString(ossObjectSummary));
    }
  }

}
