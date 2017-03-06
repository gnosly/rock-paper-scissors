package com.gnosly.adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamInput implements Input {

    private final BufferedReader inputReader;

    public StreamInput(InputStream inputStream) {
        this.inputReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public String read() {
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
