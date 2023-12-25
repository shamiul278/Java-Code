import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.nio.file.*;


public class BookPanel extends JFrame {

    private Container c;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton Refreshbtn, Deletebtn, AddBook,  Exitbtn, BackBtn;
    private Cursor cursor;

    private String[] column = { "Book Id", "Book Name", "Author", "Genre", "Quantity" };
    private String[] rows = new String[5];

    public BookPanel() {
        //----------------------------------Frame Layout----------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library Management System");
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("Book Data");
        label1.setBounds(200, 10, 400, 80);
        label1.setFont(f1);
        c.add(label1);

        //--------------------------------------JButtons-----------------------------------
        Refreshbtn = new JButton("Refresh");
        Refreshbtn.setBounds(54, 418, 184, 50);
        Refreshbtn.setFont(f2);
        Refreshbtn.setCursor(cursor);
        Refreshbtn.setFocusable(false);
        c.add(Refreshbtn);

        Deletebtn = new JButton("Delete");
        Deletebtn.setBounds(248, 418, 184, 50);
        Deletebtn.setFont(f2);
        Deletebtn.setCursor(cursor);
        Deletebtn.setFocusable(false);
        c.add(Deletebtn);

        AddBook = new JButton("Add Book");
        AddBook.setBounds(442, 418, 184, 50);
        AddBook.setFont(f2);
        AddBook.setCursor(cursor);
        AddBook.setFocusable(false);
        c.add(AddBook);

        Exitbtn = new JButton("Exit");
        Exitbtn.setBounds(54, 480, 278, 50);
        Exitbtn.setFont(f2);
        Exitbtn.setCursor(cursor);
        Exitbtn.setFocusable(false);
        c.add(Exitbtn);

        BackBtn = new JButton("Back");
        BackBtn.setBounds(342, 480, 284, 50);
        BackBtn.setFont(f2);
        BackBtn.setCursor(cursor);
        BackBtn.setFocusable(false);
        c.add(BackBtn);

        //---------------------------------------------------JTable Layout--------------------
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);

        scroll = new JScrollPane(table);
        scroll.setBounds(53, 96, 578, 300);
        scroll.setBackground(Color.WHITE);
        c.add(scroll);

        String file = "./Data/BookData.txt";
        String temp = "./Data/temp.txt";

 
        try {
       // To read the file
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            // To input data in the table
            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file)).get(i);

        
                if ( line.startsWith("BookID") ) {

                    String BookID = Files.readAllLines(Paths.get(file)).get((i + 0)).split(":")[1].trim();
                    String BookName = Files.readAllLines(Paths.get(file)).get(i + 1).split(":")[1].trim();
                    String Author = Files.readAllLines(Paths.get(file)).get((i + 2)).split(":")[1].trim();
                    String Genre = Files.readAllLines(Paths.get(file)).get((i + 3)).split(":")[1].trim();
                    String Quantity = Files.readAllLines(Paths.get(file)).get((i + 4)).split(":")[1].trim();
                    
                    
                    rows[0] = BookID;
                    rows[1] = BookName;
                    rows[2] = Author;
                    rows[3] = Genre;
                    rows[4] = Quantity;
                    
                    model.addRow(rows);
                }
            
                
            }

        } catch (Exception ex) {
            //System.err.println(ex.getMessage());
            return;
        }

        // Refresh Button
        Refreshbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                BookPanel frame = new BookPanel();
                frame.setVisible(true);

            }
        });

        // Delete Button
        Deletebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (table.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a Book to delete", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String removeBook = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                    File oldFile = new File(file);
                    File newFile = new File(temp);

                    int q = 0;

                    try {

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i < totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(file)).get(i);

                            if (line.startsWith("BookID")) {
                                String BookID = Files.readAllLines(Paths.get(file)).get(i);

                                String matchBook = BookID.split(":")[1].trim();

                                if (matchBook.equals(removeBook)) {
                                    q = i;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        return;
                    }

                    try {

                        FileWriter fw = new FileWriter(temp, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int j = 0; j < totalLines; j++) {

                            if (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4)) {
                            //if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4))) {
                                String BookID = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println("#Removed! " + BookID);
                            } else {
                                String BookID = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println(BookID);
                            }
                        }
                        pw.flush();
                        pw.close();
                        fr.close();
                        br.close();
                        bw.close();
                        fw.close();

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                    oldFile.delete();
                    File dump = new File(file);
                    newFile.renameTo(dump);

                    setVisible(false);
                    BookPanel frame = new BookPanel();
                    frame.setVisible(true);
                }

            }
        });

        // Add Button
        AddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AddBook frame = new AddBook();
                frame.setVisible(true);
            }
        });

        // Exit Button
        Exitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        BackBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                UserPanel frame = new UserPanel();
                frame.setVisible(true);
            }
        });
    }
    //Searching Book Id
    public static String getBookInfoByBookId(String targetBookID) {
        try {
            // Specify the path to your file
            String filePath = "./Data/BookData.txt";

            // Read the content of the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            // Find the book Id
            for (int i = 0; (line = reader.readLine()) != null; i++) {
                stringBuilder.append(line);

                if (line.startsWith("BookID")) {
                    String bookID = line.split(":")[1].trim();
                    if (bookID.equals(targetBookID)) {
                       
                        //String book = Files.readAllLines(Paths.get(filePath)).get(i+4);
                        
                        return bookID;
                    }
                }
            }
          
            reader.close();
        
        }catch(Exception exception){
            //System.out.println( exception.getMessage() );
        }

        return "";
    }

    //Get the new book quantity
    public static int getBookQnt(String targetBookID) {
        try {
            // Specify the path to your file
            String filePath = "./Data/BookData.txt";

            // Read the content of the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            // found that book Id
            for (int i = 0; (line = reader.readLine()) != null; i++) {
                stringBuilder.append(line);

                if (line.startsWith("BookID")) {
                    String bookID = line.split(":")[1].trim();
                    if (bookID.equals(targetBookID)) {
                       
                        String book = Files.readAllLines(Paths.get(filePath)).get(i+4);
                        String qnt = book.split(":")[1].trim();

                        return Integer.parseInt(qnt);
                    }
                }
            }
          
            reader.close();
        
        }catch(Exception exception){
            System.out.println( exception.getMessage() );
        }

      

        return 1;
    }

    public static void updateBookQnt(String targetBookID, String newQuantity) {
        // Specify the path to your file
        String filePath = "./Data/BookData.txt";
    
        try {
            // Read the content of the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            int foundIndex = -1;
            int targetIndex = 0;

            // found that book
            for (int i = 0; (line = reader.readLine()) != null; i++) {
                stringBuilder.append(line);

                if (line.startsWith("BookID")) {
                    String bookID = line.split(":")[1].trim();
                    if (bookID.equals(targetBookID)) {
                        foundIndex = i;
                        targetIndex = i + 3;
                        break;
                    }
                }
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n");

          
            for (int i = foundIndex; (line = reader.readLine()) != null; i++) {  
                if(targetIndex == i){
                    line = "Quantity : "+newQuantity;
                }
                stringBuilder.append(line).append("\n");
            }


            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            // Close the reader
            reader.close();

            //System.out.println(stringBuilder);


            // Write the modified content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(stringBuilder.toString());

            // Close the writer
            writer.close();

            System.out.println("Quantity updated successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        BookPanel frame = new BookPanel();
        frame.setVisible(true);
    }
}
