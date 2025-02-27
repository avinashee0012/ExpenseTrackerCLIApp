import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public ExpenseManager() {
        this.list = new ArrayList<>();
        this.jsonFile = new File("resources/expense.json");
        try {
            jsonFile.createNewFile();
            FileWriter writer = new FileWriter("resources/expense.json");
            writer.write("[]");
            writer.close();
        } catch (IOException e) {
            e.getMessage();
        }

        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
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

    }
}
