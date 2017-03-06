package com.gnosly.domain;

import java.util.Objects;

public class Tie implements Result {

    private final Move tieMove;

    public Tie(Move tieMove) {
        this.tieMove = tieMove;
    }


    public Move getTieMove() {
        return tieMove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tie tie = (Tie) o;
        return tieMove == tie.tieMove;
    }


    @Override
    public int hashCode() {
        return Objects.hash(tieMove);
    }
}
