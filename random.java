import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Prompt user for password settings
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine();  // Consume leftover newline

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLower = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUpper = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial = scanner.nextLine().equalsIgnoreCase("y");

        // Define character pools
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String special = "!@#$%^&*()-_=+<>?/{}[]";

        // Build the character set based on user choices
        StringBuilder charSet = new StringBuilder();
        if (includeLower) charSet.append(lower);
        if (includeUpper) charSet.append(upper);
        if (includeNumbers) charSet.append(numbers);
        if (includeSpecial) charSet.append(special);

        if (charSet.length() == 0) {
            System.out.println("❌ You must select at least one character type.");
            return;
        }

        // Generate the password
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randIndex = random.nextInt(charSet.length());
            password.append(charSet.charAt(randIndex));
        }

        // Display the password
        System.out.println("🔐 Generated Password: " + password.toString());

        scanner.close();
    }
}
