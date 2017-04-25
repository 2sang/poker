package com.edu.cnu.poker;

/**
 * Created by sangsulee on 4/25/17.
 */
public enum HandRank {

    ROYAL_STRAIGHT_FLUSH(13),
    BACK_STRAIGHT_FLUSH(12),
    STRAIGHT_FLUSH(11),
    FOUR_CARD(10),
    FULL_HOUSE(9),
    FLUSH(8),
    MOUNTAIN(7),
    BACK_STRAIGHT(6),
    STRAIGHT(5),
    TRIPLE(4),
    TWO_PAIR(3),
    ONE_PAIR(2),
    TOP(1);

    private int rankOfCard;
    private HandRank(int rankOfCards){
        this.rankOfCard = rankOfCards;
    }
}
