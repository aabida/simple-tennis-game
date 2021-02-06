package com.github.aabida.tennis;

public class TennisGame {

    private final String firstPlayerName;
    private final String secondPlayerName;
    private final ScoreProvider scoreProvider;

    private ArbitratorService arbitrator;

    public TennisGame(String firstPlayerName, String secondPlayerName, ScoreProvider scoreProvider) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
        this.scoreProvider = scoreProvider;
    }

    public void initGame() {
        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);

        arbitrator = new ArbitratorService(firstPlayer, secondPlayer);
    }

    public void runGame() {
        do {
            int next = scoreProvider.readNext();
            if (next == 1) {
                arbitrator.incrementFirstPlayerScore();
            }
            else if (next == 2) {
                arbitrator.incrementSecondPlayerScore();
            }
            else {
                System.out.println("You entered a wrong value");
            }

            System.out.println(arbitrator.echoScore());
        }
        while (!gameFinished());
    }

    public boolean gameFinished() {
        return arbitrator.getGameWinner() != null;
    }
}
