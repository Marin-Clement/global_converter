package com.app;

public class BaseConverter {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide a base and a string to convert.");
            return;
        }

        String input = args[1];
        String base = args[0];

        if (!isValidInput(input)) {
            System.out.println("Invalid Characters in input string.");
            return;
        }

        if (!isValidBase(base)) {
            System.out.println("Invalid base.");
            return;
        }

        BaseTranslator translator = createTranslator(base);
        String convertedString = translator.convert(input);
        System.out.println("Converted string: " + convertedString);
    }

    private static boolean isValidInput(String input) {
        return input.matches("[a-zA-Z0-9 ]+");
    }

    private static boolean isValidBase(String base) {
        return base.equals("binary") || base.equals("octal") || base.equals("decimal")
                || base.equals("hexadecimal") || base.equals("text")
                || base.equals("-b") || base.equals("-o") || base.equals("-d")
                || base.equals("-h") || base.equals("-t");
    }

    private static BaseTranslator createTranslator(String base) {
        switch (base) {
            case "binary":
            case "-b":
                return new BinaryTranslator();
            case "octal":
            case "-o":
                return new OctalTranslator();
            case "decimal":
            case "-d":
                return new DecimalTranslator();
            case "hexadecimal":
            case "-h":
                return new HexadecimalTranslator();
            case "text":
            case "-t":
                return new TextTranslator();
            default:
                throw new IllegalArgumentException("Invalid base: " + base);
        }
    }
}
