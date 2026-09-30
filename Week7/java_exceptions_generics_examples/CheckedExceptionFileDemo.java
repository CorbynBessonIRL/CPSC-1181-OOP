import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedExceptionFileDemo {
    public static void main(String[] args) {
        try {
            int total = totalNumbersInFile("numbers.txt");
            System.out.println("Total: " + total);
        }
        catch (FileNotFoundException exception) {
            System.out.println("Could not find the file.");
            System.out.println("Create a file named numbers.txt in this folder and try again.");
        }
    }

    public static int totalNumbersInFile(String filename) throws FileNotFoundException {
        int total = 0;

        File file = new File(filename);

        try (Scanner fileInput = new Scanner(file)) {
            while (fileInput.hasNextInt()) {
                int number = fileInput.nextInt();
                total = total + number;
            }
        }

        return total;
    }
}
