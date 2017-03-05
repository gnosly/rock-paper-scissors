package com.gnosly.domain;

import com.gnosly.domain.Game;
import com.gnosly.domain.MoveSelection;

public class FixedMoveSelection implements MoveSelection {

    private Game.Move fixedMove;

    public FixedMoveSelection(Game.Move fixedMove) {
        this.fixedMove = fixedMove;
    }

    public Game.Move next() {
        return fixedMove;
    }
}
