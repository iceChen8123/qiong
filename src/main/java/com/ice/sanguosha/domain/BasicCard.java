package com.ice.sanguosha.domain;

import lombok.Data;
import lombok.Getter;

@Data
public class BasicCard extends Card {

  private Type type;

  @Getter
  public enum Type {
    Slash("杀"),
    Dodge("闪"),
    Peach("桃");
//    Wine("酒");

    String cname;

    Type(String cname) {
      this.cname = cname;
    }
  }

}
