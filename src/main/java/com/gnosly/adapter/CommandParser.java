package com.gnosly.adapter;


import com.gnosly.domain.Game;

import java.util.Optional;

public class CommandParser {

    public Optional<Game.Move> parse(String command) {
        try {
            return Optional.of(Game.Move.valueOf(command.toUpperCase()));
        } catch (IllegalArgumentException i) {
            return Optional.empty();
        }
    }
}
