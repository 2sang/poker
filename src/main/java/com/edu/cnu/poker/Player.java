package com.edu.cnu.poker;

/**
 * Created by 류치현 on 2017-04-25.
 */
public class Player {
    private TotalRank score;
    private Hand myHand;

    public Player(Hand myHand) {
        this.myHand = myHand;
    }

    public void setScore(TotalRank score) {
        this.score = score;
    }

    public TotalRank getScore() {
        return this.score;
    }

}
