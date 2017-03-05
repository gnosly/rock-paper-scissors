package com.gnosly.domain;

public class RandomMoveSelection implements MoveSelection {

    @Override
    public Game.Move next() {
        int randomClass = (int) ((Math.random() * 100) % 3);
        return Game.Move.values()[randomClass];
    }
}
