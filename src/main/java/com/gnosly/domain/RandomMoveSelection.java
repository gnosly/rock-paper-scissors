package com.gnosly.domain;

public class RandomMoveSelection implements MoveSelection {

    @Override
    public Move next() {
        int randomClass = (int) ((Math.random() * 100) % 3);
        return Move.values()[randomClass];
    }
}
