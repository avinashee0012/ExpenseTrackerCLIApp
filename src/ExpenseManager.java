import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ExpenseManager {
    
    // FIELDS
    private int lastId = 0; // lastId = List[end]
    final List<Expense> list;
    File jsonFile;
    ObjectMapper mapper;

    // CONSTRUCTOR
    public ExpenseManager() throws IOException {
        this.list = new ArrayList<>();
        this.jsonFile = new File("resources/expense.json");
        if(jsonFile.createNewFile()) {
            this.resetApplication();
        }
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        this.fetchFromJson();
        this.lastId = this.list.size();
    }

    // METHODS
    void addExpense(String category, String description, int amount){
        Expense expense = new Expense(++lastId, category, description, amount);
        list.add(expense);
    }

    void listAllExpenses(){
        System.out.println("ID\tDate\t\tCategory\tDescription\tAmount\n----------------------------------------------------------------");
        for (Expense ex : list) {
            System.out.println(ex);
        }
    }

    void saveToJson() throws IOException {
        // Convert list to string for json
        String jsonString = mapper.writeValueAsString(list);
        
        // create FileWriter and write jsonString to file
        FileWriter writer = new FileWriter("resources/expense.json");
        writer.write(jsonString);
        writer.close();
    }

    void fetchFromJson() throws IOException {
        FileReader reader = new FileReader("resources/expense.json");

        // Fetching list of objects from json
        List<Expense> objectsFromJson = mapper.readValue(reader, mapper.getTypeFactory().constructCollectionType(List.class, Expense.class));
        for (Expense expense : objectsFromJson) {
            list.add(expense);
        }
    }

    void summaryOfAllExpenses(){
        int sum = 0;
        for (Expense expense : list) {
            sum += expense.getAmount();
        }
        System.out.println("Total expenses: $" + sum);
    }

    void summaryByMonth(int month){
        int sum = 0;
        String monthName = Month.of(month).toString().substring(0,1).toUpperCase() + Month.of(month).toString().substring(1).toLowerCase();

        for (Expense expense : list) {
            if(expense.getDate().getMonthValue() == month){
                sum += expense.getAmount();
            }
        }
        System.out.println("Total expenses for " + monthName + ": $" + sum);
    }

    int findIndex(int id){
        for (Expense expense : list) {
            if (expense.getId() == id) {
                return list.indexOf(expense);
            }
        }
        return -1;
    }

    void updateById(int id, String category, String description, int amount){
        Expense expense = list.get(this.findIndex(id));
        if (expense != null) {
            expense.setCategory(category);
            expense.setDescription(description);
            expense.setAmount(amount);
            System.out.println("Expense updated successfully (ID: " + id + ")");
        } else {
            System.out.println("Unable to find entry for id= " + id);
        }
    }

    void deleteById(int id){
        int index = this.findIndex(id);
        if (index != -1) {
            list.remove(index);
            System.out.println("Expense deleted successfully (ID: " + id + ")");
        } else {
            System.out.println("Unable to find entry for id= " + id);
        }
    }

    void exportAsCSV(){
        
    }

    void resetApplication() throws IOException{
        FileWriter writer = new FileWriter("resources/expense.json");
        writer.write("[]");
        writer.close();
        list.clear();
    }
}
