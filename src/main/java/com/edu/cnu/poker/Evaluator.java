package com.edu.cnu.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public boolean evaluate(List<Card> cardList) {
        boolean jokbo;
        //jokbo = isFlush(cardList);
        //jokbo = isOnePair(cardList);
        jokbo = isTriple(cardList);
        return jokbo;
    }

    private boolean isFlush(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }
        }

        for (Suit key : tempMap.keySet()) {
            if (tempMap.get(key) == 5) {
                return true;
            }
        }
        return false;
    }

    private  boolean isOnePair(List<Card> cardList) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getRank())) {
                Integer count = tempMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getRank(), count);
            }  else {
                tempMap.put(card.getRank(), new Integer(1));
            }
        }

        for (int key : tempMap.keySet()) {
            if (tempMap.get(key) == 2) {
                return true;
            }
        }
        return false;
    }

    private  boolean isTriple(List<Card> cardList) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getRank())) {
                Integer count = tempMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getRank(), count);
            }  else {
                tempMap.put(card.getRank(), new Integer(1));
            }
        }

        for (int key : tempMap.keySet()) {
            if (tempMap.get(key) == 3) {
                return true;
            }
        }
        return false;
    }
}
