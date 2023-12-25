import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UserPanel extends JFrame{
    
    JButton Books, IssueBookbtn, ReturnBookbtn, Logoutbtn;
    private Cursor cursor;
    ImageIcon BookIcon, IssueIcon, ReturnIcon;

    UserPanel(){
        
	//-------------------------------------------Frame------------------------------------------------

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closing Window
        this.setTitle("Library Management System");   //Window Title
        this.setSize(960, 550); //Window Size
        this.setLocationRelativeTo(null);   //Window Location in screen
        this.setResizable(false);   //Window resideable in screen      
        this.getContentPane(); //Contentpane
        this.setLayout(null); //Layout

    //---------------------------------------------Button---------------------------------------------

    BookIcon = new ImageIcon(getClass().getResource("./image/BooksIcon.png"));
    IssueIcon = new ImageIcon(getClass().getResource("./image/IssueIcon.png"));
    ReturnIcon = new ImageIcon(getClass().getResource("./image/ReturnIcon.png"));
    

    //---------------------------------------------Button---------------------------------------------
        
        //Book Button
        Books = new JButton();
        Books.setText("Books"); // Add Text
        Books.setBounds(100, 100, 200, 200); //Books Button Position
        Books.setFocusable(false); // Set Focusable
        Books.setIcon(BookIcon); //Add Image Icon
        Books.setHorizontalTextPosition(JButton.CENTER);  //Horizontal Text Position
        Books.setVerticalTextPosition(JButton.BOTTOM); //Vertical Text Position
        Books.setCursor(cursor); //Cursor showing on the Login out Button
        Books.setFont(new Font("Arial", Font.BOLD,25));//Font
        this.add(Books);

        //Issue Book Button
        IssueBookbtn = new JButton();
        IssueBookbtn.setText("Issue Book"); // Add Text
        IssueBookbtn.setBounds(370, 100, 200, 200); //Issue Button Position
        IssueBookbtn.setFocusable(false); // Set Focusable
        IssueBookbtn.setIcon(IssueIcon); //Add Image Icon
        IssueBookbtn.setHorizontalTextPosition(JButton.CENTER);  //Horizontal Text Position
        IssueBookbtn.setVerticalTextPosition(JButton.BOTTOM); //Vertical Text Position
        IssueBookbtn.setCursor(cursor); //Cursor showing on the Login out Button
        IssueBookbtn.setFont(new Font("Arial", Font.BOLD,25));//Font
        this.add(IssueBookbtn);

        //Return Book Button
        ReturnBookbtn = new JButton("Return Book");
        ReturnBookbtn.setBounds(650, 100, 200, 200); //Return Button Position
        ReturnBookbtn.setFocusable(false); // Set Focusable
        ReturnBookbtn.setIcon(ReturnIcon); //Add Image Icon
        ReturnBookbtn.setHorizontalTextPosition(JButton.CENTER);  //Horizontal Text Position
        ReturnBookbtn.setVerticalTextPosition(JButton.BOTTOM); //Vertical Text Position
        ReturnBookbtn.setCursor(cursor); //Cursor showing on the Login out Button
        ReturnBookbtn.setFont(new Font("Arial", Font.BOLD,25));//Font
        this.add(ReturnBookbtn); 

        Logoutbtn = new JButton("Log Out"); // Logout Button
        Logoutbtn.setBounds(370, 400, 190, 50); //Login out Button Position
        Logoutbtn.setCursor(cursor); //Cursor showing on the Login out Button
        Logoutbtn.setFont(new Font("Arial", Font.BOLD,20));
        Logoutbtn.setFocusable(false);
        this.add(Logoutbtn); 


        // actions
        Books.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                BookPanel frame = new BookPanel();
                 frame.setVisible(true);

             }
         });

         IssueBookbtn.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {

                 setVisible(false);
                 IssueBookPanel frame = new IssueBookPanel();
                 frame.setVisible(true);

             }
        });
        
         ReturnBookbtn.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                ReturnedBookPanel frame = new ReturnedBookPanel();
                frame.setVisible(true);

             }
        });
        
        
        Logoutbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                UserLogin frame = new UserLogin();
                frame.setVisible(true);

            }
        });

    }

    public static void main(String[] args) {
        // Display UserHome        
        UserPanel frame = new UserPanel();
        frame.setVisible(true);
    }
}