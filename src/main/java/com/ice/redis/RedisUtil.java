//package com.ice.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//@Component
//public class RedisUtil {
//
//  @Autowired
//  private StringRedisTemplate template;
//
//  @PostConstruct
//  public void init() {
//    System.out.println("............................................");
//    for (int a = 0; a < 2000; a++) {
//      String key = "testKey" + a;
//      template.opsForValue().set(key, "testVVV");
//      template.expire(key, 1200 * 1000, TimeUnit.MILLISECONDS);
//    }
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        Random random = new Random();
//        int fff = 0;
//        while (true) {
//          String tmpkey = "testKey" + random.nextInt(2000);
//          String testV = template.opsForValue().get(tmpkey);
//          fff++;
//          if (testV == null || !testV.equals("testVVV")) {
//            System.out.println();
//            System.out.println(tmpkey + " miss........................" + testV);
//            System.out.println();
//          } else {
//            System.out.print(".");
//          }
//          if (fff % 200 == 0) {
//            System.out.println();
//          }
////          try {
////            Thread.sleep(100L);
////          } catch (InterruptedException e) {
////          }
//        }
//      }
//    }).start();
//  }
//  //TODO https://blog.csdn.net/zxp2624161989/article/details/53769549
//
//}
