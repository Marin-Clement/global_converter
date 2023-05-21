package com.app;

class DecimalTranslator implements BaseTranslator {
    @Override
    public String convert(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            int asciiValue = (int) c;
            String decimal = String.valueOf(asciiValue);
            result.append(decimal);
            result.append(' ');
        }

        return result.toString();
    }
}