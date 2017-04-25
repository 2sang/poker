package com.edu.cnu.poker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by 류치현 on 2017-04-25.
 */
public class GameTest {
    @Test
    public void 게임테스트() {
        Game game = new Game();
        game.gaming();
    }
}
