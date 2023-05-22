package com.app;

class OctalTranslator implements BaseTranslator {
    @Override
    public String convert(String input) {
        StringBuilder result = new StringBuilder();
        boolean IsGreen = false;

        for (char c : input.toCharArray()) {
            String octal = convertToOctal((int) c);
            if (!IsGreen) {
                result.append("\033[34m");
                IsGreen = true;
            }
            else {
                result.append("\033[36m");
                IsGreen = false;
            }
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
