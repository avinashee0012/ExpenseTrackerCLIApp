
public class ExpenseTrackerCLIApp {
    public static String command;

    public static void main(String[] args) throws Exception {
        ExpenseManager em = new ExpenseManager();

        try {
            command = args[0];
        } catch (Exception e) {
            command = "";
        }

        switch (command) {
            case "add":
                String category = null;
                String description = null;
                int amount = -1;
                int id = -1;
                for (int i = 1; i < args.length; i = i + 2) {
                    switch (args[i]) {
                        case "--category":
                            category = args[i + 1];
                            break;
                        case "--description":
                            description = args[i + 1];
                            break;
                        case "--amount":
                            amount = Integer.parseInt(args[i + 1]);
                            break;
                    }
                }
                em.addExpense(category, description, amount);
                break;
            case "list":
                em.listAllExpenses();
                break;
            case "update":
                category = null;
                description = null;
                amount = -1;
                id = -1;
                for (int i = 1; i < args.length; i = i + 2) {
                    switch (args[i]) {
                        case "--category":
                            category = args[i + 1];
                            break;
                        case "--description":
                            description = args[i + 1];
                            break;
                        case "--amount":
                            amount = Integer.parseInt(args[i + 1]);
                            break;
                        case "--id":
                            id = Integer.parseInt(args[i + 1]);
                            break;
                    }
                }
                em.updateById(id, category, description, amount);
                break;
            case "delete":
                if (args[1].equals("--id")) {
                    em.deleteById(Integer.parseInt(args[2]));
                }
                break;
            case "summary":
                if (args.length == 1) {
                    em.summaryOfAllExpenses();
                } else {
                    if (args[1].equals("--month")) {
                        em.summaryByMonth(Integer.parseInt(args[2]));
                    }
                }
                break;
            case "clear":
                em.resetApplication();
                break;
            default:
                System.out.println("############# Invalid argument!");
                break;
        }

        em.saveToJson();
    }
}
