import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Register extends JFrame implements ActionListener {

    private JLabel label1;
    private JTextField Usernamebox, Passwordbox, Emailbox;
    private Cursor cursor;
    private JButton RegisterBtn, BackBtn;


        Register(){

            //-------------------------------------------Frame-------------------------------------------------

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closing Window
            this.setTitle("Library Management System");   //Window Title
            this.setSize(960, 550); //Window Size
            this.setLocationRelativeTo(null);   //Window Location in screen
            this.setResizable(false);   //Window resideable in screen      
            this.getContentPane();  //Contentpane
            this.setLayout(null); //Layout


            //---------------------------------------------Labeling and TextField on the window-------------------------------
            
            label1 = new JLabel("Registration");
            label1.setBounds(350, 50, 1000, 50);
            label1.setFont(new Font("Arial", Font.BOLD,50));
            label1.setForeground(Color.BLUE);
            this.add(label1); //add to the Frame

            
            label1 = new JLabel("Username"); //Labeling Username
            label1.setBounds(250, 150, 500, 40); //Username Position
            label1.setFont(new Font("Arial", Font.BOLD,30)); //Username Font
            this.add(label1); //add to the Frame

            Usernamebox = new JTextField();
            Usernamebox.setBounds(420, 155, 200, 35);
            Usernamebox.setFont(new Font("Arial", Font.PLAIN,18));
            this.add(Usernamebox); //add to the Frame

            label1 = new JLabel("Password");

            label1.setBounds(250, 205, 500, 50);
            label1.setFont(new Font("Arial", Font.BOLD,30));
            this.add(label1); //add to the Frame

            Passwordbox = new JPasswordField(); //Password Text Box
            Passwordbox.setBounds(420, 215, 200, 35); //Position
            Passwordbox.setFont(new Font("Arial", Font.PLAIN,18));
            this.add(Passwordbox); //add to the Frame
			
			label1 = new JLabel("Email"); //Email Label
            label1.setBounds(250, 265, 500, 50); // position
            label1.setFont(new Font("Arial", Font.BOLD,30)); // Font
            this.add(label1); //add to the Frame

            Emailbox = new JTextField(); //Email Text Box
            Emailbox.setBounds(420, 270, 200, 35); //Position
            Emailbox.setFont(new Font("Arial", Font.PLAIN,18));
            this.add(Emailbox); //add to the Frame


            cursor = new Cursor(Cursor.HAND_CURSOR); //Cursor Effect
            
            //---------------------------------------------Button---------------------------------------------          
           
            BackBtn = new JButton("Back"); // Register Button 
            BackBtn.setBounds(250, 350, 210, 50); //Register Button Position
            BackBtn.setCursor(cursor); //Cursor in the Register Button
            BackBtn.setFont(new Font("Arial", Font.BOLD,20)); //Font
            BackBtn.setFocusable(false); //set focusable
            BackBtn.addActionListener(this); //add to actionlistener
            this.add(BackBtn); //add to the Frame

            RegisterBtn = new JButton("Register"); // Register Button 
            RegisterBtn.setBounds(550, 350, 210, 50); //Register Button Position
            RegisterBtn.setCursor(cursor); //Cursor in the Register Button
            RegisterBtn.setFont(new Font("Arial", Font.BOLD,20)); //Font
            RegisterBtn.setFocusable(false); //set focusable
            RegisterBtn.addActionListener(this); //add to actionlistener
            this.add(RegisterBtn); //add to the Frame

        }

        //------------------------------ActionListener---------------------------------
  @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == BackBtn){
            setVisible(false);
            UserLogin frame = new UserLogin();
            frame.setVisible(true);

        }
        if (e.getSource() == RegisterBtn) {
            String username = Usernamebox.getText().toLowerCase();
            String password = Passwordbox.getText();
            String email = Emailbox.getText();

            if (username.trim().isEmpty() || password.trim().isEmpty() || email.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill up the Username and Password",
                        "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                File file = new File(".\\Data\\UserData.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                String timeAndDate = myDateObj.format(myFormatObj);

                pw.println("Username : " + username);
                pw.println("Password : " + password);
                pw.println("Email : " + email);
                pw.println("Time & Date : " + timeAndDate);
                pw.println("===============================================");
                pw.close();
            
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        
        JOptionPane.showMessageDialog(null, "Registration Successfully Completed.😊",
        "Registration Complete", JOptionPane.WARNING_MESSAGE);
        setVisible(false);
        UserLogin frame = new UserLogin();
        frame.setVisible(true);
    }
}

    public static void main(String[] args) {
        Register register = new Register();
        register.setVisible(true);
    }
}