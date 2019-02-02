package com.ice.wangzherongyao.util;

import com.ice.wangzherongyao.Hero;
import org.springframework.util.CollectionUtils;

public class SimpleHeroInfoFormat implements HeroInfoFormat {

  private static final String SEPRATOR = ":";

  @Override
  public String fromHero(Hero hero) {
    StringBuilder info = new StringBuilder();
    info.append(hero.getName()).append(System.lineSeparator());
    info.append("�ӵ�").append(SEPRATOR).append(hero.getSkillPoint()).append(System.lineSeparator());
    info.append("�ӵ�˼·").append(SEPRATOR).append(hero.getSkillPointExp()).append(System.lineSeparator());
    info.append("��˼·").append(SEPRATOR).append(hero.getAttackTag()).append(System.lineSeparator());
    info.append("�����ص�").append(SEPRATOR).append(hero.getSkillTag()).append(System.lineSeparator());
    info.append("��������").append(SEPRATOR).append(hero.getUsetips()).append(System.lineSeparator());
    info.append("С����·").append(SEPRATOR).append(hero.getBetterCombat()).append(System.lineSeparator());
    info.append("��ս����").append(SEPRATOR).append(hero.getWartips()).append(System.lineSeparator());

    info.append("�ʺϴ���").append(SEPRATOR).append(System.lineSeparator());
    if (!CollectionUtils.isEmpty(hero.getParternerList())) {
      hero.getParternerList().forEach(relationHero -> {
        info.append(" ").append(relationHero.getHero().getName()).append(SEPRATOR).append(relationHero.getInfo()).append(System.lineSeparator());
      });
    }

    info.append("����Ӣ��").append(SEPRATOR).append(System.lineSeparator());
    if (!CollectionUtils.isEmpty(hero.getInhibitHeroList())) {
      hero.getInhibitHeroList().forEach(relationHero -> {
        info.append(" ").append(relationHero.getHero().getName()).append(SEPRATOR).append(relationHero.getInfo()).append(System.lineSeparator());
      });
    }

    info.append("��ѹ��Ӣ��").append(SEPRATOR).append(System.lineSeparator());
    if (!CollectionUtils.isEmpty(hero.getResistHeroList())) {
      hero.getResistHeroList().forEach(relationHero -> {
        info.append(" ").append(relationHero.getHero().getName()).append(SEPRATOR).append(relationHero.getInfo()).append(System.lineSeparator());
      });
    }

    info.append("����ʱ��").append(SEPRATOR).append(hero.getChangetime()).append(System.lineSeparator());
    info.append("����˼·").append(SEPRATOR).append(hero.getChangetip()).append(System.lineSeparator());

    return info.toString();
  }

}
