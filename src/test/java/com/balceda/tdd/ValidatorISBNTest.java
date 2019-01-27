package com.balceda.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class ValidatorISBNTest {

	ValidatorISBN validator;

	@Before
	public void setup() {
		validator = new ValidatorISBN();
	}

	@Test
	public void checkBeValid10ISBN() {
		assertTrue("First result", validator.checkISBN("1484233867"));

		assertTrue("Second result", validator.checkISBN("1788293037"));
	}

	@Test
	public void checkInvalid10ISBN() {
		assertFalse(validator.checkISBN("1484933837"));
	}

	@Test
	public void checkBeValid13DigitsISBN() {
		assertTrue("First result", validator.checkISBN("9781853260087"));

		assertTrue("Second result", validator.checkISBN("9781853267338"));
	}

	@Test
	public void checkInvalid13ISBN() {
		assertFalse(validator.checkISBN("9781853267339"));
	}

	@Test(expected = NumberFormatException.class)
	public void nineDigitsISBNAreNotAllowed() {
		validator.checkISBN("123456789");
	}

	@Test(expected = NumberFormatException.class)
	public void notNumericISBNAreNotAllowed() {
		validator.checkISBN("helloworld");
	}

	@Test
	public void tenISBNNumbersEndingInAnXAreValid() {
		assertTrue(validator.checkISBN("012000030X"));
	}
}
