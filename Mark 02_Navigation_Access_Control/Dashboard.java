import javax.swing.*;  
import java.awt.event.*;  
public class Dashboard implements ActionListener{  
    //labels  
    JLabel lano;
    JLabel lbalance;
	JLabel opName;
	
	//textfields
    JTextField accNo;
    JTextField balance;
	
	//textarea
    JTextArea display;
	
	//buttons
	JButton insertBtn;
	JButton deleteBtn;
    JButton dispBtn;
    JButton searchBtn;
    JButton logoutBtn;
	JButton lcUser;
	JButton proceed;
	
	//frame
	JFrame frame;
	
	//Dashboard()
    Dashboard(String user)
	{  
        //create frame
		frame = new JFrame ("Dashboard");
		
        //construct components
        
        lano = new JLabel ("Account Number");
        lbalance = new JLabel ("Balance");
		opName = new JLabel ("Default!");
        accNo = new JTextField (5);
        balance = new JTextField (5);
		
		display = new JTextArea (5, 5);
		
		insertBtn = new JButton ("Insert");
        deleteBtn = new JButton ("Delete");
        dispBtn = new JButton ("Display");
		proceed = new JButton("Proceed");
        searchBtn = new JButton ("Search");
        logoutBtn = new JButton ("Logout");
		lcUser = new JButton(user);


        //add components
        
        frame.add (lano);
        frame.add (lbalance);
        frame.add (accNo);
		frame.add (opName);
        frame.add (balance);
		
		frame.add (display);
		
		frame.add (insertBtn);
        frame.add (deleteBtn);
        frame.add (dispBtn);
        frame.add (searchBtn);
		frame.add (proceed);
        frame.add (logoutBtn);
        frame.add (lcUser);

        //set component bounds (only needed by Absolute Positioning)
        lano.setBounds (35, 90, 100, 25);
        lbalance.setBounds (35, 130, 100, 25);
		opName.setBounds (365, 80, 140, 30);
        accNo.setBounds (155, 90, 100, 25);
        balance.setBounds (155, 130, 100, 25);
		
		display.setBounds (35, 180, 380, 90);
				
		insertBtn.setBounds (35, 30, 120, 30);
        deleteBtn.setBounds (165, 30, 120, 30);
        dispBtn.setBounds (290, 30, 120, 30);
		proceed.setBounds(355, 110, 120, 30);
        searchBtn.setBounds (420, 30, 120, 30);
        logoutBtn.setBounds (525, 5, 75, 20);
        lcUser.setBounds (420, 5, 75, 20);
		
		//by default labels, textfield, textarea-invisible
		lano.setVisible(false);
		lbalance.setVisible(false);
		opName.setVisible(false);
		accNo.setVisible(false);
		balance.setVisible(false);
		display.setVisible(false);
		proceed.setVisible(false);
		
		//addActionListener
		logoutBtn.addActionListener(this);
		lcUser.addActionListener(this);
		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		dispBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		
		
        //frame properties
		//adjust size and set layout
        frame.setSize (624, 329);
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
			//System.exit(0);
			
        }  
		else if(e.getSource() == lcUser)
		{
			String user = lcUser.getText();
			new Profile(user);
			frame.setVisible(false);
		}
		else if(e.getSource() == insertBtn)
		{
			lano.setVisible(true);
			lbalance.setVisible(true);
			opName.setText("Operation: Insert");
			opName.setVisible(true);
			accNo.setVisible(true);
			balance.setVisible(true);
			display.setVisible(true);
			proceed.setVisible(true);
			
		}
		else if(e.getSource() == deleteBtn)
		{
			lano.setVisible(true);
			accNo.setVisible(true);
			display.setVisible(true);
			proceed.setVisible(true);
			
			opName.setText("Operation: Delete");
			opName.setVisible(true);
			
			lbalance.setVisible(false);
			balance.setVisible(false);
		}
		else if(e.getSource() == dispBtn)
		{
			lano.setVisible(true);
			accNo.setVisible(true);
			display.setVisible(true);
			proceed.setVisible(true);
			
			opName.setText("Operation: Display");
			opName.setVisible(true);
			
			lbalance.setVisible(false);
			balance.setVisible(false);
		}
		else if(e.getSource() == searchBtn)
		{
			lano.setVisible(true);
			accNo.setVisible(true);
			display.setVisible(true);
			proceed.setVisible(true);
			
			opName.setText("Operation: Search");
			opName.setVisible(true);
			
			lbalance.setVisible(false);
			balance.setVisible(false);
		}
		
	}

  
    	
      
}