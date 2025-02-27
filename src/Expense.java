import java.time.LocalDate;

public class Expense {
    // FIELDS
    private int id;
    private LocalDate date;
    private String category;
    private String description;
    private int amount;

    // CONSTRUCTOR
    public Expense(int id, String category, String description, int amount) {
        this.id = id;
        this.date = LocalDate.now();
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

    // default constructor for jackson
    public Expense() {
    }


    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    // HELPER METHODS
    @Override
    public String toString() {
        StringBuilder dateString = new StringBuilder();
        dateString.append(date.getYear()+"-");
        dateString.append(date.getMonthValue()>9 ? date.getMonthValue()+"-" : "0"+date.getMonthValue()+"-");
        dateString.append(date.getDayOfMonth()>9 ? date.getDayOfMonth() : "0"+date.getDayOfMonth());

        return id + "\t" + dateString + "\t" + category + "\t\t" + description + "\t\t$" + amount;
    }

}
