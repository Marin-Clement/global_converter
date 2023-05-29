package com.app;

class TextTranslator implements BaseTranslator {
    @Override
    public String convert(String input) {
        return switch (detectNumberType(input)) {
            case "binary" -> binaryToText(input);
            case "decimal" -> decimalToText(input);
            case "octal" -> octalToText(input);
            case "hexadecimal" -> hexadecimalToText(input);
            default -> "Invalid input provided.";
        };
    }

    // Check if string is either binary, decimal, octal, or hexadecimal
     public static String detectNumberType(String input) {
        String numberType = "unknown";

        // Check if the string is binary
        if (input.matches("[01 ]+")) {
            numberType = "binary";
        }

        // Check if the string is decimal
        else if (input.matches("[0-9 ]+")) {
            numberType = "decimal";
        }

        // Check if the string is octal
        else if (input.matches("[0-7 ]+")) {
            numberType = "octal";
        }

        // Check if the string is hexadecimal
        else if (input.matches("[0-9A-Fa-f ]+")) {
            numberType = "hexadecimal";
        }

        return numberType;
    }

    private static String binaryToText(String binary) {
        StringBuilder text = new StringBuilder();
        String[] binaryBytes = binary.split(" ");
        for (String byteString : binaryBytes) {
            int decimal = 0;
            int power = 7;
            for (int i = 0; i < byteString.length(); i++) {
                char bit = byteString.charAt(i);
                if (bit == '1') {
                    decimal += Math.pow(2, power);
                }
                power--;
            }
            char character = (char) decimal;
            text.append(character);
        }
        return text.toString();
    }

    private static String decimalToText(String decimalString) {
        StringBuilder text = new StringBuilder();
        String[] decimalArray = decimalString.split(" ");
        for (String decimal : decimalArray) {
            try {
                long decimalValue = Long.parseLong(decimal);
                char character = (char) decimalValue;
                text.append(character);
            } catch (NumberFormatException e) {
                System.out.println("Invalid decimal number provided: " + decimal);
            }
        }
        return text.toString();
    }

    private static String octalToText(String octal) {
        StringBuilder text = new StringBuilder();
        String[] octalBytes = octal.split(" ");
        for (String byteString : octalBytes) {
            int decimal = 0;
            int power = 2;
            for (int i = 0; i < byteString.length(); i++) {
                char bit = byteString.charAt(i);
                int bitValue = Character.getNumericValue(bit);
                decimal += bitValue * Math.pow(8, power);
                power--;
            }
            char character = (char) decimal;
            text.append(character);
        }
        return text.toString();
    }


    private static String hexadecimalToText(String hexadecimal) {
        StringBuilder text = new StringBuilder();
        String[] hexadecimalBytes = hexadecimal.split(" ");
        for (String byteString : hexadecimalBytes) {
            int decimal = 0;
            int power = 1;
            for (int i = 0; i < byteString.length(); i++) {
                char bit = byteString.charAt(i);
                int bitValue = Character.getNumericValue(bit);
                decimal += bitValue * Math.pow(16, power);
                power--;
            }
            char character = (char) decimal;
            text.append(character);
        }
        return text.toString();
    }
}