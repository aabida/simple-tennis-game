package com.github.aabida.tennis;

public class ArbitratorService {

    private final Player firstPlayer;
    private final Player secondPlayer;

    private Player gameWinner = null;

    public ArbitratorService(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Player getGameWinner() {
        return gameWinner;
    }

    public void incrementFirstPlayerScore() {
        incrementScore(firstPlayer, secondPlayer);
    }

    public void incrementSecondPlayerScore() {
        incrementScore(secondPlayer, firstPlayer);
    }

    public String echoScore() {
        if (gameWinner != null) {
            return String.format("%s wins", gameWinner.getName());
        }
        if (isDeuce()) {
            return "Deuce";
        }
        if (isAdvantage()) {
            Player advantageFor = firstPlayer.getScore() > secondPlayer.getScore() ? firstPlayer : secondPlayer;
            return String.format("Advantage for %s", advantageFor.getName());
        }
        return String.format("%s (%s) / (%s) %s", firstPlayer.getName(), translateSimpleScore(firstPlayer.getScore()), translateSimpleScore(secondPlayer.getScore()), secondPlayer.getName());
    }

    private void incrementScore(Player winner, Player theOtherPlayer) {
        int winnerScore = winner.getScore();
        int theOtherPlayerScore = theOtherPlayer.getScore();

        winner.setScore(++winnerScore);

        if (winnerScore == 4 && theOtherPlayerScore <= 2) {
            this.gameWinner = winner;
        }
        else if (winnerScore >= 3 && theOtherPlayerScore >= 3 && winnerScore >= theOtherPlayerScore + 2) {
            this.gameWinner = winner;
        }
    }

    private boolean isDeuce() {
        int firstPlayerScore = firstPlayer.getScore();
        return firstPlayerScore >= 3 && firstPlayerScore == secondPlayer.getScore();
    }

    private boolean isAdvantage() {
        int firstPlayerScore = firstPlayer.getScore();
        int secondPlayerScore = secondPlayer.getScore();

        return firstPlayerScore >= 3 && secondPlayerScore >= 3 && Math.abs(firstPlayerScore - secondPlayerScore) == 1;
    }

    private String translateSimpleScore(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        throw new IllegalArgumentException("Unable to translate score " + score + ". Should not happen");
    }
}
