package com.gnosly.adapter;

import com.gnosly.domain.Result;
import com.gnosly.domain.Tie;
import com.gnosly.domain.Win;

import java.util.Optional;

import static com.gnosly.domain.Game.Player.HUMAN;

public class ResultPrinter {

    public Optional<String> print(Result result) {

        if (result instanceof Tie) {
            Tie tie = (Tie) result;
            return Optional.of("Tie with " + tie.getTieMove() + "\n");
        } else if (result instanceof Win) {
            Win win = (Win) result;
            return Optional.of(HUMAN.equals(win.getWinnerPlayerMove().getPlayer()) ? humanWins(win) : machineWins(win));
        }

        return Optional.empty();
    }

    private String machineWins(Win win) {
        return "Machine wins with " + moveVsMove(win) + "\n";
    }

    private String humanWins(Win win) {
        return "You win with " + moveVsMove(win) + "\n";
    }

    private String moveVsMove(Win win) {
        return win.getWinnerPlayerMove().getMove() + " vs " + win.getLoserPlayerMove().getMove();
    }
}
