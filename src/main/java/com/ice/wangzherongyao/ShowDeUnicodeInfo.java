package com.ice.wangzherongyao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class ShowDeUnicodeInfo {

  public static void main(String[] args) throws IOException {
    String uri = "https://pvp.qq.com/zlkdatasys/zsbd_herolist/513.json";
    InputStream content = HttpClientBuilder.create().build().execute(new HttpGet(uri)).getEntity().getContent();
    String str = IOUtils.toString(content, "utf-8");
    ObjectMapper mapper = new ObjectMapper();
    mapper.readValue(str, Map.class).entrySet().forEach(System.out::println);
  }

}
