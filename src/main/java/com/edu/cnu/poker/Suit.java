package com.edu.cnu.poker;

/**
 * Created by cse on 2017-04-17.
 */
public enum Suit {

    SPADES(4),
    HEARTS(3),
    CLUBS(2),
    DIAMONDS(1);

    private int rankOfSuit;
    private Suit(int rank){
        this.rankOfSuit = rank;
    };
}
