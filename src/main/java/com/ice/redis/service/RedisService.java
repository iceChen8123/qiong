package com.ice.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RedisService {

  @Autowired
  private StringRedisTemplate template;

  @Value("${spring.redis.host}")
  private String host;

  @Value("${spring.redis.port}")
  private String port;

  public String queryEnv() {
    return host + ":" + port;
  }

  public List<Map.Entry<String, String>> list(String namePrefix) {
    List<Map.Entry<String, String>> rtnList = new ArrayList<>();
//    Cursor<byte[]> scan = template.getConnectionFactory().getConnection().scan(ScanOptions.scanOptions().match(namePrefix).count(100).build());
//    while (scan.hasNext()) {
//      try {
//        String key = new String(scan.next(), "UTF-8");
//        rtnList.add(new HashMap.SimpleEntry(key, template.getConnectionFactory().getConnection().get(key.getBytes())));
//      } catch (UnsupportedEncodingException e) {
//        e.printStackTrace();
//      }
//    }
    return rtnList;
  }
}
