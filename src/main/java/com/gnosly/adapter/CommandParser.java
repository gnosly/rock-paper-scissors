package com.gnosly.adapter;


import com.gnosly.domain.Game;

public class CommandParser {

    public Game.Move parse(String command) {
        return Game.Move.ROCK;
    }
}
