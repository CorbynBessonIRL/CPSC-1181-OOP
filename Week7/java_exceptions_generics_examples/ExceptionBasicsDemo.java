import java.util.Scanner;

public class ExceptionBasicsDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int numerator = input.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = input.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException exception) {
            System.out.println("You cannot divide by zero.");
            System.out.println("Technical message: " + exception.getMessage());
        }
        catch (Exception exception) {
            System.out.println("Something unexpected happened.");
            System.out.println("Technical message: " + exception.getMessage());
        }
        finally {
            System.out.println("This finally block always runs.");
            input.close();
        }

        System.out.println("Program continues after exception handling.");
    }
}
