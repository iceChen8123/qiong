package com.ice.wangzherongyao.relationhero;

import lombok.Data;

//inhibit1/inhibit2...
//in_tip1/in_tip2...
@Data
public class InhibitHero extends RelationHero {

  @Override
  String relation() {
    return this.getClass().getSimpleName();
  }
}
