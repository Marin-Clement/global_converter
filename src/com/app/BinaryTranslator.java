package com.app;

class BinaryTranslator implements BaseTranslator {
    @Override
    public String convert(String input) {
        StringBuilder result = new StringBuilder();
        boolean IsGreen = false;

        for (char c : input.toCharArray()) {
            String binary = convertToBinary((int) c);
            if (!IsGreen) {
                result.append("\033[34m");
                IsGreen = true;
            }
            else {
                result.append("\033[36m");
                IsGreen = false;
            }
            result.append(binary);
            result.append(' ');
        }

        return result.toString();
    }

    private String convertToBinary(int value) {
        StringBuilder binary = new StringBuilder();

        while (value > 0) {
            int remainder = value % 2;
            binary.insert(0, remainder);
            value /= 2;
        }

        // Padding with leading zeros to ensure 8-bit representation
        while (binary.length() < 8) {
            binary.insert(0, '0');
        }

        return binary.toString();
    }
}
