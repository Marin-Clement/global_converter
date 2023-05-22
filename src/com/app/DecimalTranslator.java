package com.app;

class DecimalTranslator implements BaseTranslator {
    @Override
    public String convert(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            String decimal = String.valueOf((int) c);
            result.append(decimal);
            result.append(' ');
        }

        return result.toString();
    }
}