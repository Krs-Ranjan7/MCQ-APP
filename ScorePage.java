import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class ScorePage extends JFrame {

    JLabel scoreLabel, messageLabel;
    JButton backButton;

    public ScorePage(Home home, int score , String name) {
        // Set up the ScorePage frame
        setTitle("Score Page - "+name);
        setSize(400, 300);
        setLocationRelativeTo(null);  // Center the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(173, 216, 230)); // Light blue

        // Display the score
        scoreLabel = new JLabel("Your Score: " + score + "/75");
        scoreLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        scoreLabel.setBounds(120, 50, 200, 40);
        add(scoreLabel);

        // Display a message based on the score
        messageLabel = new JLabel(getMessageBasedOnScore(score)); 
        messageLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        messageLabel.setBounds(120, 100, 200, 40);
        add(messageLabel);

        // Back button to return to the home screen
        backButton = new JButton("Home");
        backButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        backButton.setBounds(120, 170, 160, 40);
        backButton.addActionListener(e -> {
            home.setVisible(true);  // Show the home page
            dispose();  // Close the current score page
        });
        add(backButton);

        setVisible(true);  // Show the frame
    }

    // Method to return a message based on the score
    private String getMessageBasedOnScore(int score) {
        if (score == 75) {
            return "Excellent!";
        } else if (score >= 60) {
            return "Good Job!";
        } else if (score >= 30) {
            return "Keep Practicing!";
        } else {
            return "Try Again!";
        }
    }
}
