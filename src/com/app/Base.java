package com.app;

public abstract class Base {
    protected String Convert(String value) {
        return value;
    }

   protected static String CharToBinary(char c) {
        StringBuilder binary = new StringBuilder();
        int value = c;
        for (int i = 0; i < 16; i++) {
            binary.append((value & 32768) == 0 ? '0' : '1');
            value <<= 1;
        }
        return "" + binary;
    }
}