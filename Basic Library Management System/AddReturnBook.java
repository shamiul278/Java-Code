import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.time.format.*;


public class AddReturnBook extends JFrame {

    private JLabel label1;
    private JTextField bookIDField, CustomerNameField;
    private JButton Backbtn, AddReturnedBookbtn;
    private Cursor cursor;

    public AddReturnBook() {
        //----------------------------Frame Layout------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library Management System");
        this.setSize(510, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane();
        this.setLayout(null);
        this.setBackground(Color.white);

        //--------------------------------Label and TextField---------------------------

        //Enter Information
        label1 = new JLabel();
        label1.setText("Enter Information");
        label1.setBounds(100, 20, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 40));
        label1.setForeground(Color.BLUE);
        this.add(label1);

      
        //Book ID
        label1 = new JLabel();
        label1.setText("Book ID");
        label1.setBounds(45, 110, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);


        // Book ID Field
        bookIDField = new JTextField();
        bookIDField.setBounds(200, 120, 230, 30);
        bookIDField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(bookIDField);


        // Book Name
        label1 = new JLabel();
        label1.setText("Customer Name");
        label1.setBounds(45, 150, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);
 
        // Book ID Field
        CustomerNameField = new JTextField();
        CustomerNameField.setBounds(200, 160, 230, 30);
        CustomerNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(CustomerNameField);
 
        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        //---------------------------------------Buttons-------------------------------

        //Back Button
        Backbtn = new JButton("Back");
        Backbtn.setBounds(50, 280, 183, 50);
        Backbtn.setFont(new Font("Arial", Font.BOLD, 20));
        Backbtn.setCursor(cursor);
        Backbtn.setFocusable(false);
        this.add(Backbtn);

        //Add Return Button
        AddReturnedBookbtn = new JButton("Add Return");
        AddReturnedBookbtn.setBounds(260, 280, 183, 50);
        AddReturnedBookbtn.setFont(new Font("Arial", Font.BOLD, 20));
        AddReturnedBookbtn.setCursor(cursor);
        AddReturnedBookbtn.setFocusable(false);
        this.add(AddReturnedBookbtn);

        // -----------------------------------------Action Listener---------------------------------
        // Back Button
        Backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                ReturnedBookPanel frame = new ReturnedBookPanel();
                frame.setVisible(true);
            }
        });

        // Add user Button
        AddReturnedBookbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String BookID = bookIDField.getText(); //Book ID
                String CustomerName = CustomerNameField.getText(); //Book ID
               
                // Check the Field is not Empty
                if (BookID.isEmpty() || CustomerName.isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                         JOptionPane.WARNING_MESSAGE);
                 } else {

                // Write the detail in the file
                    try {
                        File file = new File("./Data/ReturnBookData.txt");
                            if (!file.exists()) {
                             file.createNewFile();
                         }
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);
						
						LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
                        String timeAndDate = myDateObj.format(myFormatObj);
						

                        pw.println("BookID : " + BookID);
                        pw.println("Customer Name : " + CustomerName);
                        pw.println("ReturnedDate : " + timeAndDate);                         
                        pw.println("===============================================");
                        pw.close();

                     } catch (Exception ex) {
                         System.out.print(ex);
                     }

                     JOptionPane.showMessageDialog(null, "Returned has been added.", "Book Returned Added",
                             JOptionPane.INFORMATION_MESSAGE);
                     setVisible(false);
                     ReturnedBookPanel frame = new ReturnedBookPanel();
                     frame.setVisible(true);
                 }
            
                //Reference to BookPanel
                // Update Book Quantity
                String bookId = BookID;
                int currentOldQnt = BookPanel.getBookQnt(bookId);
                String newQnt = (currentOldQnt+1) +"";
                BookPanel.updateBookQnt(bookId, newQnt);
             
            }
        });
    }

    public static void main(String[] args) {

        AddReturnBook frame = new AddReturnBook();
        frame.setVisible(true);
    }
}
