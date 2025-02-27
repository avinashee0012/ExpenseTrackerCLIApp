import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExpenseTrackerCLIApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        System.out.println("Testing jackson...");
        ObjectMapper objectMapper = new ObjectMapper();
        Post obj = objectMapper.readValue( new File("src/test.json"), Post.class);

        System.out.println(obj);
        System.out.println("If you see the Object above and this line, everything works fine!");
    }
}
