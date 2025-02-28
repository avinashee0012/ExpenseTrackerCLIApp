# [COMPLETE] Expense Tracker CLI App

A simple command line expense tracker application to manage finances. The application allows users to add, delete, and view their expenses. The application also provides a summary of the expenses.

Project does not use a dependency management tool and hence, is done manually. JAR file includes all dependencies.

### Technologies Used:
1. Java - for programming
2. Git - for versioning
3. GitHub - as remote repository for codebase
4. JSON - for persistence of data
5. jackson-databind library ([link](https://github.com/FasterXML/jackson-databind)) - for json-to-object mapping

### Installation
1. Clone the repo
```bash
git clone git@github.com:avinashee0012/ExpenseTrackerCLIApp.git
cd ExpenseTrackerCLIApp
```
2. Run the jar file
```bash
java -jar ExpenseTrackerCLIApp.jar <command>
```

### Usage Example
```bash
$ java -jar ExpenseTrackerCLIApp.jar add --description "Lunch" --amount 80 --category "Food"
# Expense added successfully (ID: 1)

$ java -jar ExpenseTrackerCLIApp.jar add --amount 200 --category "Travel" --description "Cab"
# Expense added successfully (ID: 2)

$ java -jar ExpenseTrackerCLIApp.jar list
# ID  Date         Category Description  Amount
# 1   2024-08-06   Food     Lunch        ₹80
# 2   2024-09-02   Travel   Cab          ₹200

$ java -jar ExpenseTrackerCLIApp.jar update --id 2 --description "Train" --amount 100
# Expense updated successfully (ID: 2)
  
$ java -jar ExpenseTrackerCLIApp.jar list
# ID  Date         Category Description  Amount
# 1   2024-08-06   Food     Lunch        ₹80
# 2   2023-09-02   Travel   Train        ₹100

$ java -jar ExpenseTrackerCLIApp.jar summary
# Total expenses: ₹180

$ java -jar ExpenseTrackerCLIApp.jar delete --id 1
# Expense deleted successfully (ID: 1)

$ java -jar ExpenseTrackerCLIApp.jar summary
# Total expenses: ₹100

$ java -jar ExpenseTrackerCLIApp.jar summary --month 8
# Total expenses for August: ₹0
```

### Future Releases:
1. More input validations
2. Premium Features:
    - Export as CSV file.
    - Allow users to set a budget for each month and show a warning when the user exceeds the budget.

_____

Project Idea: [roadmap.sh](https://roadmap.sh/projects/expense-tracker) 