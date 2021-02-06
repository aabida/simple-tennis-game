package com.github.aabida.tennis;

import java.util.Scanner;

public class TennisGame {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("||     Welcome to Simple Tennis Game !   ||");
        System.out.println("===========================================");

        System.out.println("Please enter the name of the first player : ");
        String firstPlayerName = scan.nextLine();

        System.out.println("Please enter the name of the second player :");
        String secondPlayerName = scan.nextLine();

        System.out.println(firstPlayerName);
        System.out.println(secondPlayerName);
    }
}
