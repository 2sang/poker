package com.edu.cnu.poker;

/**
<<<<<<< HEAD
 * Created by 류치현 on 2017-04-25.
 */
public class TotalRank {
    private HandRank handRank;
    private int cardRank;
    private Suit suit;

    public TotalRank(HandRank handRank, int cardRank, Suit suit) {
        this.handRank = handRank;
        this.cardRank = cardRank;
        this.suit = suit;
    }

    public int calTotalRank() {
        return handRank.getHandRank() * 255 + cardRank * 15 + suit.getSuit();
    }
}
