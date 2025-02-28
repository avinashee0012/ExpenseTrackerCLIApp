
public class ExpenseTrackerCLIApp {
    public static void main(String[] args) throws Exception {
        ExpenseManager em = new ExpenseManager();

        // to take input from user and take actions 


        

        // em.resetApplication();
        // em.addExpense("Travel", "Train", 100);
        // em.addExpense("Food", "Pizza", 700);
        // em.addExpense("Grocery", "Rice", 200);
        em.listAllExpenses();

        // em.summaryOfAllExpenses();

        // em.summaryByMonth(3);

        // em.updateById(3, "Food", "Lunch", 80);

        em.deleteById(1);

        em.listAllExpenses();

        em.saveToJson();
    }
}
