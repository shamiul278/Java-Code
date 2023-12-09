import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Test implements ActionListener{
    private JButton prvBtn;
    private JButton logoutBtn;
	JFrame frame;

    public Test() {
		
		//create frame
		frame = new JFrame ("Profile");
		
        //construct components
        prvBtn = new JButton ("Previous");
        logoutBtn = new JButton ("Logout");
       

      

        //add components
        frame.add (prvBtn);
        frame.add (logoutBtn);
        

        //set component bounds (only needed by Absolute Positioning)
        prvBtn.setBounds (320, 5, 90, 20);
        logoutBtn.setBounds (450, 5, 90, 20);
       
		
		//addActionListener
		logoutBtn.addActionListener(this);
		prvBtn.addActionListener(this);
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
			new Profile("TEST");
			frame.setVisible(false);
		}
		
		
	}
	
	
}
