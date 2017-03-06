package com.gnosly.domain;

public class Game {

    public enum Player {
        HUMAN, MACHINE;

        public PlayerMove move(Move move) {
            return new PlayerMove(this, move);
        }
    }

    public enum Move {
        ROCK {
            @Override
            public boolean winAgainst(Move move) {
                return SCISSORS.equals(move);
            }
        }, PAPER {
            @Override
            public boolean winAgainst(Move move) {
                return ROCK.equals(move);
            }
        }, SCISSORS {
            @Override
            public boolean winAgainst(Move move) {
                return PAPER.equals(move);
            }
        };

        public abstract boolean winAgainst(Move move);
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
