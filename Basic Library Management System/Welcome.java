import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Welcome extends JFrame implements ActionListener {

    private ImageIcon Image;
    private JLabel Label;
    private JButton Start;
    private Cursor cursor;

    Welcome() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library Management System");
        this.setSize(960, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane();
        this.setLayout(null);

        Image = new ImageIcon(getClass().getResource("/image/Welcome.png"));
        Label = new JLabel(Image);
        Label.setBounds(320, 30, Image.getIconWidth(), Image.getIconHeight());
        this.add(Label);

        Label = new JLabel("Welcome \nTo");
        Label.setBounds(325, 270, 690, 50);
        Label.setFont(new Font("Arial", Font.BOLD, 40));
        this.add(Label);

        Label = new JLabel("Basic Library Management System");
        Label.setBounds(160, 330, 690, 50);
        Label.setFont(new Font("Arial", Font.BOLD, 40));
        this.add(Label);

        Start = new JButton("Start");
        Start.setBounds(360, 418, 184, 50);
        Start.setFont(new Font("Arial", Font.BOLD, 18));
        Start.setCursor(cursor);
        Start.setForeground(Color.WHITE);
        Start.setBackground(Color.RED);
        Start.addActionListener(this);
        this.add(Start);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Start) {
            setVisible(false);
            LoginType frame = new LoginType();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Welcome frame = new Welcome();
        frame.setVisible(true);
    }
}
