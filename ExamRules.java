import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ExamRules extends JFrame implements ActionListener {

    JTextArea rulesTextArea;
    JButton back;
    Home home;

    public ExamRules(Home home) {
        this.home = home;

        getContentPane().setBackground(new Color(173, 216, 230)); // Light blue

        // Set up the frame
        setTitle("Exam Rules");
        setSize(500, 400);
        setLocationRelativeTo(null);  // Center the frame on the screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);  // Use absolute positioning

        // Create and set up the text area for the rules
        rulesTextArea = new JTextArea();
        rulesTextArea.setText("Exam Instructions:\n\n" +
                "1. There are 15 questions in total.\n" +
                "2. You will have 20 seconds per question.\n" +
                "3. Each correct answer gives you 5 points.\n" +
                "4. Incorrect answers will deduct 1 point.\n" +
                "5. Skipping a question will also deduct 1 point.\n" +
                "6. Once the time is up, the question will be skipped automatically.\n" +
                "7. You can review your score at the end of the quiz.\n\n" +
                "Wish you All the best!\n");

        // Set font and make the text area non-editable
        rulesTextArea.setFont(new Font("Verdana", Font.PLAIN, 16));
        rulesTextArea.setEditable(false);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setWrapStyleWord(true);

        // Set the position and size of the text area
        rulesTextArea.setBounds(20, 20, 450, 260);  // Adjust height for button space
        add(rulesTextArea);

        // Create the "Return" button
        back = new JButton("Return to Home");
        back.setFont(new Font("Verdana", Font.PLAIN, 18));
        back.setBounds(150, 290, 200, 40);  // Adjusted position and size
        back.addActionListener(this);  // Add action listener to handle the button click

        add(back);

        setVisible(true);  // Make the window visible
    }

    public void actionPerformed(ActionEvent e) {
        // When the button is clicked, dispose of this window and show the Home frame
        home.setVisible(true);
        dispose();  // Close the current ExamRules window
    }
}
