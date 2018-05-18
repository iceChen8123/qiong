package com.ice.sanguosha.domain;

import lombok.Data;

import java.util.List;

@Data
public class HeroCard {

  private String name;

  private List<Skill> skillList;

  public enum Country {
    WEI,
    SHU,
    WU,
    QUN
  }

}
