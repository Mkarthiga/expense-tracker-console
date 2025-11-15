package com.expense.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.expense.model.ExpensePOJO;

public class ExpenseDAOCSVImpl implements ExpenseDAO<ExpensePOJO>{
	
	private static ExpenseDAOCSVImpl daoInstance;
	
	private List<ExpensePOJO> expenseList;
	
	private static final String CSV_PATH="src/resources/expenses.csv";
	
	private ExpenseDAOCSVImpl()
	{
		expenseList=loadExpensesFromCSV(CSV_PATH);

	}

	@Override
	public void addExpense(ExpensePOJO t) {
		
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(CSV_PATH, true))) // true flag enables append mode
		{
			StringBuilder sb=new StringBuilder();
			sb.append(t.getDate().toString());
			sb.append(",");
			sb.append(t.getAmount());
			sb.append(",");
			sb.append(t.getCategory());
			sb.append(",");
			sb.append(t.getDescription());
			sb.append("\n");
			
			bw.write(sb.toString());
			expenseList.add(t);

			System.out.println(" Expenses Added Successfully ::\n"+t.toString());
		}
		catch(Exception e)
		{
			
			System.out.println("Error in Expenses addition ::");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ExpensePOJO> viewAllExpenses() {
		
		return new ArrayList<>(expenseList);
	}

	@Override
	public double sumAllExpenses() {

		double sum=0;
		
		for(ExpensePOJO e:expenseList)
		{
			sum+=e.getAmount();
		}
		return sum;
	}

	@Override
	public double sumExpensesByCategory(String category) {
		

		double sum=0;
		
		for(ExpensePOJO e:expenseList)
		{
			if(e.getCategory().equals("Category"))
			{
				sum+=e.getAmount();
			}
		}
		return sum;
				
				
	}
	
	public static ExpenseDAOCSVImpl getInstance()
	{
		if(daoInstance==null)
		{
			daoInstance = new ExpenseDAOCSVImpl();
		}
		
		return daoInstance;
	}
	
	public List<ExpensePOJO> loadExpensesFromCSV(String filePath) {
	    List<ExpensePOJO> expenses = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        boolean headerSkipped = false;

	        while ((line = br.readLine()) != null) {

	            if (!headerSkipped) {  // skip header
	                headerSkipped = true;
	                continue;
	            }

	            String[] fields = line.split(",");

	            ExpensePOJO e = new ExpensePOJO();
	            e.setDate(LocalDate.parse(fields[0]));
	            e.setAmount(Double.parseDouble(fields[1]));
	            e.setCategory(fields[2]);
	            e.setDescription(fields[3]);

	            expenses.add(e);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return expenses;
	}


}
