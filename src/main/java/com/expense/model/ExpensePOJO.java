package com.expense.model;

import java.time.LocalDate;

public class ExpensePOJO {
	
	private LocalDate date;
	
	private String category;
	
	private String description;
	
	private double amount;
	
	

	public ExpensePOJO() {
		
	}

	public ExpensePOJO(LocalDate date, String category, String description, double amount) {
		this.date = date;
		this.category = category;
		this.description = description;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Expense  [date=" + date + ", category=" + category + ", description=" + description + ", amount="
				+ amount + "]";
	}
	
	
	

	
	

}
