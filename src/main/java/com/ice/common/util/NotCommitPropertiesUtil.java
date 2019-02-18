package com.ice.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NotCommitPropertiesUtil {

  private static final Properties properties = new Properties();

  static {
    // 使用ClassLoader加载properties配置文件生成对应的输入流
    InputStream in = OssUtil.class.getClassLoader().getResourceAsStream("application-not-commit.properties");
    // 使用properties对象加载输入流
    try {
      properties.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getProperty(String key) {
    if (!properties.containsKey(key)) {
      return "";
    } else {
      return (String) properties.get(key);
    }
  }
}
