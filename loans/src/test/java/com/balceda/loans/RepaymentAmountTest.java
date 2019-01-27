package com.balceda.loans;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.client.RestTemplate;

public class RepaymentAmountTest {

	@Spy
	Loan loan;
	LoanCalculatorController controller;

	@Before
	public void setup() {
		loan = spy(new Loan());
		controller = new LoanCalculatorController();

		LoanRepository repository = mock(LoanRepository.class);
		JavaMailSender mailSender = mock(JavaMailSender.class);
		RestTemplate restTemplate = mock(RestTemplate.class);

		controller.setData(repository);
		controller.setMailSender(mailSender);
		controller.setRestTemplate(restTemplate);
	}

	@Test
	public void aYearLoanWholePounds() {
		loan.setPrincipal(1200);
		loan.setTermInMonths(12);
		doReturn(new BigDecimal(10)).when(loan).getInterestRate();

		controller.processNewLoanApplication(loan);

		assertEquals(new BigDecimal(110), loan.getRepayment());
	}

	@Test
	public void twoYearLoanWholePounds() {
		loan.setPrincipal(1200);
		loan.setTermInMonths(24);
		doReturn(new BigDecimal(10)).when(loan).getInterestRate();

		controller.processNewLoanApplication(loan);

		assertEquals(new BigDecimal(60), loan.getRepayment());
	}

	@Test
	public void fiveYearsLoanWithROunding() {
		loan.setPrincipal(5000);
		loan.setTermInMonths(60);
		doReturn(new BigDecimal(6.5)).when(loan).getInterestRate();

		controller.processNewLoanApplication(loan);

		assertEquals(new BigDecimal(111), loan.getRepayment());
	}
}
