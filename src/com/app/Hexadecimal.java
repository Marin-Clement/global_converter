package com.app;

public class Hexadecimal extends Base{
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
            // convert each decimal into hexadecimal
            String hexadecimal = "";
            while (decimal > 0) {
                int remainder = decimal % 16;
                if (remainder < 10) {
                    hexadecimal = remainder + hexadecimal;
                } else {
                    hexadecimal = (char) (remainder + 55) + hexadecimal;
                }
                decimal /= 16;
            }
            result += hexadecimal + " ";
        }
        return result;
    }
}
