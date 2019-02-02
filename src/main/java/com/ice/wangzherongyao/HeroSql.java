package com.ice.wangzherongyao;

import com.ice.pingyin.PinyinHelperUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroSql {

  public static void main(String[] args) {
    List<Hero> heroList = HeroManager.getHeroList();
    Map<String, String> namePinyinCache = new HashMap<>();
    heroList.forEach(hero -> {
      namePinyinCache.put(hero.getName(), PinyinHelperUtil.convertToPinyin(hero.getName()));
    });

    StringBuilder sql = new StringBuilder("CREATE ");
    heroList.forEach(hero -> {
      sql.append("(" + namePinyinCache.get(hero.getName()) + ":Hero ")
              .append("{ name: \"" + hero.getName() + "\",").append(" title: \"" + hero.getTitle() + "\",")
              .append(" SkillPoint: \"" + hero.getSkillPoint() + "\",").append(" SkillPointExp: \"" + hero.getSkillPointExp() + "\",")
              .append(" Usetips: \"" + hero.getUsetips() + "\",").append(" BetterCombat: \"" + hero.getBetterCombat() + "\",")
              .append(" Wartips: \"" + hero.getWartips() + "\"})")
              .append(" ,");
    });
    heroList.forEach(hero -> {
      hero.getParternerList().forEach(parternerHero -> {
        sql.append("(" + namePinyinCache.get(hero.getName()) + ")-[:parterner {desc: '" + parternerHero.getInfo() + "'}]->(" + namePinyinCache.get(parternerHero.getHero().getName()) + ")")
                .append(" ,");
      });
    });
    heroList.forEach(hero -> {
      hero.getResistHeroList().forEach(resistHero -> {
        sql.append("(" + namePinyinCache.get(resistHero.getHero().getName()) + ")-[:resist {desc: '" + resistHero.getInfo() + "'}]->(" + namePinyinCache.get(hero.getName()) + ")")
                .append(" ,");
      });
    });
    heroList.forEach(hero -> {
      hero.getInhibitHeroList().forEach(inhibitHero -> {
        sql.append("(" + namePinyinCache.get(hero.getName()) + ")-[:inhibit {desc: '" + inhibitHero.getInfo() + "'}]->(" + namePinyinCache.get(inhibitHero.getHero().getName()) + ")")
                .append(" ,");
      });
    });
    System.out.println(sql);
  }

}
