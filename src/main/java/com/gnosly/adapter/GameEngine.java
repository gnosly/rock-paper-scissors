package com.gnosly.adapter;

import com.gnosly.domain.Game;
import com.gnosly.domain.Result;

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

        Game.Move humanMove = commandParser.parse(commandToParse);

        Result result = game.play(humanMove);

        return resultPrinter.print(result);
    }
}
