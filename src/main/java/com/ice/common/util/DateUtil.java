package com.ice.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil {

  private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<>();

  public static DateFormat getSimpleDateFormat() {
    if (dateFormatThreadLocal.get() == null) {
      dateFormatThreadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    return dateFormatThreadLocal.get();
  }
}
