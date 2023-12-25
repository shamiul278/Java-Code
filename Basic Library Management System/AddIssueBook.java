import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AddIssueBook extends JFrame {

    private JLabel label1;
    private JTextField bookIdField, bookNameField, CustomerNameField, CustomerEmailField, PeriodField, IssueDateField;
    private JButton Backbtn, AddIssueBook;
    private Cursor cursor;

    public AddIssueBook() {
        //-------------------------------------------Frame Layout------------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library Management System");
        this.setSize(510, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane();
        this.setLayout(null);
        this.setBackground(Color.white);

        // ---------------------------------------------labeling and TextField---------------------------
        //Title
        label1 = new JLabel();
        label1.setText("Enter Information");
        label1.setBounds(100, 10, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 40));
        label1.setForeground(Color.BLUE);
        this.add(label1);

        // BookID
        label1 = new JLabel();
        label1.setText("Book Id");
        label1.setBounds(45, 60, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);

        bookIdField = new JTextField();
        bookIdField.setBounds(185, 68, 260, 30);
        bookIdField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(bookIdField);
  
        // Book Name
        label1 = new JLabel();
        label1.setText("Book Name");
        label1.setBounds(45, 95, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);

        // Book Name Field
        bookNameField = new JTextField();
        bookNameField.setBounds(185, 102, 260, 30);
        bookNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(bookNameField);


        // Customer Name
        label1 = new JLabel();
        label1.setText("Customer Name");
        label1.setBounds(25, 130, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);

        // Customer Name TextField
        CustomerNameField = new JTextField();
        CustomerNameField.setBounds(185, 135, 260, 30);
        CustomerNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(CustomerNameField);

        // Customer Email
        label1 = new JLabel();
        label1.setText("Customer Email");
        label1.setBounds(25, 160, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);

        // Customer Email TextField
        CustomerEmailField = new JTextField();
        CustomerEmailField.setBounds(185, 170, 260, 30);
        CustomerEmailField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(CustomerEmailField);


        // Period
        label1 = new JLabel();
        label1.setText("Period");
        label1.setBounds(45, 195, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);
        
        // Period TextField
        PeriodField = new JTextField();
        PeriodField.setBounds(185, 205, 260, 30);
        PeriodField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(PeriodField);


        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        //-------------------------------------JButtons----------------------------     
        
        //Back Button
        Backbtn = new JButton("Back");
        Backbtn.setBounds(50, 280, 183, 50);
        Backbtn.setFont(new Font("Arial", Font.BOLD, 20));
        Backbtn.setCursor(cursor);
        Backbtn.setFocusable(false);
        this.add(Backbtn);

        //Issue Book Button
        AddIssueBook = new JButton("Add Issue");
        AddIssueBook.setBounds(260, 280, 183, 50);
        AddIssueBook.setFont(new Font("Arial", Font.BOLD, 20));
        AddIssueBook.setCursor(cursor);
        AddIssueBook.setFocusable(false);
        this.add(AddIssueBook);


        //-----------------------------------------------------ActionListener--------------------------------------

        // Back Button
        Backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                IssueBookPanel frame = new IssueBookPanel();
                frame.setVisible(true);
            }
        });

        // Add user Button
        AddIssueBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String BookName = bookNameField.getText(); //BookName
                String BookID = bookIdField.getText(); //BookID
                String CustomerName = CustomerNameField.getText(); //CustomerName
                String CustomerEmail = CustomerEmailField.getText(); //Customer Email
                String Period = PeriodField.getText(); //Period
 

                // Check the Field is not Empty
                if (BookName.isEmpty() || BookID.isEmpty() || CustomerName.isEmpty() || CustomerEmail.isEmpty() || Period.isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                         JOptionPane.WARNING_MESSAGE);
                 } else {

                // Add the Issue Detail in the File
                    try {
                        File file = new File("./Data/IssueBookData.txt");
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
                         pw.println("BookName : " + BookName);
                         pw.println("Customer Name : " + CustomerName);
                         pw.println("Customer Email : " + CustomerEmail);
                         pw.println("Period : " + Period);
                         pw.println("Issue Date : " + timeAndDate);                         
                         pw.println("===============================================");
                         pw.close();

                     } catch (Exception ex) {
                         //System.out.print(ex);
                     }

                     JOptionPane.showMessageDialog(null, "Issue has been added.", "Issue Added",
                             JOptionPane.INFORMATION_MESSAGE);
                     setVisible(false);
                     IssueBookPanel frame = new IssueBookPanel();
                     frame.setVisible(true);
                 }
            
                //Reference to BookPanel
                // update book Quantity
                String bookId = BookID;
                int currentOldQnt = BookPanel.getBookQnt(bookId);
                String newQnt = (currentOldQnt-1) +"";
                BookPanel.updateBookQnt(bookId, newQnt);
            
            }
        });
    }

    public static void main(String[] args) {

        AddIssueBook frame = new AddIssueBook();
        frame.setVisible(true);
    }
}

