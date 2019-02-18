package com.ice.common.util;

import com.aliyun.oss.OSSClient;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class OssUtil {

  private static OSSClient ossClient;
  private static final String bucketName = "ice-cache";
  private static final String endpoint = "http://oss-cn-shanghai.aliyuncs.com";

  @PostConstruct
  public void init() {
    ossClient = new OSSClient(endpoint, NotCommitPropertiesUtil.getProperty("aliyun.oss.accessKeyId"),
            NotCommitPropertiesUtil.getProperty("aliyun.oss.accessKeySecret"));
  }

  public static void simpleUpload(String objectName, File file) {
    try {
      ossClient.putObject(bucketName, objectName, new FileInputStream(file));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static void simpleUpload(String objectName, InputStream inputStream) {
    ossClient.putObject(bucketName, objectName, inputStream);
  }

  public static void simpleUpload(String objectName, String content) {
    ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
  }

  public static void main(String[] args) {
    ossClient = new OSSClient(endpoint, NotCommitPropertiesUtil.getProperty("aliyun.oss.accessKeyId"),
            NotCommitPropertiesUtil.getProperty("aliyun.oss.accessKeySecret"));

    String content = "Hello OSS123," + new Date().toString();
    String objectName = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +
            "-test-" + RandomStringUtils.randomAlphabetic(15);
    simpleUpload(objectName, content);
    ossClient.shutdown();

  }

}
