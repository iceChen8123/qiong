package com.ice.sanguosha.domain;

import lombok.Data;

import java.util.List;

@Data
public class Player {

  private String id;

  private String name;

  private int healthPoint;

  private List<HeroCard> heroList;

  private List<Card> inHandCardList;

  private List<EquipmentCard> equipmentCardOnShowList;

  private List<TipCard> effectOnMeTipCardList;

  public void addHealthPoint(int point) {
    healthPoint += point;
  }

  public void deductHealthPoint(int point) {
    healthPoint -= point;
  }
}
