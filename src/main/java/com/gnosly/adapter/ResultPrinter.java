package com.gnosly.adapter;

import com.gnosly.domain.Game;
import com.gnosly.domain.Result;
import com.gnosly.domain.Tie;
import com.gnosly.domain.Win;

import java.util.Optional;

public class ResultPrinter {

    public Optional<String> print(Result result) {

        if (result instanceof Tie) {
            return Optional.of("Tie");
        } else if (result instanceof Win) {
            Win win = (Win) result;
            return Optional.of(Game.Player.HUMAN.equals(win.getWinnerPlayerMove().getPlayer()) ? "You win" : "Machine wins");
        }

        return Optional.empty();
    }
}
