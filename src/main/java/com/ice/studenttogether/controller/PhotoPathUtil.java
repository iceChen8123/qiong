package com.ice.studenttogether.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PhotoPathUtil {

  private static final Properties prop = new Properties();

  private static long lastModified = 0;

  static {
    Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        init();
      }
    }, 1, 10, TimeUnit.SECONDS);

  }

  public static String getPhotoPath(String key) {
    return prop.getProperty(key);
  }

  private static void init() {
    try {
      File file = new File("C:\\Users\\ICE\\Desktop\\photo.properties");
      if (!file.exists()) {
        file = new File("/home/ice/qiong/photo.properties");
      }
      if (lastModified != file.lastModified()) {
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        prop.load(in);
        in.close();
        lastModified = file.lastModified();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
