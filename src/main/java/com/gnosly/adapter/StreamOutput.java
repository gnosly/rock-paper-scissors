package com.gnosly.adapter;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class StreamOutput implements Output {

    private final BufferedWriter bufferedWriter;

    public StreamOutput(OutputStream outputStream) {
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
    }


    @Override
    public void writeQuestion(String message) {
        write(message);
    }

    @Override
    public void writeResult(String message) {
        write(message);
    }

    private void write(String string) {
        try {
            bufferedWriter.write(string);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
