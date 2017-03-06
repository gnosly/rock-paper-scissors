package com.gnosly.domain;

import java.util.Objects;

public class PlayerMove {
    private final Player player;
    private final Move move;

    public PlayerMove(Player player, Move move) {
        this.player = player;
        this.move = move;
    }

    public Result vs(PlayerMove otherPlayerMove) {

        if (move == otherPlayerMove.move) {
            return new Tie(move);
        }

        return move.winAgainst(otherPlayerMove.move) ?
                new Win(this, otherPlayerMove) :
                new Win(otherPlayerMove, this);
    }

    public Player getPlayer() {
        return player;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerMove that = (PlayerMove) o;
        return player == that.player &&
                move == that.move;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, move);
    }
}
