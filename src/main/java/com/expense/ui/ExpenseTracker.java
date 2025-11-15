package com.expense.ui;

import java.util.List;
import java.util.Scanner;

import com.expense.dao.ExpenseDAOCSVImpl;
import com.expense.model.ExpensePOJO;

public class ExpenseTracker {
    private ExpenseDAOCSVImpl expenseDAO;
    private ReportViewer reportViewer;
    public static final List<String> CATEGORIES=List.of("FOOD", "TRANSPORT", "BILLS", "SHOPPING", "OTHER");

    public ExpenseTracker() {
    	
        expenseDAO = ExpenseDAOCSVImpl.getInstance();
        reportViewer = new ReportViewer();
    }

    public void addExpense(ExpensePOJO expense) {

        //category validation
        if(!CATEGORIES.contains(expense.getCategory())) {
        	System.out.println(expense.getCategory() + " is an Invalid Category! Expense not added.");
        	return;
        }
        // Amount validation
        if(expense.getAmount() == 0) {
            System.out.println("Minimum amount limit not satisfied!");
        	System.out.println("Amount must be more than zero! Expense not added.");
        	return;
        }
        else if(expense.getAmount() < 0) {
        	System.out.println("Invalid Amount! Expense not added.");
        	return;
        }

        expenseDAO.addExpense(expense);
    }

    public void viewAllExpenses() {
        List<ExpensePOJO> expenses = expenseDAO.viewAllExpenses();
        reportViewer.printAllExpenses(expenses);
    }

    public void viewTotalExpenses() {
        double total = expenseDAO.sumAllExpenses();
        reportViewer.printTotalExpenses(total);
    }

    public void viewTotalExpensesByCategory(String category) {

        System.out.println("Available Categories: " + String.join(", ", CATEGORIES));
        if(!CATEGORIES.contains(category)) {
        	System.out.println(category + " is an Invalid Category!");
        	return;
        }
        double total = expenseDAO.sumExpensesByCategory(category);
        reportViewer.printTotalExpensesByCategory(category, total);
    }

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        boolean exit = false;

        ExpenseTracker tracker = new ExpenseTracker();

        while(!exit) {
            tracker.showMenu();
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    ExpensePOJO expense = ConsoleInputReader.readExpenseDetails("Provide Expense Details", scan);
                    tracker.addExpense(expense);
                    break;
                case 2:
                    tracker.viewAllExpenses();
                    break;
                case 3:
                    tracker.viewTotalExpenses();
                    break;
                case 4:
                    System.out.print("Enter category: ");
                    String category = scan.nextLine();
                    tracker.viewTotalExpensesByCategory(category);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Expense Tracker");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scan.close();

    }

    public void showMenu() {
        System.out.println("Expense Tracker ConsoleMenu:");
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. View Total Expenses");
        System.out.println("4. View Total Expenses by Category");
        System.out.println("5. Exit");
    }

}
