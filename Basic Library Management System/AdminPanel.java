import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.nio.file.*;


public class AdminPanel extends JFrame {

    private Container c;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton Refreshbtn, Deletebtn, AddUserbtn, ExitBtn, Backbtn;
    private Cursor cursor;

    private String[] column = { "User Name", "Password", "Email", "Date and Time" };
    private String[] rows = new String[7];

    AdminPanel() {
        // ----------------------------------------Frame Layout---------------------
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
        label1.setText("User Data");
        label1.setBounds(200, 10, 400, 80);
        label1.setFont(f1);
        c.add(label1);

        //----------------------------------------------------JButtons--------------------------------
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

        AddUserbtn = new JButton("Add User");
        AddUserbtn.setBounds(442, 418, 184, 50);
        AddUserbtn.setFont(f2);
        AddUserbtn.setCursor(cursor);
        AddUserbtn.setFocusable(false);
        c.add(AddUserbtn);

        ExitBtn = new JButton("Exit");
        ExitBtn.setBounds(54, 480, 278, 50);
        ExitBtn.setFont(f2);
        ExitBtn.setCursor(cursor);
        ExitBtn.setFocusable(false);
        c.add(ExitBtn);

        Backbtn = new JButton("Back");
        Backbtn.setBounds(342, 480, 284, 50);
        Backbtn.setFont(f2);
        Backbtn.setCursor(cursor);
        Backbtn.setFocusable(false);
        c.add(Backbtn);

        // JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);

        scroll = new JScrollPane(table);
        scroll.setBounds(53, 96, 578, 300);
        scroll.setBackground(Color.WHITE);
        c.add(scroll);

        String file = "./Data/UserData.txt";
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

                if (line.startsWith("Username")) {

                    String username = Files.readAllLines(Paths.get(file)).get(i + 0).split(":")[1].trim();
                    String password= Files.readAllLines(Paths.get(file)).get((i + 1)).split(":")[1].trim();
                    String email = Files.readAllLines(Paths.get(file)).get((i + 2)).split(":")[1].trim();
                    
                    String dateTime = Files.readAllLines(Paths.get(file)).get((i + 3));
                    int dateTimeStartIndex = dateTime.split(":")[0].length() + 2;
                    
                    String dateTimeString = dateTime.substring(dateTimeStartIndex).trim(); // Date & Time

                    rows[0] = username;
                    rows[1] = password;
                    rows[2] = email;
                    rows[3] = dateTimeString;
                    
                    model.addRow(rows);
                }
            
                
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return;
        }

        // Refresh Button
        Refreshbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                AdminPanel frame = new AdminPanel();
                frame.setVisible(true);

            }
        });

        // Delete Button
        Deletebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (table.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

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
                            if (line.startsWith("Username")) {
                                String userName = Files.readAllLines(Paths.get(file)).get(i);

                                String matchUser = userName.substring(11);

                                if (matchUser.equals(removeUser)) {
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
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println("#Removed! " + userName);
                            } else {
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println(userName);
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
                    AdminPanel frame = new AdminPanel();
                    frame.setVisible(true);
                }

            }
        });

        // Add Button
        AddUserbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminAdd frame = new AdminAdd();
                frame.setVisible(true);
            }
        });

        // Exit Button
        ExitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        Backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminLogin frame = new AdminLogin();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        AdminPanel frame = new AdminPanel();
        frame.setVisible(true);
    }
}
