import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Post {
    public int userId;
    public int id;
    public String title;

    @Override
    public String toString() {
        return "Post [userId=" + userId + ", id=" + id + ", title=" + title + "]";
    }
}
