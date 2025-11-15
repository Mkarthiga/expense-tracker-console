package com.expense.dao;

import java.util.List;

public interface ExpenseDAO <T>{
	
		void addExpense(T t);
		
		List<T> viewAllExpenses();
		
		double sumAllExpenses();
		
		double sumExpensesByCategory(String category);
}
