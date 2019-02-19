package com.ice.wangzherongyao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HeroIdCache {

  private static Map<String, String> heroIdCache = new HashMap<>();

  static {
    try {
      InputStream content = HttpClientBuilder.create().build().execute(new HttpGet("https://tiem-cdn.qq.com/ingame/json/smoba/smobaStrategyIdName.json")).getEntity().getContent();
      String str = IOUtils.toString(content, "utf-8");
      ObjectMapper mapper = new ObjectMapper();
      Map<String, String> allHeroFromServer = mapper.readValue(str, Map.class);
      allHeroFromServer.entrySet().forEach(heroInfo -> {
        heroIdCache.put(heroInfo.getKey(), heroInfo.getValue());
      });
      heroIdCache = Collections.unmodifiableMap(heroIdCache);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Map<String, String> getHeroIdCache() {
    return heroIdCache;
  }

  public static void main(String[] args) {
    System.out.println(getHeroIdCache());
  }

  public static String getHeroName(String heroId) {
    return heroIdCache.get(heroId);
  }
}
