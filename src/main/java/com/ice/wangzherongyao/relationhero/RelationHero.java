package com.ice.wangzherongyao.relationhero;

import com.ice.wangzherongyao.Hero;
import lombok.Data;

@Data
public abstract class RelationHero {

  abstract String relation();

  private Hero hero;

  private String info;

}
