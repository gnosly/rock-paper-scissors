package com.gnosly.domain;

public enum Player {
    HUMAN, MACHINE;

    public PlayerMove move(Move move) {
        return new PlayerMove(this, move);
    }
}
