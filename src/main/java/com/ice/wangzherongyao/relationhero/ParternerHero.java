package com.ice.wangzherongyao.relationhero;

import lombok.Data;

//partner1/partner2...
//part_tip1/part_yip2...
@Data
public class ParternerHero extends RelationHero {

  @Override
  String relation() {
    return this.getClass().getSimpleName();
  }
}
