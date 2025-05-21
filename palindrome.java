import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeCheckerGUI {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Palindrome Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 1));

        // Create components
        JLabel instructionLabel = new JLabel("Enter a word or phrase:", SwingConstants.CENTER);
        JTextField inputField = new JTextField();
        JButton checkButton = new JButton("Check Palindrome");
        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);

        // Add action listener to the button
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                boolean isPalindrome = true;

                int left = 0;
                int right = cleanedInput.length() - 1;

                while (left < right) {
                    if (cleanedInput.charAt(left) != cleanedInput.charAt(right)) {
                        isPalindrome = false;
                        break;
                    }
                    left++;
                    right--;
                }

                if (isPalindrome) {
                    resultLabel.setText("✅ It's a palindrome!");
                    resultLabel.setForeground(new Color(0, 128, 0)); // Green
                } else {
                    resultLabel.setText("❌ It's not a palindrome.");
                    resultLabel.setForeground(Color.RED);
                }
            }
        });

        // Add components to the frame
        frame.add(instructionLabel);
        frame.add(inputField);
        frame.add(checkButton);
        frame.add(resultLabel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
