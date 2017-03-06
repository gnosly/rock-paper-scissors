package com.gnosly.adapter;


import com.gnosly.domain.Move;

import java.util.Optional;

public class CommandParser {

    public Optional<Move> parse(String command) {
        try {
            return Optional.of(Move.valueOf(command.toUpperCase()));
        } catch (IllegalArgumentException i) {
            return Optional.empty();
        }
    }
}
