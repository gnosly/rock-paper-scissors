package com.gnosly.domain;

import java.util.Objects;

public class Win implements Result {
    private final Game.Player winner;

    public Win(Game.Player winner) {
        this.winner = winner;
    }

    public Game.Player getWinner() {
        return winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Win win = (Win) o;
        return winner == win.winner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winner);
    }

    @Override
    public String toString() {
        return "com.gnosly.domain.Win{" +
                "winner=" + winner +
                '}';
    }
}
