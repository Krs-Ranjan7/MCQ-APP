import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

class Home extends JFrame implements ActionListener {
    // attributes
    JButton stats, practice, suggestive, logout;
    String Name, Branch, RegdNo;
    public int score;

    public Home(String name, String branch, String regdNo) {
        Name = name;
        Branch = branch;
        RegdNo = regdNo;
        
        setSize(400, 300);
        setTitle("Home - " + name);
        setLayout(null);
        // setLocation(450,200);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(173, 216, 230)); // Light blue

        // set buttons
        suggestive = new JButton("Exam rules");
        practice = new JButton("Practice Test");
        stats = new JButton("Know your scores");
        logout = new JButton("Logout");

        suggestive.setBounds(100, 50, 200, 40); // x, y, width, height
        practice.setBounds(100, 100, 200, 40);
        stats.setBounds(100, 150, 200, 40);
        logout.setBounds(100, 200, 200, 40);

        // add action listeners
        suggestive.addActionListener(this);
        practice.addActionListener(this);
        stats.addActionListener(this);
        logout.addActionListener(this);
        
        // Add buttons to the frame
        add(suggestive);
        add(practice);
        add(stats);
        add(logout);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            dispose(); // close the window
            new LoginPage(); // go to login page
        }
        if (e.getSource() == practice) {
            setVisible(false);
            new Question(Name, this, score);
        }
        if (e.getSource() == suggestive) {
            setVisible(false);
            new ExamRules(this);
        }
        if (e.getSource() == stats) {
            setVisible(false);
            new ScorePage(this, score, Name);
        }
    }
}
