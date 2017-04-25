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
        boolean result = evaluator.evaluate(cardList);
        assertThat(result, is(true));
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
        boolean result = evaluator.evaluate(cardList);
        assertThat(result, is(true));
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
        boolean result = evaluator.evaluate(cardList);
        assertThat(result, is(true));
    }
}
