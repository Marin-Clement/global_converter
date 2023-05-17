package com.app;

public class Octal extends Base {
    @Override
    protected String Convert(String value) {
        Binary binary = new Binary();
        String valueBinary = binary.Convert(value);
        // divide the binary number into 4-bit groups
        String[] groups = valueBinary.split(" ");
        String result = "";
        for (String group : groups) {
            // convert each group into decimal without using Integer.parseInt()
            int decimal = 0;
            for (int i = 0; i < group.length(); i++) {
                decimal += (group.charAt(i) - '0') * Math.pow(2, group.length() - i - 1);
            }
            // convert each decimal into octal
            String octal = "";
            while (decimal > 0) {
                int remainder = decimal % 8;
                octal = remainder + octal;
                decimal /= 8;
            }
            result += octal + " ";
        }
        return result;
    }
}

