package com.orielsanchez;

public class ShiftAlgorithm implements Strategy {

    @Override
    public String cipher(String data, int key) {
        StringBuilder result =  new StringBuilder();
        for (char c : data.toCharArray()) {
            if (c != ' ') {
                int originalAlphabetPosition = c - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newChar = (char) ('a' + newAlphabetPosition);
                result.append(newChar);
            } else {
                result.append(c);
            }
        }
        return String.valueOf(result);
    }

    public String decipher(String data, int key) {
        return cipher(data, 26 - (key % 26));
    }
}