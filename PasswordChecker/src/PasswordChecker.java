import java.util.Scanner;
import java.util.regex.*;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите пароль для проверки: ");
            String password = scanner.nextLine();

            if (isPasswordStrong(password)) {
                System.out.println("Пароль надежный.");
                break;
            } else {
                System.out.println("Пароль не соответствует требованиям.");
                System.out.println("Хотите попробовать другой пароль? (да/нет): ");
                String response = scanner.nextLine();

                if (!response.equalsIgnoreCase("да")) {
                    System.out.println("Выход из программы.");
                    break;
                }
            }
        }

        scanner.close();
    }

    private static boolean isPasswordStrong(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasLowercase = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasUppercase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[!\"#$%&'()*+,-./:;<=>?@[\\\\]^_{|}~]").matcher(password).find();

        return hasLowercase && hasUppercase && hasDigit && hasSpecial;
    }
}
