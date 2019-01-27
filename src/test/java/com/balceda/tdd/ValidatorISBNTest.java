package com.balceda.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorISBNTest {

	@Test
	public void checkBeValid10ISBN() {
		ValidatorISBN validator = new ValidatorISBN();
		boolean result;
		result = validator.checkISBN("1484233867");
		assertTrue("First result", result);

		result = validator.checkISBN("1788293037");
		assertTrue("Second result", result);
	}

	@Test
	public void checkInvalid10ISBN() {
		ValidatorISBN validator = new ValidatorISBN();
		boolean result = validator.checkISBN("1484933837");
		assertFalse(result);
	}

	@Test
	public void checkBeValid13DigitsISBN() {
		ValidatorISBN validator = new ValidatorISBN();
		boolean result;
		result = validator.checkISBN("9781853260087");
		assertTrue("First result", result);

		result = validator.checkISBN("9781853267338");
		assertTrue("Second result", result);
	}

	@Test
	public void checkInvalid13ISBN() {
		ValidatorISBN validator = new ValidatorISBN();
		boolean result = validator.checkISBN("9781853267339");
		assertFalse(result);
	}

	@Test(expected = NumberFormatException.class)
	public void nineDigitsISBNAreNotAllowed() {
		ValidatorISBN validator = new ValidatorISBN();
		validator.checkISBN("123456789");
	}

	@Test(expected = NumberFormatException.class)
	public void notNumericISBNAreNotAllowed() {
		ValidatorISBN validator = new ValidatorISBN();
		validator.checkISBN("helloworld");
	}

	@Test
	public void tenISBNNumbersEndingInAnXAreValid() {
		ValidatorISBN validator = new ValidatorISBN();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}
}
