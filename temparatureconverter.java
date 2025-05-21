import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for temperature value
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        // Prompt user for the unit
        System.out.print("Is the temperature in (C)elsius or (F)ahrenheit? Enter C or F: ");
        char unit = scanner.next().toUpperCase().charAt(0);

        double convertedTemp;
        if (unit == 'C') {
            // Convert Celsius to Fahrenheit
            convertedTemp = (temperature * 9 / 5) + 32;
            System.out.printf("%.2f°C is %.2f°F\n", temperature, convertedTemp);
        } else if (unit == 'F') {
            // Convert Fahrenheit to Celsius
            convertedTemp = (temperature - 32) * 5 / 9;
            System.out.printf("%.2f°F is %.2f°C\n", temperature, convertedTemp);
        } else {
            System.out.println("Invalid unit entered. Please enter 'C' or 'F'.");
        }

        scanner.close();
    }
}
