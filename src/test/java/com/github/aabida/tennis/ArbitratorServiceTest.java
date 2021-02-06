package com.github.aabida.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArbitratorServiceTest {

    @Test
    void should_increment_player_with_no_winner() {
        Player firstPlayer = new Player("Rafael Nadal", Score.LOVE);
        Player secondPlayer = new Player("Roger Federer", Score.LOVE);

        ArbitratorService sut = new ArbitratorService(firstPlayer, secondPlayer);

        sut.incrementScoreFor(firstPlayer);

        assertEquals(Score.FIFTEEN, firstPlayer.getScore());
        assertEquals(Score.LOVE, secondPlayer.getScore());
    }
}
