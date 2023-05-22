package com.app;

class DecimalTranslator implements BaseTranslator {
    @Override
    public String convert(String input) {
        StringBuilder result = new StringBuilder();
        boolean IsGreen = false;

        for (char c : input.toCharArray()) {
            String decimal = String.valueOf((int) c);
            if (!IsGreen) {
                result.append("\033[34m");
                IsGreen = true;
            }
            else {
                result.append("\033[36m");
                IsGreen = false;
            }
            result.append(decimal);
            result.append(' ');
        }

        return result.toString();
    }
}