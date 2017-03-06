package com.gnosly.domain;

public class Game {

    public enum Player {
        HUMAN, MACHINE;

        public PlayerMove move(Move move) {
            return new PlayerMove(this, move);
        }
    }

    private final MoveSelection machineMoveSelection;

    public Game(MoveSelection machineMoveSelection) {
        this.machineMoveSelection = machineMoveSelection;
    }

    public Result play(Move move) {
        PlayerMove machineMove = new PlayerMove(Player.MACHINE, machineMoveSelection.next());
        PlayerMove humanMove = new PlayerMove(Player.HUMAN, move);

        return machineMove.vs(humanMove);
    }

}
