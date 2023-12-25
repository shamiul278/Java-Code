import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.nio.file.*;


public class ReturnedBookPanel extends JFrame {

    private Container c;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton Refreshbtn, Deletebtn, AddReturnBtn,  Exitbtn, BackBtn;
    private Cursor cursor;

    private String[] column = { "Book ID", "Customer Name", "Return Date" };
    private String[] rows = new String[3];

    public ReturnedBookPanel() {
        //------------------------------Frame Layout---------------------

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library Management System");
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        //----------------------------Fonts-------------------------------
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Label
        label1 = new JLabel();
        label1.setText("Return Book");
        label1.setBounds(200, 10, 400, 80);
        label1.setFont(f1);
        c.add(label1);

        //---------------------------------Buttons---------------------

        // Refresh Button
        Refreshbtn = new JButton("Refresh");
        Refreshbtn.setBounds(54, 418, 184, 50);
        Refreshbtn.setFont(f2);
        Refreshbtn.setCursor(cursor);
        Refreshbtn.setFocusable(false);
        c.add(Refreshbtn);

        //Delete Button
        Deletebtn = new JButton("Delete");
        Deletebtn.setBounds(248, 418, 184, 50);
        Deletebtn.setFont(f2);
        Deletebtn.setCursor(cursor);
        Deletebtn.setFocusable(false);
        c.add(Deletebtn);

        // Add Returned Button
        AddReturnBtn = new JButton("Add Return");
        AddReturnBtn.setBounds(442, 418, 184, 50);
        AddReturnBtn.setFont(f2);
        AddReturnBtn.setCursor(cursor);
        AddReturnBtn.setFocusable(false);
        c.add(AddReturnBtn);

        // Add Exit Button
        Exitbtn = new JButton("Exit");
        Exitbtn.setBounds(54, 480, 278, 50);
        Exitbtn.setFont(f2);
        Exitbtn.setCursor(cursor);
        Exitbtn.setFocusable(false);
        c.add(Exitbtn);

        // Add Back Button
        BackBtn = new JButton("Back");
        BackBtn.setBounds(342, 480, 284, 50);
        BackBtn.setFont(f2);
        BackBtn.setCursor(cursor);
        BackBtn.setFocusable(false);
        c.add(BackBtn);

        // -------------------------------------Table Layout-----------------------------
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(190);
        table.getColumnModel().getColumn(1).setPreferredWidth(190);
        table.getColumnModel().getColumn(2).setPreferredWidth(195);

        
        scroll = new JScrollPane(table);
        scroll.setBounds(40, 100, 580, 300);
        scroll.setBackground(Color.WHITE);
        c.add(scroll);

        String file = "./Data/ReturnBookData.txt";
        String temp = "./Data/temp.txt";

        // To input data in the table
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file)).get(i);

                if (line.startsWith("BookID")) {

                    String BookID = Files.readAllLines(Paths.get(file)).get(i + 0).split(":")[1].trim();
                    String CustomerName = Files.readAllLines(Paths.get(file)).get(i + 1).split(":")[1].trim();
                    String ReturnDate = Files.readAllLines(Paths.get(file)).get((i + 2));
					
                    int ReturnDateStartIndex = ReturnDate.split(":")[0].length() + 2;
                    
                    String ReturnDateString = ReturnDate.substring(ReturnDateStartIndex).trim(); // Date & Time

                    rows[0] = BookID;
                    rows[1] = CustomerName;
                    rows[2] = ReturnDateString;

                    model.addRow(rows);
                }
               
            }

        } catch (Exception ex) {
            //System.err.println(ex.getMessage());
            return;
        }

        //--------------------------------------ActionListener--------------------------------------

        // Refresh Button
        Refreshbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                ReturnedBookPanel frame = new ReturnedBookPanel();
                frame.setVisible(true);

            }
        });

        // Delete Button
        Deletebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (table.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a Returnbook to delete", "Warning!",
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

                            if ((j == q || j == (q + 1) || j == (q + 2) || j == (q + 3))) {
                            //if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3))) {
                                String BookName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println("#Removed! " + BookName);
                            } else {
                                String BookName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println(BookName);
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
                    ReturnedBookPanel frame = new ReturnedBookPanel();
                    frame.setVisible(true);
                }

            }
        });

        // Add Button
           AddReturnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AddReturnBook frame = new AddReturnBook();
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

    
    public static void main(String[] args) {
        ReturnedBookPanel frame = new ReturnedBookPanel();
        frame.setVisible(true);
    }
}
