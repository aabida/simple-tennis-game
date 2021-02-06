package com.github.aabida.tennis;

import java.util.Scanner;

public class ScoreProvider {

    private static final Scanner scan = new Scanner(System.in);

    public int readNext() {
        System.out.println("==============================================");
        System.out.println("Please enter which player scored (enter 1 or 2):");
        return scan.nextInt();
    }
}
