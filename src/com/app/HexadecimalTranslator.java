package com.app;

class HexadecimalTranslator implements BaseTranslator {
    @Override
    public String convert(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            String hexadecimal = convertToHexadecimal((int) c);
            result.append(hexadecimal);
            result.append(' ');
        }

        return result.toString();
    }

    private String convertToHexadecimal(int value) {
        StringBuilder hexadecimal = new StringBuilder();

        while (value > 0) {
            int remainder = value % 16;
            hexadecimal.insert(0, getHexDigit(remainder));
            value /= 16;
        }

        return hexadecimal.toString();
    }

    private char getHexDigit(int value) {
        if (value >= 0 && value <= 9) {
            return (char) ('0' + value);
        } else {
            return (char) ('A' + (value - 10));
        }
    }
}
