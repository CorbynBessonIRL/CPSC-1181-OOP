package week_4_lab;

import java.util.ArrayList;

public class LibraryDriver {
    public static void main(String[] args) {
        ArrayList<LibraryItem> items = new ArrayList<>();

        items.add(new Book("Java Basics", 2020, "Smith"));
        items.add(new Book("Data Structures", 2021, "Brown"));

        items.add(new Movie("Inception", 2010, 148));
        items.add(new Movie("Interstellar", 2014, 169));

        for (LibraryItem item : items) {
            System.out.println(item.getDescription());
        }
    }
}
