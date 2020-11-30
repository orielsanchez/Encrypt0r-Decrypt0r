package com.orielsanchez;

public class Context {
    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy(String data, int key) {
        if (key < 0) {
            return strategy.decipher(data, -key);
        } else {
            return strategy.cipher(data, key);
        }
    }
}