package com.edu.cnu.poker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.ONE_PAIR));
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
        HandRank result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRank.STRAIGHT));
    }
}
