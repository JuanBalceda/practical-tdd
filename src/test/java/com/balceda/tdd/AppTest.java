package com.balceda.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void shouldBeValidISBN() {
        ValidatorISBN validator = new ValidatorISBN();
        boolean result;
        result = validator.checkISBN("1484233867");
        assertTrue("First result", result);

        result = validator.checkISBN("1788293037");
        assertTrue("Second result", result);
    }

    @Test
    public void shouldNotBeValidISBN() {
        ValidatorISBN validator = new ValidatorISBN();
        boolean result = validator.checkISBN("1484933837");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitsISBNAreNotAllowed() {
        ValidatorISBN validator = new ValidatorISBN();
        boolean result = validator.checkISBN("123456789");
    }
}
