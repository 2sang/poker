package com.edu.cnu.poker;

/**
 * Created by 류치현 on 2017-04-25.
 */
public class Game {
    Deck deck;
    Evaluator evaluator;
    Player player1;
    Player player2;

    public Game() {
        this.deck = new Deck(1);
        this.evaluator = new Evaluator();
        this.player1 = new Player(new Hand(deck, PokerType.FIVE));
        this.player2 = new Player(new Hand(deck, PokerType.FIVE));
    }

    public void gaming() {
        player1.setScore(evaluator.evaluator(deck));
        player2.setScore(evaluator.evaluator(deck));
        player1.

        System.out.println("Player1의 카드 : " + player1.getScore());
        System.out.println("Player2의 카드 : " + player2.getScore());

        if (player1.getScore() > player2.getScore())
            System.out.println("::: Plyaer1이 승리했습니다! :::");
        else
            System.out.println("::: Plyaer2가 승리했습니다! :::");
    }
}
