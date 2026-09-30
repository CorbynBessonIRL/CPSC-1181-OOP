package week_4_lab;
public class Book extends LibraryItem {
    private String author;

    public Book(String title, int year, String author) {
        super(title, year);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return getTitle() + " by " + author + " (" + getYear() + ")";
    }
}