package com.balceda.tdd;

public class ValidatorISBN {
	private static final int SHORT_ISBN_MULTIPLIER = 10;
	private static final int LONG_ISBN_MULTIPLIER = 11;
	private static final int SHORT_ISBN_LENGTH = 10;
	private static final int LONG_ISBN_LENGTH = 13;

	public boolean checkISBN(String isbn) {
		if (isbn.length() == LONG_ISBN_LENGTH) {
			return isValidLongISBN(isbn);
		} else if (isbn.length() == SHORT_ISBN_LENGTH) {
			return isValidShortISBN(isbn);
		}
		throw new NumberFormatException("ISBN numbers must be 10 or 13 digits long");
	}

	private boolean isValidShortISBN(String isbn) {
		int total = 0;
		for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
			if (!Character.isDigit(isbn.charAt(i))) {
				if (i == 9 && isbn.charAt(i) == 'X') {
					// This is Ok
					total += 10;
				} else {
					throw new NumberFormatException("ISBN numbers must be only numerics digits");
				}
			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i);
			}
		}

		return total % LONG_ISBN_MULTIPLIER == 0;
	}

	private boolean isValidLongISBN(String isbn) {
		int total = 0;
		for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
			if (i % 2 == 0) {
				total += Character.getNumericValue(isbn.charAt(i));
			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * 3;
			}
		}

		return total % SHORT_ISBN_MULTIPLIER == 0;
	}
}
