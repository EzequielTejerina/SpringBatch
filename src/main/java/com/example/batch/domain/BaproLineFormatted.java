package com.example.batch.domain;

public class BaproLineFormatted {

    private String line;

    public BaproLineFormatted() {}

    public BaproLineFormatted(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return line;
    }
}
