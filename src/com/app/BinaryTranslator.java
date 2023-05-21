package com.app;

class BinaryTranslator implements BaseTranslator {
    @Override
    public String convert(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            int asciiValue = (int) c;
            String binary = convertToBinary(asciiValue);
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
