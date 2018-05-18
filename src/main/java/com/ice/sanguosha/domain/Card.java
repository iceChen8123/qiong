package com.ice.sanguosha.domain;

import lombok.Data;
import lombok.Getter;

@Data
public class Card {

  private int point;

  private ColorType colorType;

  @Getter
  public enum ColorType {
    Heart("红心"),
    Spade("黑桃"),
    Diamond("方块"),
    Club("梅花");

    String cname;

    ColorType(String cname) {
      this.cname = cname;
    }
  }
}
