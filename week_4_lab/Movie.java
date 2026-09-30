package week_4_lab;

public class Movie extends LibraryItem {
    private int duration;

    public Movie(String title, int year, int duration) {
        super(title, year);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return getTitle() + " - " +
                duration + " minutes (" +
                getYear() + ")";
    }
}