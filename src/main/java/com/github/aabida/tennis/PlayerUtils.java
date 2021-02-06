package com.github.aabida.tennis;

import java.util.Arrays;

public class PlayerUtils {

    public static boolean isScoreIn(Score current, Score... list) {
        return Arrays.asList(list).contains(current);
    }
}
