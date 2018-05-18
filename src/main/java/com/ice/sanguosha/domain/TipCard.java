package com.ice.sanguosha.domain;

import lombok.Data;
import lombok.Getter;

@Data
public class TipCard extends Card {

  @Getter
  public enum Type {
    BarbarianInvade("南蛮入侵"),
    ArrowRain("万箭齐发"),
    BeSwornBrothers("桃园结义"),
    GoldenHarvest("五谷丰登"),
    Lightning("闪电"),
    TooHappyAndForgetReturn("乐不思蜀"),
    Invulnerable("无懈可击"),
    LeadAwayTheSheepByTheWay("顺手牵羊"),
    BurnTheBridgeAfterCrossing("过河拆桥"),
    Duel("决斗"),
    ComeOutOfThinAir("无中生有");

    String cname;

    Type(String cname) {
      this.cname = cname;
    }
  }
}
