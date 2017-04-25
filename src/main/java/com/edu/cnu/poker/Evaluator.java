package com.edu.cnu.poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {


    private List<Card> cardList;
    private Map<Suit, Integer> suitCounts;
    private Map<Integer, Integer> rankCounts;

    public Evaluator() {
        this.cardList = null;
        suitCounts = new HashMap<Suit, Integer>();
        rankCounts = new HashMap<Integer, Integer>();
    }

    public Evaluator(List<Card> cardList){
        this.cardList = cardList;
        suitCounts = new HashMap<Suit, Integer>();
        rankCounts = new HashMap<Integer, Integer>();

        suitCounts = suitCountFromCards(this.cardList);
        rankCounts = rankCountFromCards(this.cardList);
    }

    public HandRank evaluate(List<Card> cardList) {

        Map<Suit, Integer> suitCounts = this.suitCountFromCards(cardList);
        Map<Integer, Integer> rankCounts = this.rankCountFromCards(cardList);

        HandRank handRank = this.evaluateHandRank(suitCounts, rankCounts);
        return handRank;
    }
    private HandRank evaluateHandRank(Map<Suit, Integer> suitCounts, Map<Integer, Integer> rankCounts){

        if (this.isRoyalStraightFlush(suitCounts, rankCounts))
            return HandRank.ROYAL_STRAIGHT_FLUSH;

        if (this.isBackStraightFlush(suitCounts, rankCounts))
            return HandRank.BACK_STRAIGHT_FLUSH;

        if (this.isStraightFlush(suitCounts, rankCounts))
            return HandRank.STRAIGHT_FLUSH;

        if (this.isFourCard(rankCounts))
            return HandRank.FOUR_CARD;

        if (this.isFullHouse(rankCounts))
            return HandRank.FULL_HOUSE;

        if (this.isFlush(suitCounts))
            return HandRank.FLUSH;

        if (this.isMountain(rankCounts))
            return HandRank.MOUNTAIN;

        if (this.isBackStraight(rankCounts))
            return HandRank.BACK_STRAIGHT;

        if (this.isStraight(rankCounts))
            return HandRank.STRAIGHT;

        if (this.isTriple(rankCounts))
            return HandRank.TRIPLE;

        if (this.isTwoPair(rankCounts))
            return HandRank.TWO_PAIR;

        if (this.isOnePair(rankCounts))
            return HandRank.ONE_PAIR;

        return HandRank.TOP;
    }

    public boolean isFlush(Map<Suit, Integer> suitCounts) {

        for (Suit key : suitCounts.keySet()) {
            if (suitCounts.get(key) == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean isOnePair(Map<Integer, Integer> rankCounts) {

        for (int key : rankCounts.keySet()) {
            if (rankCounts.get(key) == 2) {
                return true;
            }
        }
        System.out.println(this.rankCounts);
        return false;
    }

    public boolean isTwoPair(Map<Integer, Integer> rankCounts){

        int pairCount = 0;
        for (int key : rankCounts.keySet()) {
            if (rankCounts.get(key) == 2) {
                pairCount++;
            }
        }

        if(pairCount >= 2){
            return true;
        }

        return false;
    }

    public boolean isTriple(Map<Integer, Integer> rankCounts) {

        for (int key : rankCounts.keySet()) {
            if (rankCounts.get(key) == 3) {
                return true;
            }
        }
        return false;
    }


    public boolean isFourCard(Map<Integer, Integer> rankCounts) {

        for (Integer key : rankCounts.keySet()) {
            if (rankCounts.get(key) == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isStraight(Map<Integer, Integer> rankCounts) {

        int straightCount = 0;
        for (Integer key : rankCounts.keySet()) {
            if ((rankCounts.containsKey(key + 1) || rankCounts.containsKey(key - 1))){
                straightCount++;
            }
        }
        if (straightCount == 5)
            return true;
        return false;
    }

    public boolean isBackStraight(Map<Integer, Integer> rankCounts) {

        int totalRank = 0;
        for (Integer key : rankCounts.keySet())
                totalRank = totalRank + key;

        if (totalRank == 15)
            return true;
        else
            return false;
    }

    public boolean isMountain(Map<Integer, Integer> rankCounts) {

        int totalRank = 0;
        for (Integer key : rankCounts.keySet())
            totalRank = totalRank + key;

        if (totalRank == 47)
            return true;
        else
            return false;
    }
    public boolean isStraightFlush(Map<Suit, Integer> suitCounts, Map<Integer, Integer> rankCounts) {
        if ( isStraight(rankCounts)
                && isFlush(suitCounts)
                && !isBackStraight(rankCounts)
                && !isMountain(rankCounts))
            return true;
        return false;
    }


    public boolean isRoyalStraightFlush(Map<Suit, Integer> suitCounts, Map<Integer, Integer> rankCounts) {
        if(isMountain(rankCounts) && isFlush(suitCounts))
            return true;
        return false;
    }

    public boolean isBackStraightFlush(Map<Suit, Integer> suitCounts, Map<Integer, Integer> rankCounts) {
        if ( isBackStraight(rankCounts)
                && isFlush(suitCounts))
            return true;
        return false;
    }

    public Map<Suit, Integer> suitCountFromCards(List<Card> cardList){
        Map<Suit, Integer> suitCounts = new HashMap<Suit, Integer>();
        for (Card card : cardList) {

            if (suitCounts.containsKey(card.getSuit())) {
                Integer count = suitCounts.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                suitCounts.put(card.getSuit(), count);
            } else {
                suitCounts.put(card.getSuit(), new Integer(1));
            }
        }
        return suitCounts;

    }

    public Map<Integer, Integer> rankCountFromCards(List<Card> cardList){

        Map<Integer, Integer> rankCounts = new HashMap<Integer, Integer>();
        for (Card card : cardList) {
            if (rankCounts.containsKey(card.getRank())) {
                Integer count = rankCounts.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                rankCounts.put(card.getRank(), count);
            } else {
                rankCounts.put(card.getRank(), new Integer(1));
            }
        }
        return rankCounts;
    }


    public boolean isFullHouse(Map<Integer, Integer> rankCounts) {

        int pairCounts = 0;
        for (int key : rankCounts.keySet()) {
            if (rankCounts.get(key) == 3 ) {
                pairCounts = pairCounts + 2;
            }
            if (rankCounts.get(key) == 2) {
                pairCounts++;
            }
        }
        if (pairCounts >= 3)
            return true;
        else
            return false;
    }
}
