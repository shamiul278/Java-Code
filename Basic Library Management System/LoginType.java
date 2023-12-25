import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginType extends JFrame implements ActionListener {
    JButton Admin_Login_Page, User_Login_Page;
    private Cursor cursor;
    JLabel TitleLb;

    LoginType() {
        //-------------------------------------------Frame-------------------------------------------------

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Closing Window
        setTitle("Basic Library Management System"); //Window Title
        setSize(560, 350); //Window Size
        setLocationRelativeTo(null); //Window Location in screen
        setResizable(false);  //Window resideable in screen
        getContentPane().setLayout(null); //Contentpane

        cursor = new Cursor(Cursor.HAND_CURSOR);
        //--------------------------------------Button-----------------------------------------------------

        TitleLb = new JLabel("Choose the Type");
        TitleLb.setBounds(90, 50, 1000, 90);
        TitleLb.setFont(new Font("Arial", Font.BOLD,50));
        this.add(TitleLb); //add to the Frame

        Admin_Login_Page = new JButton("Admin Login");
        Admin_Login_Page.setBounds(120, 150, 154, 50);
        Admin_Login_Page.setCursor(cursor);
        Admin_Login_Page.setFont(new Font("Arial", Font.BOLD, 20));
        Admin_Login_Page.setFocusable(false);
        Admin_Login_Page.addActionListener(this); 
        add(Admin_Login_Page);

        User_Login_Page = new JButton("User Login");
        User_Login_Page.setBounds(305, 150, 150, 50);
        User_Login_Page.setCursor(cursor);
        User_Login_Page.setFont(new Font("Arial", Font.BOLD, 20));
        User_Login_Page.setFocusable(false);
        User_Login_Page.addActionListener(this);
        add(User_Login_Page);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Admin_Login_Page){
            setVisible(false);
            AdminLogin frame = new AdminLogin();
            frame.setVisible(true);
            JOptionPane.showMessageDialog(null, "By default \nUsername : admin \nPassword : admin", "Default Message",JOptionPane.WARNING_MESSAGE);
        }
        if(e.getSource() == User_Login_Page){
            setVisible(false);
            UserLogin frame = new UserLogin();
            frame.setVisible(true);
        }


    }

    public static void main(String[] args) {
            LoginType frame = new LoginType();
            frame.setVisible(true);
    }
}
