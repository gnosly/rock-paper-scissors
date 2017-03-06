package com.gnosly.domain;

public class FixedMoveSelection implements MoveSelection {

    private Move fixedMove;

    public FixedMoveSelection(Move fixedMove) {
        this.fixedMove = fixedMove;
    }

    public Move next() {
        return fixedMove;
    }
}
