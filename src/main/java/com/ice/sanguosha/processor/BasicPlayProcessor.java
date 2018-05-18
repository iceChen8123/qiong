package com.ice.sanguosha.processor;

import com.ice.sanguosha.domain.BasicCard;
import com.ice.sanguosha.domain.Card;
import com.ice.sanguosha.domain.Player;

public class BasicPlayProcessor {

  public static void playOneCard(Player fromPlayer, Player toPlayer, BasicCard card) {
    switch (card.getType()) {
      case Slash:
        slashPlayer(fromPlayer, toPlayer);
        break;
      case Peach:
        peachPlayer(fromPlayer, toPlayer);
        break;
    }
  }

  private static void peachPlayer(Player fromPlayer, Player toPlayer) {
    int addPoint = calAddPointForPeach(fromPlayer, toPlayer);
    toPlayer.addHealthPoint(addPoint);
  }

  private static int calAddPointForPeach(Player fromPlayer, Player toPlayer) {
    return 1;
  }

  private static void slashPlayer(Player fromPlayer, Player toPlayer) {
    int deductPoint = calDeductPointForSlash(fromPlayer, toPlayer);
    toPlayer.deductHealthPoint(deductPoint);
  }

  private static int calDeductPointForSlash(Player fromPlayer, Player toPlayer) {
//    if(){
//
//    }

    return 1;
  }

  public static void playOneCardToAnother(Player fromPlayer, Player toPlayer, BasicCard playCard, Card toCard) {
    switch (playCard.getType()) {
      case Dodge:
        dodgeSlash(fromPlayer, toPlayer, toCard);
        break;
    }
  }

  private static void dodgeSlash(Player fromPlayer, Player toPlayer, Card toCard) {
    //TODO
  }

}
