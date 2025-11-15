package com.expense.ui;

import java.util.List;

import com.expense.model.ExpensePOJO;

public class ReportViewer {

    public void printAllExpenses(List<ExpensePOJO> expenses) {
    	System.out.println("-----------------------------------------------------------------------------------------------");
    	System.out.println("Sno\tDate \t\t\t Amount \t Category \t Description");
    	System.out.println("-----------------------------------------------------------------------------------------------");
        int sno = 1;
        for (ExpensePOJO e : expenses) {
        	System.out.println(sno + "\t" + e.getDate() + "\t\t" + e.getAmount() + "\t\t" + e.getCategory() + "\t\t" + e.getDescription());
        	sno++;
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public void printTotalExpenses(double total) {
    	System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Total Expenses: " + total);
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public void printTotalExpensesByCategory(String category, double total) {
    	System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Total Expenses for " + category + ": " + total);
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

}
