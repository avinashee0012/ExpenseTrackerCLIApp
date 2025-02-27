
public class ExpenseTrackerCLIApp {
    public static void main(String[] args) throws Exception {
        ExpenseManager em = new ExpenseManager();

        // loading data from json to list
        em.fetchFromJson();

        // 
        em.addExpense("Travel", "Train", 100);
        em.addExpense("Food", "Pizza", 700);
        em.addExpense("Food", "Lunch", 80);

        // list
        em.listAllExpenses();


        // storing to json for persistence of data
        em.saveToJson();
    }
}
