package com.ice.wangzherongyao.relationhero;

import com.ice.wangzherongyao.HeroIdCache;
import lombok.Data;

@Data
public abstract class RelationHero {

  abstract String relation();

  private String heroId;

  private String heroName;

  private String info;

  public void setHeroId(String heroId) {
    this.heroId = heroId;
    this.heroName = HeroIdCache.getHeroName(heroId);
  }
}
