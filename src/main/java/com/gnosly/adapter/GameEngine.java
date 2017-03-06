package com.gnosly.adapter;

import com.gnosly.domain.Game;
import com.gnosly.domain.RandomMoveSelection;

import java.util.Optional;
import java.util.logging.Logger;

public class GameEngine {

    private final static Logger logger = Logger.getLogger(GameEngine.class.getName());

    private final Game game;
    private final CommandParser commandParser = new CommandParser();
    private final ResultPrinter resultPrinter = new ResultPrinter();

    public GameEngine() {
        game = new Game(new RandomMoveSelection());
    }

    public GameEngine(Game game) {
        this.game = game;
    }


    public static void main(Object[] args) throws Exception {

        GameEngine gameEngine = new GameEngine();

//        try (BufferedReader buffer = new BufferedReader()) {
//            Optional<String> commandOutput;
//            while ((commandOutput = gameEngine.step(buffer.readLine())).isPresent()) {
//                logger.info(commandOutput.get());
//            }
//        }

    }

    public void loop(Input input, Output output) {
        String commandToParse = input.read();

        if ("exit".equalsIgnoreCase(commandToParse))
            return;

        step(commandToParse, output);

        loop(input, output);
    }

    public void step(String commandToParse, Output output) {
        commandParser.parse(commandToParse).
                map(move -> game.play(move)).
                map(result -> resultPrinter.print(result)).
                orElse(Optional.of("Invalid command.\n")).
                ifPresent(message -> output.write(message));
    }
}
