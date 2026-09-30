import java.util.Scanner;

public class Problem2 {
    public static void main(String[] arg) {
        String[] words = 
                { "apple", "banana", "apricot", "grape", "avocado", "mango", "berry", "orange" };
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        char key = input.next().charAt(0);

        input.close();
    }
    
}
