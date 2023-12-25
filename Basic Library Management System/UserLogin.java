import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserLogin extends JFrame{

    private JLabel label1;
    private JTextField usernameBox, passwordBox, emailBox;
    private Cursor cursor;
    private JButton exitBtn, registerBtn, loginBtn;

    UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Library Management System");
        setSize(960, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane();
        setLayout(null);

        label1 = new JLabel("User Login");
        label1.setBounds(320, 50, 500, 90);
        label1.setFont(new Font("Arial", Font.BOLD, 40));
        label1.setForeground(Color.BLUE);
        add(label1);

        label1 = new JLabel("Username");
        label1.setBounds(250, 150, 500, 40);
        label1.setFont(new Font("Arial", Font.BOLD, 30));
        add(label1);

        usernameBox = new JTextField();
        usernameBox.setBounds(420, 155, 200, 35);
        usernameBox.setFont(new Font("Arial", Font.PLAIN, 18));
        add(usernameBox);

        label1 = new JLabel("Password");
        label1.setBounds(250, 205, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 30));
        add(label1);

        passwordBox = new JPasswordField();
        passwordBox.setBounds(420, 215, 200, 35);
        passwordBox.setFont(new Font("Arial", Font.PLAIN, 18));
        add(passwordBox);

        label1 = new JLabel("Email");
        label1.setBounds(250, 265, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 30));
        add(label1);

        emailBox = new JTextField();
        emailBox.setBounds(420, 270, 200, 35);
        emailBox.setFont(new Font("Arial", Font.PLAIN, 18));
        add(emailBox);

        label1 = new JLabel("Don't have an account?");
        label1.setBounds(270, 400, 210, 50);
        label1.setFont(new Font("Arial", Font.PLAIN, 20));
        add(label1);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(420, 330, 90, 50);
        loginBtn.setCursor(cursor);
        loginBtn.setFont(new Font("Arial", Font.BOLD, 20));
        loginBtn.setFocusable(false);
        add(loginBtn);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(510, 400, 210, 50);
        registerBtn.setCursor(cursor);
        registerBtn.setFont(new Font("Arial", Font.BOLD, 20));
        registerBtn.setFocusable(false);
        add(registerBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(520, 330, 90, 50);
        exitBtn.setCursor(cursor);
        exitBtn.setFont(new Font("Arial", Font.BOLD, 20));
        exitBtn.setFocusable(false);
        add(exitBtn);

        exitBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        registerBtn.addActionListener(new ActionListener() {
   
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Register frame = new Register();
                frame.setVisible(true);
            }
        });

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = usernameBox.getText().toLowerCase();
                String password = passwordBox.getText();

                if (userName.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try (BufferedReader reader = new BufferedReader(new FileReader("./Data/UserData.txt"))) {
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;

                        for (int i = 0; i < totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(".\\Data\\UserData.txt")).get(i);
                            if (line.equals("Username : " + userName)) {
                                String line2 = Files.readAllLines(Paths.get(".\\Data\\UserData.txt")).get((i + 1));
                                if (line2.equals("Password : " + password)) {

                                }
                            }
                        }
						
						JOptionPane.showMessageDialog(null, "Login Successful.", "Library Management System",
								JOptionPane.WARNING_MESSAGE);

						setVisible(false);
						UserPanel frame = new UserPanel();
						frame.setVisible(true);
						
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        UserLogin frame = new UserLogin();
        frame.setVisible(true);
    }
}
