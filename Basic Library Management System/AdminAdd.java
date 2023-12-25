import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class AdminAdd extends JFrame {

    // Variable
    private JLabel label1;
    private JTextField usernamebox, emailbox;
    private JButton Backbtn, AddUser;
    private JPasswordField passwordbox;
    private Cursor cursor;

    AdminAdd() {
        //----------------------------Frame Layout------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library Management System");
        this.setSize(510, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane();
        this.setLayout(null);
        this.setBackground(Color.white);

        // --------------------------------Label and Text Field-----------------------------

        // Enter Information
        label1 = new JLabel();
        label1.setText("Enter Information");
        label1.setBounds(100, 20, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 40));
        label1.setForeground(Color.BLUE);
        this.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("User Name");
        label1.setBounds(45, 75, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);

        // User Name TextField
        usernamebox = new JTextField();
        usernamebox.setBounds(185, 85, 260, 30);
        usernamebox.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(usernamebox);

        // Email TextField
        label1 = new JLabel();
        label1.setText("Email");
        label1.setBounds(45, 110, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);

        // Email TextField
        emailbox = new JTextField();
        emailbox.setBounds(185, 120, 260, 30);
        emailbox.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(emailbox);

        // Password
        label1 = new JLabel();
        label1.setText("Password");
        label1.setBounds(45, 145, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);

        // Email TextField
        passwordbox = new JPasswordField();
        passwordbox.setBounds(185, 155, 260, 30);
        passwordbox.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(passwordbox);


        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        //-----------------------------------------Buttons------------------------------------

        //Back Button
        Backbtn = new JButton("Back");
        Backbtn.setBounds(50, 280, 183, 50);
        Backbtn.setFont(new Font("Arial", Font.BOLD, 20));
        Backbtn.setCursor(cursor);
        Backbtn.setFocusable(false);
        this.add(Backbtn);

        //Add User Button
        AddUser = new JButton("Add User");
        AddUser.setBounds(260, 280, 183, 50);
        AddUser.setFont(new Font("Arial", Font.BOLD, 20));
        AddUser.setCursor(cursor);
        AddUser.setFocusable(false);
        this.add(AddUser);

        //-------------------------------------------ActionListener-----------------------------------
        // Back Button
        Backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                AdminLogin frame = new AdminLogin();
                frame.setVisible(true);
            }
        });

        // Add user Button
        AddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String username = usernamebox.getText().toLowerCase(); //username
                String password = passwordbox.getText(); //password
                String email = emailbox.getText(); //email



                if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    try {
                        File file = new File("./Data/UserData.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                        String timeAndDate = myDateObj.format(myFormatObj);

                        pw.println("## Added by Admin ##");
                        pw.println("Username : " + username);
                        pw.println("Password : " + password);
                        pw.println("Email : " + email);
                        pw.println("Time & Date : " + timeAndDate);
                        pw.println("===============================================");
                        pw.close();

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                    JOptionPane.showMessageDialog(null, "User has been added.", "User Added",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    AdminPanel frame = new AdminPanel();
                    frame.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {

        AdminAdd frame = new AdminAdd();
        frame.setVisible(true);
    }
}
