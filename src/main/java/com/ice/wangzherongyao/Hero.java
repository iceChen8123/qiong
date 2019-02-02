package com.ice.wangzherongyao;

import com.ice.wangzherongyao.relationhero.InhibitHero;
import com.ice.wangzherongyao.relationhero.ParternerHero;
import com.ice.wangzherongyao.relationhero.ResistHero;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hero {

  private String id;//ename

  private String tagId;

  private String name;//cname

  private String title;//title

  private String skin;//skin_name

  private String story;//story

  private String history;//history

  private List<Skill> skills = new ArrayList<>(10);

  private String skillPoint;//add_skill1 TODO

  private String skillPointExp;//add_skill_exp1 TODO

  private String mingWenExp;//fuwenid_exp

  private List<ParternerHero> parternerList;

  private List<InhibitHero> inhibitHeroList;

  private List<ResistHero> resistHeroList;

  private String parterners;
  private String inhibitHeros;
  private String resistHeros;

  public String getParterners() {
    StringBuilder names = new StringBuilder();
    if (!CollectionUtils.isEmpty(parternerList)) {
      parternerList.forEach(parterner -> names.append("(").append(parterner.getHero().getName()).append(":")
              .append(parterner.getInfo()).append(")"));
    }
    return names.toString();
  }

  public String getInhibitHeros() {
    StringBuilder names = new StringBuilder();
    if (!CollectionUtils.isEmpty(inhibitHeroList)) {
      inhibitHeroList.forEach(parterner -> names.append("(").append(parterner.getHero().getName()).append(":")
              .append(parterner.getInfo()).append(")"));
    }
    return names.toString();
  }

  public String getResistHeros() {
    StringBuilder names = new StringBuilder();
    if (!CollectionUtils.isEmpty(resistHeroList)) {
      resistHeroList.forEach(parterner -> names.append("(").append(parterner.getHero().getName()).append(",").append(":")
              .append(parterner.getInfo()).append(")"));
    }
    return names.toString();
  }

  private String usetips;//usetips/use_tips 使用技巧

  private String betterCombat;//resisttips 对抗技巧

  private String wartips;//wartips 团战思路

  private String changetime;//changetime

  private String changetip;//changetip

  private String surviveTag;//survive_tag

  private String attackTag;//attack_tag

  private String skillTag;//skill_tag

  private String difficultyTag;//difficulty_tag

  private String road;//road

}
