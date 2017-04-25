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
    }

    public HandRank evaluate(List<Card> cardList) {
        return null;
    }

    public boolean isFlush(List<Card> cardList) {

        for (Card card : cardList) {
            if (suitCounts.containsKey(card.getSuit())) {
                Integer count = suitCounts.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                suitCounts.put(card.getSuit(), count);
            } else {
                suitCounts.put(card.getSuit(), new Integer(1));
            }
        }

        for (Suit key : suitCounts.keySet()) {
            if (suitCounts.get(key) == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean isOnePair(List<Card> cardList) {

        for (Card card : cardList) {
            if (rankCounts.containsKey(card.getRank())) {
                Integer concatCount = rankCounts.get(card.getRank());
                concatCount = new Integer(concatCount.intValue() + 1);
                rankCounts.put(card.getRank(), concatCount);
            }  else {
                rankCounts.put(card.getRank(), new Integer(1));
            }
        }

        for (int key : rankCounts.keySet()) {
            if (rankCounts.get(key) == 2) {
                return true;
            }
        }
        System.out.println(this.rankCounts);
        return false;
    }

    public boolean isTriple(List<Card> cardList) {

        for (Card card : cardList) {
            if (rankCounts.containsKey(card.getRank())) {
                Integer count = rankCounts.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                rankCounts.put(card.getRank(), count);
            }  else {
                rankCounts.put(card.getRank(), new Integer(1));
            }
        }

        for (int key : rankCounts.keySet()) {
            if (rankCounts.get(key) == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isFourCard(List<Card> cardList) {

        for (Card card : cardList) {
            if (rankCounts.containsKey(card.getRank())) {
                Integer count = rankCounts.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                rankCounts.put(card.getRank(), count);
            } else {
                rankCounts.put(card.getRank(), new Integer(1));
            }
        }

        for (Integer key : rankCounts.keySet()) {
            if (rankCounts.get(key) == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isStraight(List<Card> cardList) {

        for (Card card : cardList) {
            if (rankCounts.containsKey(card.getRank())) {
                Integer count = rankCounts.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                rankCounts.put(card.getRank(), count);
            } else {
                rankCounts.put(card.getRank(), new Integer(1));
            }
        }

        int straightCount = 0;
        for (Integer key : rankCounts.keySet()) {
            if ((rankCounts.containsKey(key + 1) || rankCounts.containsKey(key - 1)) && (key != 1)){
                straightCount++;
            }
        }
        if (straightCount == 5)
            return true;
        return false;
    }

    private boolean isBackStraight(List<Card> cardList) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        int totalRank = 0;

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getRank())) {
                Integer count = tempMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getRank(), count);
            } else {
                tempMap.put(card.getRank(), new Integer(1));
            }
        }

        for (Integer key : tempMap.keySet())
                totalRank = totalRank + key;

        if (totalRank == 15)
            return true;
        else
            return false;
    }
}
