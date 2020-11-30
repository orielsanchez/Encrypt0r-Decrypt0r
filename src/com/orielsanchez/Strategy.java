package com.orielsanchez;

public interface Strategy {
    String cipher(String data, int key);
    String decipher(String data, int key);
}