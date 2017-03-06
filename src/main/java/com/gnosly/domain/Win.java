package com.gnosly.domain;

import java.util.Objects;

public class Win implements Result {


    private final PlayerMove winnerPlayerMove;
    private final PlayerMove loserPlayerMove;


    public Win(PlayerMove winnerPlayerMove, PlayerMove loserPlayerMove) {

        this.winnerPlayerMove = winnerPlayerMove;
        this.loserPlayerMove = loserPlayerMove;
    }


    public PlayerMove getWinnerPlayerMove() {
        return winnerPlayerMove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Win win = (Win) o;
        return Objects.equals(winnerPlayerMove, win.winnerPlayerMove) &&
                Objects.equals(loserPlayerMove, win.loserPlayerMove);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerPlayerMove, loserPlayerMove);
    }

    @Override
    public String toString() {
        return "Win{" +
                "winnerPlayerMove=" + winnerPlayerMove +
                ", loserPlayerMove=" + loserPlayerMove +
                '}';
    }
}
