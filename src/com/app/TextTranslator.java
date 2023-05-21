package com.app;

class TextTranslator implements BaseTranslator {
    @Override
    public String convert(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i += 2) {
            String hex = input.substring(i, i + 2);
            int asciiValue = convertToDecimal(hex);
            char character = (char) asciiValue;
            result.append(character);
        }

        return result.toString();
    }

    private int convertToDecimal(String hex) {
        int decimal = 0;

        for (int i = 0; i < hex.length(); i++) {
            int digitValue = getHexDigitValue(hex.charAt(i));
            decimal = decimal * 16 + digitValue;
        }

        return decimal;
    }

    private int getHexDigitValue(char digit) {
        if (digit >= '0' && digit <= '9') {
            return digit - '0';
        } else {
            return digit - 'A' + 10;
        }
    }
}