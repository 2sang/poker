package com.edu.cnu.poker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by cse on 2017-04-17.
 */
public class EvaluatorTest {

    @Test
    public void SUIT가_5개가동일하면_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        Map<Suit, Integer> suitCounts = evaluator.suitCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.FLUSH));
    }

    @Test
    public void 같은_숫자의_카드가_두장이면_원페어다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(13, Suit.SPADES),
                new Card(13, Suit.DIAMONDS),
                new Card(3, Suit.HEARTS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.SPADES)
        );
        Map<Integer, Integer> rankCounts = evaluator.rankCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.ONE_PAIR));
    }

    @Test
    public void 같은_숫자의_카드가_두쌍_존재하면_투페어다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2, Suit.SPADES),
                new Card(2, Suit.DIAMONDS),
                new Card(3, Suit.HEARTS),
                new Card(3, Suit.CLUBS),
                new Card(5, Suit.SPADES)
        );
        Map<Integer, Integer> rankCounts = evaluator.rankCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.TWO_PAIR));
    }

    @Test
    public void 같은_숫자의_카드가_세장이면_트리플이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2, Suit.SPADES),
                new Card(5, Suit.HEARTS),
                new Card(5, Suit.DIAMONDS),
                new Card(5, Suit.SPADES),
                new Card(11, Suit.SPADES)
        );
        Map<Integer, Integer> rankCounts = evaluator.rankCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.TRIPLE));
    }

    @Test
    public void 같은_숫자의_카드가_네장이면_포카드다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4, Suit.SPADES),
                new Card(4, Suit.DIAMONDS),
                new Card(4, Suit.HEARTS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.SPADES)
        );
        Map<Integer, Integer> rankCounts = evaluator.rankCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.FOUR_CARD));
    }

    @Test
    public void 무늬가_같지않고_5장의_숫자가_연속이면_스트레이트다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(13, Suit.SPADES),
                new Card(12, Suit.DIAMONDS),
                new Card(11, Suit.HEARTS),
                new Card(10, Suit.CLUBS),
                new Card(9, Suit.SPADES)
        );
        Map<Integer, Integer> rankCounts = evaluator.rankCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.STRAIGHT));
    }

    @Test
    public void 무늬가_같지않고_A_2_3_4_5_숫자가_연속이면_백스트레이트다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.SPADES),
                new Card(2, Suit.DIAMONDS),
                new Card(3, Suit.HEARTS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.SPADES)
        );
        Map<Integer, Integer> rankCounts = evaluator.rankCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.BACK_STRAIGHT));
    }

    @Test
    public void 무늬가_같지않고_10_J_Q_K_A_숫자가_연속이면_마운틴이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(10, Suit.SPADES),
                new Card(11, Suit.DIAMONDS),
                new Card(12, Suit.HEARTS),
                new Card(13, Suit.CLUBS),
                new Card(1, Suit.SPADES)
        );
        Map<Integer, Integer> rankCounts = evaluator.rankCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.MOUNTAIN));
    }

    @Test
    public void 무늬가_같고_숫자가_연속이면_스트레이트플러쉬이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2, Suit.CLUBS),
                new Card(3, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.CLUBS),
                new Card(6, Suit.CLUBS)
        );
        Map<Suit, Integer> suitCounts = evaluator.suitCountFromCards(cardList);
        Map<Integer, Integer> rankCounts = evaluator.rankCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.STRAIGHT_FLUSH));
    }

    @Test
    public void 같은_숫자_3개와_같은_숫자_2개이면_풀하우스다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2, Suit.SPADES),
                new Card(2, Suit.DIAMONDS),
                new Card(5, Suit.HEARTS),
                new Card(5, Suit.CLUBS),
                new Card(5, Suit.SPADES)
        );
        Map<Integer, Integer> rankCounts = evaluator.rankCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.FULL_HOUSE));
    }

    @Test
    public void 무늬가_같으면서_A_2_3_4_5_숫자가_연속이면_백스트레이트_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.SPADES),
                new Card(2, Suit.SPADES),
                new Card(3, Suit.SPADES),
                new Card(4, Suit.SPADES),
                new Card(5, Suit.SPADES)
        );
        Map<Suit, Integer> suitCounts = evaluator.suitCountFromCards(cardList);
        Map<Integer, Integer> rankCounts = evaluator.rankCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.BACK_STRAIGHT_FLUSH));
    }

    @Test
    public void 무늬가_같으면서_10_11_12_13_A_숫자가_연속이면_로얄스트레이트_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(10, Suit.SPADES),
                new Card(11, Suit.SPADES),
                new Card(12, Suit.SPADES),
                new Card(13, Suit.SPADES),
                new Card(1, Suit.SPADES)
        );
        Map<Suit, Integer> suitCounts = evaluator.suitCountFromCards(cardList);
        Map<Integer, Integer> rankCounts = evaluator.rankCountFromCards(cardList);
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.ROYAL_STRAIGHT_FLUSH));
    }

}
