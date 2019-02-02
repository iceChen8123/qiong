package com.ice.wangzherongyao.relationhero;

import lombok.Data;

//resist1/resist2...
//re_tip1/re_tip2...
@Data
public class ResistHero extends RelationHero {

  @Override
  String relation() {
    return this.getClass().getSimpleName();
  }

}
