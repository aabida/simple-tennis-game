package com.github.aabida.tennis;

import com.github.aabida.tennis.data.provider.ScoreProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TennisGameTest {

    private final ScoreProvider scoreProvider = mock(ScoreProvider.class);

    private TennisGame sut;

    @BeforeEach
    public void init() {
        sut = new TennisGame("firstPlayerName", "secondPlayerName", scoreProvider);
        sut.initGame();
    }

    @Test
    public void runGame_when_first_player_wins_and_assert_game_finished() {
        when(scoreProvider.readNext()).thenReturn(1);

        sut.runGame();

        assertTrue(sut.gameFinished());
        verify(scoreProvider, times(4)).readNext();
    }

    @Test
    public void runGame_when_second_player_wins_and_assert_game_finished() {
        when(scoreProvider.readNext()).thenReturn(2);

        sut.runGame();

        assertTrue(sut.gameFinished());
        verify(scoreProvider, times(4)).readNext();
    }
}
