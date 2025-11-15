package com.expense.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.expense.model.ExpensePOJO;

public class ConsoleInputReader {
	
	public static ExpensePOJO readExpenseDetails(String query, Scanner scan)
	{
		System.out.println(query);
		
		ExpensePOJO expense = new ExpensePOJO();
		System.out.println();

		System.out.print("Enter Date (YYYY-MM-DD): ");
		expense.setDate(LocalDate.parse(scan.nextLine()));
		System.out.println();

		List<String> categories=ExpenseTracker.CATEGORIES;
		System.out.println("Available Categories: " + String.join(", ", categories));
		
		System.out.print("Enter Category: ");
		expense.setCategory(scan.nextLine());
		System.out.println();

		System.out.print("Enter Description: ");
		expense.setDescription(scan.nextLine());
		System.out.println();

		System.out.print("Enter Amount: ");
		expense.setAmount(scan.nextDouble());
		scan.nextLine(); 
		System.out.println();
		


		return expense;
	}

}

