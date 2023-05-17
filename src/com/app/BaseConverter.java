package com.app;

import java.util.Objects;

public class BaseConverter {

    public static void main(String[] args) {
        // Check if valid input
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (args.length != 2 && !Objects.equals(args[0], "help") && !Objects.equals(args[0], "-H")) {
            System.out.println("Error: Expected 2 arguments, got " + args.length);
            System.out.println("Make to arguments are in the form: <base> <value>");
            return;
        }
        // Check if valid base
        switch (args[0]) {
            case "binary", "-b" -> {
                System.out.println("Base chosen: Binary");
                System.out.println(new Binary().Convert(args[1]));
            }
            case "octal", "-o" -> {
                System.out.println("Base chosen: Octal");
                System.out.println(new Octal().Convert(args[1]));
            }
            case "decimal", "-d" -> {
                System.out.println("Base chosen: Decimal");
                System.out.println(new Decimal().Convert(args[1]));
            }
            case "hexadecimal", "-h" -> {
                System.out.println("Base chosen: Hexadecimal");
                System.out.println(new Hexadecimal().Convert(args[1]));
            }
            case "text", "-t" -> {
                System.out.println("Base chosen: Text");
                System.out.println(new Text().Convert(args[1]));
            }
            case "help", "-H" -> {
                System.out.println("-b, binary: Convert to binary");
                System.out.println("-o, octal: Convert to octal");
                System.out.println("-d, decimal: Convert to decimal");
                System.out.println("-h, hexadecimal: Convert to hexadecimal");
                System.out.println("-t, text: Convert to text");
                System.out.println("--h, help: Show help\n");
                System.out.println("Usage: java -jar BaseConverter.jar <base> <value>");
                System.out.println("Example: java -jar BaseConverter.jar -b 1010");
            }
            default -> {
                System.out.println("Invalid base: " + args[0]);
                System.out.println("Valid bases: binary, octal, decimal, hexadecimal, text");
            }
        }
    }
}

