import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class AddBook extends JFrame {

    private JLabel label1;
    private JTextField bookIdField, bookNameField, bookAuthorField, bookGenreField, bookQntField;
    private JButton Backbtn, AddBook;
    private Cursor cursor;

    public AddBook() {
        //----------------------------------------------------Frame Layout------------------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library Management System");
        this.setSize(510, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane();
        this.setLayout(null);
        this.setBackground(Color.white);

        //----------------------------------------------------Labeling and Text Field---------------------------
        // Title
        label1 = new JLabel();
        label1.setText("Enter Information");
        label1.setBounds(100, 20, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 40));
        label1.setForeground(Color.BLUE);
        this.add(label1);

        // Book ID
        label1 = new JLabel();
        label1.setText("Book ID");
        label1.setBounds(45, 75, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);

        // Book ID TextField
        bookIdField = new JTextField();
        bookIdField.setBounds(185, 85, 260, 30);
        bookIdField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(bookIdField);

       
        // Book Name
        label1 = new JLabel();
        label1.setText("Book Name");
        label1.setBounds(45, 110, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);
        
        // Book Name TextField
        bookNameField = new JTextField();
        bookNameField.setBounds(185, 120, 260, 30);
        bookNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(bookNameField);


        // Book Author
        label1 = new JLabel();
        label1.setText("Author");
        label1.setBounds(45, 145, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);

        // Book Author TextField
        bookAuthorField = new JTextField();
        bookAuthorField.setBounds(185, 155, 260, 30);
        bookAuthorField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(bookAuthorField);


        // BookGenre
        label1 = new JLabel();
        label1.setText("Genre");
        label1.setBounds(45, 180, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);

        // Book Genre TextField
        bookGenreField = new JTextField();
        bookGenreField.setBounds(185, 190, 260, 30);
        bookGenreField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(bookGenreField);

        
        // Book Quantity
        label1 = new JLabel();
        label1.setText("Quantity");
        label1.setBounds(45, 220, 500, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label1);

        // Book Quantity TextField
        bookQntField = new JTextField();
        bookQntField.setBounds(185, 230, 260, 30);
        bookQntField.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(bookQntField);


        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        //---------------------------------------------JButtons-------------------------------
        
        //Back Button
        Backbtn = new JButton("Back");
        Backbtn.setBounds(50, 280, 183, 50);
        Backbtn.setFont(new Font("Arial", Font.BOLD, 20));
        Backbtn.setCursor(cursor);
        Backbtn.setFocusable(false);
        this.add(Backbtn);

        //Add Book Button
        AddBook = new JButton("Add Book");
        AddBook.setBounds(260, 280, 183, 50);
        AddBook.setFont(new Font("Arial", Font.BOLD, 20));
        AddBook.setCursor(cursor);
        AddBook.setFocusable(false);
        this.add(AddBook);

        //-------------------------------------------------ActionListener------------------------

        // Back Button
        Backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                BookPanel frame = new BookPanel();
                frame.setVisible(true);
            }
        });

        // Add user Button
        AddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String BookID = bookIdField.getText(); //BookID
                String BookName = bookNameField.getText(); //BookName
                String Author = bookAuthorField.getText(); //Author
                String Genre = bookGenreField.getText(); //Genre
                String Quantity = bookQntField.getText(); // Quantity

                //Covert String to Integar
                try{
                  Integer.parseInt(Quantity);
                  
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Quantity should not be text.", "Warning",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                // Check the TextField is Empty or not
                if (BookID.isEmpty() || BookName.isEmpty() || Author.isEmpty() || Genre.isEmpty() || Quantity.isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                         JOptionPane.WARNING_MESSAGE);
                     

                 } else {
                    // Write the Detail in file
                    try {
                        File file = new File("./Data/BookData.txt");
                            if (!file.exists()) {
                             file.createNewFile();
                         }
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                         pw.println("BookID : " + BookID);
                         pw.println("BookName : " + BookName);
                         pw.println("Author : " + Author);
                         pw.println("Genre : " + Genre);
                         pw.println("Quantity : " + Quantity);                         
                         pw.println("===============================================");
                         pw.close();

                     } catch (Exception ex) {
                         System.out.print(ex);
                     }

                     JOptionPane.showMessageDialog(null, "Book has been added.", "Book Added",
                             JOptionPane.INFORMATION_MESSAGE);
                     setVisible(false);
                     BookPanel frame = new BookPanel();
                     frame.setVisible(true);
                 }
            }
        });
    }

    public static void main(String[] args) {

        AddBook frame = new AddBook();
        frame.setVisible(true);
    }
}
