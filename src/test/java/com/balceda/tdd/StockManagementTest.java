package com.balceda.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StockManagementTest {

	@Test
	public void shouldGetACorrectLocatorCode() {
		ExternalISBNDataService testService = isbn -> {
			return new Book(isbn, "Of Mice And Men", "J. Steinbeck");
		};

		StockManager stockManager = new StockManager();
		stockManager.setService(testService);

		String isbn = "0140177396";
		String locatorCode = stockManager.getLocatorCode(isbn);
		assertEquals("7396J4", locatorCode);
	}
}
