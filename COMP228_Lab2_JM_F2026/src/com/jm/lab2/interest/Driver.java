package com.jm.lab2.interest;

import java.math.BigDecimal;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// 5 Interest objects
		Interest[] investment = new Interest[5];

		// Loop 5 times, once for each Interest object in the array
		for (int i = 0; i < investment.length; i++) {

			System.out.println("Object " + (i + 1) + ":");

			// Get input from the user
			// Ask for the principal
			System.out.print("Enter principal (e.g. 5000.00): ");
			BigDecimal principal = scanner.nextBigDecimal();

			// Ask for the interest rate
			System.out.print("Enter rate (e.g. 5.5): ");
			BigDecimal rate = scanner.nextBigDecimal();

			// Ask for the time in whole years
			System.out.print("Enter time in years: ");
			int time = scanner.nextInt();

			// Create the object and calculate
			try {
				investment[i] = new Interest(principal, rate, time);
				System.out.println("Simple Interest: $" + investment[i].calculateSimpleInterest());
				System.out.println("Compound Interest: $" + investment[i].calculateCompoundInterest());
				// Catches Exceptions
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				e.getCause();
				e.getMessage();
			} catch (ArithmeticException e) {
				e.printStackTrace();
				e.getCause();
				e.getMessage();
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
				e.getCause();
				e.getMessage();
			}
		}
		scanner.close();
	}
}