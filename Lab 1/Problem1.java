import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Password: ");
        String password = input.nextLine();

        if (isAcceptablePassword(password)) {
            System.out.println("Acceptable password");
        } else {
            System.out.println("Not acceptable");
        }
        input.close();

    }

    public static boolean isPassLonger8(String a) {
        if (a.length() < 8) {
            return false;
        }
        return true;

    }

    public static boolean hasUppercase(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (Character.isUpperCase(a.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasLowercase(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (Character.isLowerCase(a.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDigit(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (Character.isDigit(a.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAcceptablePassword(String password) {
        if (!isPassLonger8(password) || !hasUppercase(password)
                || !hasLowercase(password) || !hasDigit(password)) {
            return false;
        } else {
            return true;
        }

    }

}
