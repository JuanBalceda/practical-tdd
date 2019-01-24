package com.balceda.tdd;

import java.lang.reflect.Array;

public class ValidatorISBN {
    public boolean checkISBN(String isbn) {
        if (isbn.length() < 10){
            throw new NumberFormatException();
        }
        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += isbn.charAt(i) * (10 - i);
        }

        if (total % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
