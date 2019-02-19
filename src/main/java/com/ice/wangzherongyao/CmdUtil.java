package com.ice.wangzherongyao;

import com.ice.pingyin.PinyinHelperUtil;
import com.ice.wangzherongyao.util.SimpleHeroInfoFormat;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.TreeMap;

public class CmdUtil {

  public static void main(String[] args) {
    TreeMap<String, String> heroNames = new TreeMap<>();
    HeroIdCache.getHeroIdCache().entrySet().forEach(heroIdInfo -> {
      String heroName = heroIdInfo.getValue();
      heroNames.put(PinyinHelperUtil.convertToPinyin(heroName), String.format("%-6s: %s", heroName, heroIdInfo.getKey()));
    });

    heroNames.values().forEach(heroName -> {
      System.out.println(heroName);
    });

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String heroId = scanner.next();
      if (StringUtils.isBlank(heroId)) {
        return;
      }
      System.out.println(new SimpleHeroInfoFormat().fromHero(HeroManager.getHeroDetail(heroId)));
      System.out.println();
    }
  }

}
