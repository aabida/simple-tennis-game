package com.github.aabida.tennis;

import java.util.Objects;

public class Player {

    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && score == player.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
