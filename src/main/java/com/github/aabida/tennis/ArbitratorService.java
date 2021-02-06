package com.github.aabida.tennis;

public class ArbitratorService {

    private final Player firstPlayer;
    private final Player secondPlayer;

    private Player winner;

    public ArbitratorService(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void incrementScoreFor(Player player) {
        Player winner, theOtherPlayer;
        if (player.equals(firstPlayer)) {
            winner = firstPlayer;
            theOtherPlayer = secondPlayer;
        }
        else {
            winner = secondPlayer;
            theOtherPlayer = firstPlayer;
        }
        if (isGameFirstSteps(player)) {

        }
    }

    private boolean isGameFirstSteps(Player winner) {
        return PlayerUtils.isScoreIn(winner.getScore(), Score.LOVE, Score.FIFTEEN, Score.THIRTY);
    }
}
