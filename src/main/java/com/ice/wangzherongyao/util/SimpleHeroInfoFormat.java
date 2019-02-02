package com.ice.wangzherongyao.util;

import com.ice.wangzherongyao.Hero;
import org.springframework.util.CollectionUtils;

public class SimpleHeroInfoFormat implements HeroInfoFormat {

  private static final String SEPRATOR = ":";

  @Override
  public String fromHero(Hero hero) {
    StringBuilder info = new StringBuilder();
    info.append(hero.getName()).append(System.lineSeparator());
    info.append("加点").append(SEPRATOR).append(hero.getSkillPoint()).append(System.lineSeparator());
    info.append("加点思路").append(SEPRATOR).append(hero.getSkillPointExp()).append(System.lineSeparator());
    info.append("打法思路").append(SEPRATOR).append(hero.getAttackTag()).append(System.lineSeparator());
    info.append("技能特点").append(SEPRATOR).append(hero.getSkillTag()).append(System.lineSeparator());
    info.append("操作技巧").append(SEPRATOR).append(hero.getUsetips()).append(System.lineSeparator());
    info.append("小心套路").append(SEPRATOR).append(hero.getBetterCombat()).append(System.lineSeparator());
    info.append("团战技巧").append(SEPRATOR).append(hero.getWartips()).append(System.lineSeparator());

    info.append("适合搭配").append(SEPRATOR).append(System.lineSeparator());
    if (!CollectionUtils.isEmpty(hero.getParternerList())) {
      hero.getParternerList().forEach(relationHero -> {
        info.append(" ").append(relationHero.getHero().getName()).append(SEPRATOR).append(relationHero.getInfo()).append(System.lineSeparator());
      });
    }

    info.append("克制英雄").append(SEPRATOR).append(System.lineSeparator());
    if (!CollectionUtils.isEmpty(hero.getInhibitHeroList())) {
      hero.getInhibitHeroList().forEach(relationHero -> {
        info.append(" ").append(relationHero.getHero().getName()).append(SEPRATOR).append(relationHero.getInfo()).append(System.lineSeparator());
      });
    }

    info.append("被压制英雄").append(SEPRATOR).append(System.lineSeparator());
    if (!CollectionUtils.isEmpty(hero.getResistHeroList())) {
      hero.getResistHeroList().forEach(relationHero -> {
        info.append(" ").append(relationHero.getHero().getName()).append(SEPRATOR).append(relationHero.getInfo()).append(System.lineSeparator());
      });
    }

    info.append("调整时间").append(SEPRATOR).append(hero.getChangetime()).append(System.lineSeparator());
    info.append("调整思路").append(SEPRATOR).append(hero.getChangetip()).append(System.lineSeparator());

    return info.toString();
  }

}
