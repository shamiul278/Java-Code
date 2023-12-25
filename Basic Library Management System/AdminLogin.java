import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class AdminLogin extends JFrame {

    private JLabel label1;
    private JTextField usernamebox;
    private JButton Exitbtn, Loginbtn;
    private JPasswordField passwordbox;
    private Cursor cursor;

    AdminLogin() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library Management System");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.getContentPane();
        this.setLayout(null);
        this.setBackground(Color.WHITE);


        // Title
        label1 = new JLabel();
        label1.setText("Admin Login");
        label1.setBounds(320, 50, 500, 90);
        label1.setFont(new Font("Arial", Font.BOLD,40));
        label1.setForeground(Color.BLUE);
        this.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("Username");
        label1.setBounds(250, 145, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD,30));
        this.add(label1);

        usernamebox = new JTextField();
        usernamebox.setBounds(420, 155, 210, 35);
        usernamebox.setFont(new Font("Arial", Font.PLAIN,18));
        this.add(usernamebox);

        // Password
        label1 = new JLabel();
        label1.setText("Password");
        label1.setBounds(250, 205, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD,30));
        this.add(label1);

        passwordbox = new JPasswordField();
        passwordbox.setBounds(420, 215, 210, 35);
        passwordbox.setFont(new Font("Arial", Font.PLAIN,18));
        this.add(passwordbox);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        //--------------------------------JButtons-------------------------------

        //Exit Button
        Exitbtn = new JButton("Exit");
        Exitbtn.setBounds(230, 300, 150, 50);
        Exitbtn.setCursor(cursor);
        Exitbtn.setFont(new Font("Arial", Font.PLAIN,20));
        Exitbtn.setFocusable(false);
        this.add(Exitbtn);

        //Login Button
        Loginbtn = new JButton("Login");
        Loginbtn.setBounds(490, 300, 150, 50);
        Loginbtn.setCursor(cursor);
        Loginbtn.setFont(new Font("Arial", Font.PLAIN,20));
        Loginbtn.setFocusable(false);
        this.add(Loginbtn);

        //----------------------------------------------ActionListener----------------------

        // Exit Button
        Exitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Login Button
        Loginbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String username = usernamebox.getText().toLowerCase(); // Admin Name
                String password = passwordbox.getText(); // Password
                        
						
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    try {
                        String userNameS = "Username : " + username;
                        String passwordS = "Password : " + password;
                        BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\AdminData.txt"));

                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i <= totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(".\\Data\\AdminData.txt")).get(i);
                            if (line.equals(userNameS)) {
                                String line2 = Files.readAllLines(Paths.get(".\\Data\\AdminData.txt")).get((i + 1));
                                if (line2.equals(passwordS)) {
                                    JOptionPane.showMessageDialog(null, "Admin Login Successful 😊", "Information",
                                            JOptionPane.WARNING_MESSAGE);

                                    setVisible(false);
                                    AdminPanel frame = new AdminPanel();
                                    frame.setVisible(true);
                                    break;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Name or Password!", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {

        AdminLogin frame = new AdminLogin();
        frame.setVisible(true);
    }
}
