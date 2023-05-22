package com.app;

class OctalTranslator implements BaseTranslator {
    @Override
    public String convert(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            String octal = convertToOctal((int) c);
            result.append(octal);
            result.append(' ');
        }

        return result.toString();
    }

    private String convertToOctal(int value) {
        StringBuilder octal = new StringBuilder();

        while (value > 0) {
            int remainder = value % 8;
            octal.insert(0, remainder);
            value /= 8;
        }

        return octal.toString();
    }
}
