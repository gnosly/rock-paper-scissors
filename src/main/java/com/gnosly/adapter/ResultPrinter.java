package com.gnosly.adapter;

import com.gnosly.domain.Result;
import com.gnosly.domain.Tie;

import java.util.Optional;

public class ResultPrinter {

    public Optional<String> print(Result result) {

        if (result instanceof Tie) {
            return Optional.of("tie");
        }

        return Optional.empty();
    }
}
