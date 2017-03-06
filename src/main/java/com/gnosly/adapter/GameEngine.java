package com.gnosly.adapter;

import com.gnosly.domain.Game;
import com.gnosly.domain.RandomMoveSelection;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;

public class GameEngine {

    private final Game game;
    private final CommandParser commandParser = new CommandParser();
    private final ResultPrinter resultPrinter = new ResultPrinter();

    public GameEngine() {
        game = new Game(new RandomMoveSelection());
    }

    public GameEngine(Game game) {
        this.game = game;
    }


    public static void main(String[] args) throws Exception {

        GameEngine gameEngine = new GameEngine();

        try (InputStream consoleInput = System.in; OutputStream consoleOutput = System.out) {
            gameEngine.loop(new StreamInput(consoleInput), new StreamOutput(consoleOutput));
        }

    }

    public void loop(Input input, Output output) {
        output.writeQuestion("Choose your move between paper, scissors, rock or exit:\n");
        String commandToParse = input.read();

        if ("exit".equalsIgnoreCase(commandToParse))
            return;

        step(commandToParse, output);

        loop(input, output);
    }

    private void step(String commandToParse, Output output) {
        commandParser.parse(commandToParse).
                map(move -> game.play(move)).
                map(result -> resultPrinter.print(result)).
                orElse(Optional.of("Invalid command.\n")).
                ifPresent(message -> output.writeResult(message));
    }
}
