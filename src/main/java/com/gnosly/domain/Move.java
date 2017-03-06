package com.gnosly.domain;

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
