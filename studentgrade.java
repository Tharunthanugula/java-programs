import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for number of grades
        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();

        // Create an array to store the grades
        double[] grades = new double[numGrades];

        // Input each grade
        double sum = 0;
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            sum += grades[i];
        }

        // Calculate average
        double average = sum / numGrades;

        // Display average
        System.out.printf("Average grade: %.2f\n", average);

        scanner.close();
    }
}
