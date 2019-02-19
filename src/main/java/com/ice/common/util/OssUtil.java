package com.ice.common.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;

import java.io.*;
import java.util.List;

public class OssUtil {

  private static OSSClient ossClient;
  private static final String bucketName = "ice-cache";
  private static final String endpoint = "http://oss-cn-shanghai.aliyuncs.com";

  static {
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

  public static List<OSSObjectSummary> listObject(String keyPrefix) {
    ObjectListing objectListing = ossClient.listObjects(bucketName, keyPrefix);
    return objectListing.getObjectSummaries();
  }

}
