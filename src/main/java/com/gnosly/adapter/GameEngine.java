package com.gnosly.adapter;

import com.gnosly.domain.Game;

import java.util.Optional;

public class GameEngine {

    private final Game game;
    private final CommandParser commandParser = new CommandParser();
    private final ResultPrinter resultPrinter = new ResultPrinter();


    public GameEngine(Game game) {
        this.game = game;
    }


    public static void main(Object[] args) {

    }

    public Optional<String> loop(String commandToParse) {
        if ("exit".equalsIgnoreCase(commandToParse))
            return Optional.empty();

        return commandParser.parse(commandToParse).
                map(move -> game.play(move)).
                map(result -> resultPrinter.print(result)).
                orElse(Optional.of("Invalid command."));
    }
}
