import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Profile implements ActionListener{
    private JButton prvBtn;
    private JButton logoutBtn;
    private JButton updBtn;
	private JButton nextBtn;
    private JLabel uName;
    private JTextField userTf;
	JFrame frame;

    public Profile(String user) {
		
		//create frame
		frame = new JFrame ("Profile");
		
        //construct components
        prvBtn = new JButton ("Previous");
        logoutBtn = new JButton ("Logout");
        updBtn = new JButton ("Update");
		nextBtn = new JButton("Next");
        uName = new JLabel ("Username");
        userTf = new JTextField (user);

      

        //add components
        frame.add (prvBtn);
        frame.add (logoutBtn);
        frame.add (updBtn);
		frame.add (nextBtn);
        frame.add (uName);
        frame.add (userTf);

        //set component bounds (only needed by Absolute Positioning)
        prvBtn.setBounds (320, 5, 90, 20);
        logoutBtn.setBounds (450, 5, 90, 20);
        updBtn.setBounds (170, 215, 140, 30);
		nextBtn.setBounds (120, 5, 90, 20);
        uName.setBounds (135, 125, 100, 25);
        userTf.setBounds (250, 125, 100, 25);
		
		//addActionListener
		logoutBtn.addActionListener(this);
		prvBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		//updBtn.addActionListener(this);
		
		//frame properties
		//adjust size and set layout
        frame.setSize (600, 329);
		frame.setLocationRelativeTo(null);//to center screen gui
        frame.setLayout (null);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.setVisible (true); 
    }
	
	
	public void actionPerformed(ActionEvent e) {  
         
        if(e.getSource()==logoutBtn)
		{  
			new Login();
			frame.setVisible(false);
			
        }  
		else if(e.getSource()==prvBtn)
		{
			new Dashboard(userTf.getText());
			frame.setVisible(false);
		}
		else if(e.getSource()==nextBtn)
		{
			new Test();
			frame.setVisible(false);
		}
		else if(e.getSource()==updBtn)
		{
			//write necessary codes to update user profile
		}
		
	}
	
	
}
