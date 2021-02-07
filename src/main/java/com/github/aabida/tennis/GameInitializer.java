package com.github.aabida.tennis;

import com.github.aabida.tennis.data.provider.KeyboardScoreProvider;

import java.util.Scanner;

public class GameInitializer {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("||||    Welcome to Simple Tennis Game !    ||||");
        System.out.println("===============================================");
        System.out.println("===============================================");

        System.out.println("Please enter the name of the first player : ");
        String firstPlayerName = scan.nextLine();

        System.out.println("Please enter the name of the second player :");
        String secondPlayerName = scan.nextLine();

        TennisGame game = new TennisGame(firstPlayerName, secondPlayerName, new KeyboardScoreProvider());
        game.initGame();
        game.runGame();
    }
}
