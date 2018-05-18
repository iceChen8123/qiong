package com.ice.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisMainTest {

  public static void main(String[] args) {

  }

  /**
   * 初始化Redis连接池
   */
//  private static void initialPool() {
//    JedisPool jedisPool;
//    try {
//      JedisPoolConfig config = new JedisPoolConfig();
//      config.setMaxTotal(5);
//      config.setMaxIdle(5);
//      config.setMaxWaitMillis(3000);
//      config.setTestOnBorrow(false);
//      jedisPool = new JedisPool(config, ADDR_ARRAY.split(",")[0], PORT, TIMEOUT, AUTH);
//    } catch (Exception e) {
//      logger.error("First create JedisPool error : " + e);
//      try {
//        //如果第一个IP异常，则访问第二个IP
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(MAX_ACTIVE);
//        config.setMaxIdle(MAX_IDLE);
//        config.setMaxWaitMillis(MAX_WAIT);
//        config.setTestOnBorrow(TEST_ON_BORROW);
//        jedisPool = new JedisPool(config, ADDR_ARRAY.split(",")[1], PORT, TIMEOUT, AUTH);
//      } catch (Exception e2) {
//        logger.error("Second create JedisPool error : " + e2);
//      }
//    }
//  }

}
