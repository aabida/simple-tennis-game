package com.github.aabida.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArbitratorServiceTest {

    private Player firstPlayer;
    private Player secondPlayer;
    private ArbitratorService sut;

    @BeforeEach
    public void initGame() {
        firstPlayer = new Player("Rafael Nadal");
        secondPlayer = new Player("Roger Federer");

        sut = new ArbitratorService(firstPlayer, secondPlayer);
    }

    @Test
    public void should_increment_first_player_when_first_steps() {
        sut.incrementFirstPlayerScore();

        assertEquals(1, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
        assertNull(sut.getGameWinner());

        assertEquals("Rafael Nadal (Fifteen) / (Love) Roger Federer", sut.echoScore());
    }

    @Test
    public void should_increment_second_player_when_first_steps() {
        sut.incrementSecondPlayerScore();

        assertEquals(0, firstPlayer.getScore());
        assertEquals(1, secondPlayer.getScore());
        assertNull(sut.getGameWinner());

        assertEquals("Rafael Nadal (Love) / (Fifteen) Roger Federer", sut.echoScore());
    }

    @Test
    public void should_increment_first_player_when_has_30_points() {
        firstPlayer.setScore(2);
        secondPlayer.setScore(2);

        sut.incrementFirstPlayerScore();

        assertEquals(3, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
        assertNull(sut.getGameWinner());

        assertEquals("Rafael Nadal (Forty) / (Thirty) Roger Federer", sut.echoScore());
    }

    @Test
    public void first_player_should_win_when_has_already_40_points() {
        firstPlayer.setScore(3);

        sut.incrementFirstPlayerScore();

        assertEquals(4, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
        assertEquals(firstPlayer, sut.getGameWinner());

        assertEquals("Rafael Nadal wins", sut.echoScore());
    }

    @Test
    public void second_player_should_win_when_has_already_40_points() {
        secondPlayer.setScore(3);

        sut.incrementSecondPlayerScore();

        assertEquals(4, secondPlayer.getScore());
        assertEquals(0, firstPlayer.getScore());
        assertEquals(secondPlayer, sut.getGameWinner());

        assertEquals("Roger Federer wins", sut.echoScore());
    }

    @Test
    public void should_no_winner_when_deuce_and_one_player_scores() {
        firstPlayer.setScore(3);
        secondPlayer.setScore(3);

        sut.incrementFirstPlayerScore();

        assertEquals(4, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
        assertNull(sut.getGameWinner());

        assertEquals("Advantage for Rafael Nadal", sut.echoScore());
    }

    @Test
    public void should_win_when_player_scores_and_has_advantage() {
        firstPlayer.setScore(6);
        secondPlayer.setScore(5);

        sut.incrementFirstPlayerScore();

        assertEquals(7, firstPlayer.getScore());
        assertEquals(5, secondPlayer.getScore());
        assertEquals(firstPlayer, sut.getGameWinner());

        assertEquals("Rafael Nadal wins", sut.echoScore());
    }

    @Test
    public void should_be_deuce_when_player_scores() {
        firstPlayer.setScore(2);
        secondPlayer.setScore(3);

        sut.incrementFirstPlayerScore();

        assertEquals(3, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
        assertNull(sut.getGameWinner());

        assertEquals("Deuce", sut.echoScore());
    }
}
