package com.jm.lab2.interest;

import java.math.RoundingMode;
import java.math.BigDecimal;

public class Interest {
	private BigDecimal principal;
	private BigDecimal rate;
	private int time;

	// SI = P*R*T / 100;

	// Constructor validates inputs

	public Interest(BigDecimal principal, BigDecimal rate, int time) {

		if (principal.compareTo(BigDecimal.ZERO) >= 0) {

			if (rate.compareTo(BigDecimal.ZERO) >= 0) {

				if (time >= 0) {

					this.principal = principal;
					this.rate = rate;
					this.time = time;
				}
			}
		}
	}

	// Simple Interest using BigDecimal
	// SI = P*R*T /100;

	public BigDecimal calculateSimpleInterest() {
		BigDecimal interest = principal.multiply(rate).multiply(BigDecimal.valueOf(time))
				.divide(BigDecimal.valueOf(100));

		return interest;
	}

	// SimpleInterest Overloaded method
	public double calculateSimpleInterest(double p, double r, int t) {
		double interest = p * r * t / 100;
		return interest;
	}

	// Compound Interest
	// CI = P * (1 + R/100)^T - P
	public BigDecimal calculateCompoundInterest() {
		
		BigDecimal rateDecimal = rate.divide(BigDecimal.valueOf(100));

		BigDecimal growth = BigDecimal.ONE.add(rateDecimal).pow(time);

		BigDecimal interest = principal.multiply(growth).subtract(principal);

		// Round to 2 decimal places
		return interest.setScale(2, RoundingMode.HALF_UP);
	}

	// Compound Interest Overloaded Method
	public double calculateCompoundInterest(double principal, double rate, double time)
	{
		double rateDecimal = rate /100;
		double amount = principal * Math.pow(1 + rateDecimal,  time);
		
		double interest = amount-principal;
		return interest;
	}
}
