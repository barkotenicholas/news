package models.pojos;

public class GeneralNews extends News{

    private final static String DATABASE = "General";
    private String type ;
    private int departmentId;

    public GeneralNews(String content, String author) {
        super(content, author);
        this.type = DATABASE;
    }

    public static String getType() {
        return DATABASE;
    }

    public void setType(String type) {
        this.type = type;
    }
}
