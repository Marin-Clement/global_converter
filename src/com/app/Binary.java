package com.app;

public class Binary extends Base{
    @Override
    protected String Convert(String value) {
        String result = "";
        for (int i = 0; i < value.length(); i++) {
            result += CharToBinary(value.charAt(i)) + " ";
        }
        return result;
    }
}
