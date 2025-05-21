import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔐 Password Strength Checker - Cognifyz");
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }

        int strengthScore = 0;
        if (password.length() >= 8) strengthScore++;
        if (hasUpper) strengthScore++;
        if (hasLower) strengthScore++;
        if (hasDigit) strengthScore++;
        if (hasSpecial) strengthScore++;

        System.out.println("\nPassword Analysis:");
        System.out.println("- Length: " + password.length());
        System.out.println("- Contains uppercase: " + hasUpper);
        System.out.println("- Contains lowercase: " + hasLower);
        System.out.println("- Contains digits: " + hasDigit);
        System.out.println("- Contains special characters: " + hasSpecial);

        // Final feedback
        System.out.print("\nStrength: ");
        switch (strengthScore) {
            case 5 -> System.out.println("💪 Very Strong");
            case 4 -> System.out.println("👍 Strong");
            case 3 -> System.out.println("👌 Moderate");
            case 2 -> System.out.println("😐 Weak");
            default -> System.out.println("⚠️ Very Weak");
        }

        scanner.close();
    }
}
