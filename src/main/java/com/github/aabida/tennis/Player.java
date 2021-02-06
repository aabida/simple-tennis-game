package com.github.aabida.tennis;

import java.util.Objects;

public class Player {

    private final String name;
    private Score score;

    public Player(String name, Score score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
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
