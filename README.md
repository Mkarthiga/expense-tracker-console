# Expense Tracker Console Application

A simple Java-based console application for tracking personal expenses with CSV file storage.

## 📋 Overview

This application allows users to manage their personal expenses through a command-line interface. All expense data is stored in a CSV file, making it easy to view and backup your financial records.

## 🚀 Features

- **Add Expenses**: Record new expenses with date, amount, category, and description
- **View All Expenses**: Display all recorded expenses in a formatted table
- **Calculate Total Expenses**: Get the sum of all your expenses
- **Category-wise Summary**: View total expenses filtered by category
- **CSV Storage**: All data is stored in a CSV file for easy data portability

## 🛠️ Technologies Used

- **Java 17**: Core programming language
- **Maven**: Build and dependency management
- **CSV**: File-based data storage

## 📁 Project Structure

```
expense-tracker-console/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── expense/
│   │   │           ├── dao/
│   │   │           │   ├── ExpenseDAO.java              # Data Access Object interface
│   │   │           │   └── ExpenseDAOCSVImpl.java       # CSV implementation of DAO
│   │   │           ├── model/
│   │   │           │   └── ExpensePOJO.java             # Expense data model
│   │   │           └── ui/
│   │   │               ├── ExpenseTracker.java          # Main application class
│   │   │               ├── ConsoleInputReader.java      # User input handler
│   │   │               └── ReportViewer.java            # Display/output handler
│   │   └── resources/
│   │       └── expenses.csv                             # CSV data file
│   └── test/
│       └── java/
│           └── jar/
│               └── AppTest.java                         # Test cases
├── pom.xml                                              # Maven configuration
└── README.md                                            # Project documentation
```

## 🔧 Prerequisites

- **Java 17** or higher
- **Maven 3.6** or higher

## 📦 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd expense-tracker-console
   ```

2. **Compile the project**
   ```bash
   mvn clean compile
   ```

3. **Run the application**
   ```bash
   mvn exec:java -Dexec.mainClass="com.expense.ui.ExpenseTracker"
   ```

   Or alternatively, after compilation:
   ```bash
   java -cp target/classes com.expense.ui.ExpenseTracker
   ```

## 🎮 Usage

Upon running the application, you'll see a menu with the following options:

```
Expense Tracker ConsoleMenu:
1. Add Expense
2. View All Expenses
3. View Total Expenses
4. View Total Expenses by Category
5. Exit
```

### Adding an Expense
1. Select option `1`
2. Enter the expense details:
   - **Date**: Format `YYYY-MM-DD` (e.g., 2025-11-15)
   - **Category**: Any category name (e.g., FOOD, TRAVEL, UTILITIES)
   - **Description**: Brief description of the expense
   - **Amount**: Expense amount as a decimal number

### Viewing Expenses
- **Option 2**: Shows all expenses in a formatted table
- **Option 3**: Displays the total sum of all expenses
- **Option 4**: Shows total expenses for a specific category

## 💾 Data Storage

Expenses are stored in `src/resources/expenses.csv` with the following format:

```csv
Date,Amount,Category,Description
2025-11-15,200.0,FOOD,Dinner in Train
2025-11-15,50.0,TRAVEL,Bus fare
```

## 🧪 Running Tests

Execute the test suite using Maven:

```bash
mvn test
```

## 🏗️ Architecture

The application follows a layered architecture pattern:

- **Model Layer** (`model` package): Contains the `ExpensePOJO` class representing expense data
- **Data Access Layer** (`dao` package): Handles data persistence with CSV file operations
- **User Interface Layer** (`ui` package): Manages user interaction and application flow

### Design Patterns Used

- **Singleton Pattern**: `ExpenseDAOCSVImpl` uses singleton pattern for single instance management
- **DAO Pattern**: Abstracts data access operations through the `ExpenseDAO` interface
- **Factory Pattern**: Static factory method for DAO instance creation

### SOLID Principles Implementation

- **Single Responsibility Principle (SRP)**: 
  - `ExpensePOJO` - Only responsible for expense data modeling
  - `ExpenseDAOCSVImpl` - Only handles CSV data operations
  - `ConsoleInputReader` - Only manages user input collection
  - `ReportViewer` - Only handles data display and formatting

- **Open/Closed Principle (OCP)**: 
  - `ExpenseDAO` interface allows extension for different storage implementations (CSV, Database, etc.) without modifying existing code
  - New expense categories can be added without changing core logic

- **Liskov Substitution Principle (LSP)**: 
  - `ExpenseDAOCSVImpl` can be substituted with any other `ExpenseDAO` implementation without affecting client code

- **Interface Segregation Principle (ISP)**: 
  - `ExpenseDAO` interface is focused and contains only expense-related operations
  - No unnecessary methods that implementing classes would be forced to implement

- **Dependency Inversion Principle (DIP)**: 
  - `ExpenseTracker` depends on the `ExpenseDAO` abstraction rather than concrete implementation
  - High-level modules don't depend on low-level modules; both depend on abstractions

## 🔮 Future Enhancements

- [ ] Database integration (PGSQL)
- [ ] Export functionality (PDF reports)
- [ ] Date range filtering
- [ ] Expense editing and deletion
- [ ] Budget tracking and alerts
- [ ] Graphical user interface (GUI)
- [ ] Multiple currency support
- [ ] Data import/export features

## 👨‍💻 Author

**Karthiga M** - [Mkarthiga](https://github.com/Mkarthiga)

## 📞 Support

If you encounter any issues or have questions, please:
1. Check the [Issues](https://github.com/Mkarthiga/expense-tracker-console/issues) page
2. Create a new issue if your problem isn't already reported
3. Provide detailed information about the issue and steps to reproduce

