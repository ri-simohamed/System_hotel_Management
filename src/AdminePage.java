import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.*;

import javax.swing.*;

public class AdminePage implements ActionListener{

	private static JLabel passwordLabel,UesrLabel;
    private static JTextField userText,passwordText;
    private static JButton button,button0,button1;
    private static JFrame frame;
    private static JPanel panel;
    
	AdminePage(){
		 
		ImageIcon image = new ImageIcon("hotel.png");
	     
		JLabel label = new JLabel();
		    label.setIcon(image);
			label.setBackground(new Color(250,235,215));
			label.setOpaque(true);
		
		   panel = new JPanel();
	        frame = new JFrame("Hotel El Fdiddnatte");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1000,450);
	        frame.setLocationRelativeTo(null);
	        frame.add(panel);

	        ImageIcon image2 = new ImageIcon("hotel.png");
	        frame.setIconImage(image2.getImage());
	        
	        
	        
	        panel.setLayout(null);
	        panel.setBackground(new Color(250,235,215));
			panel.setOpaque(true);
	        
			UesrLabel = new JLabel("Uesr:");
	        UesrLabel.setBounds(20,25,90,25);
	        UesrLabel.setFont(new Font(null,Font.PLAIN,17));
	        panel.add(UesrLabel);

	        userText = new JTextField();
	        userText.setBounds(150,20,185,32);
	        userText.setFont(new Font(null,Font.PLAIN,20));
	        panel.add(userText);

	        passwordLabel = new JLabel("Password:");
	        passwordLabel.setBounds(20,140, 80, 25);
	        passwordLabel.setFont(new Font(null,Font.PLAIN,17));
	        panel.add(passwordLabel);

	        passwordText = new JPasswordField();
	        passwordText.setBounds(150,135,185,32);
	        passwordText.setFont(new Font(null,Font.PLAIN,20));
	        panel.add(passwordText);

	        button = new JButton(" Login");
	        button.setBounds(320,240,100,45);
	        button.setBackground(new Color(255,228,196));
			button.setOpaque(true);
	        button.addActionListener(this);
	        panel.add(button);
	        
	        button0 = new JButton("Back ");
	        button0.setBounds(5,350,150,50);
	        button0.setBackground(new Color(255,228,196));
			button0.setOpaque(true);
	        button0.addActionListener(this);
	        panel.add(button0);

	        panel.add(label);
	        frame.setVisible(true);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ImageIcon icon = new ImageIcon("icon_r.jpg");
		 
		String user =  userText.getText();
		String pass = passwordText.getText();
		   if (e.getSource()==button &&
			   user.equals("Admine") && 
			   pass.equals("admine2021")){
			   
			   frame.dispose();
			   
		    	JOptionPane.showMessageDialog(button, "Your Login successflly","Informition",
		    			JOptionPane.INFORMATION_MESSAGE,icon);
		    	   
		    	MyDashboardPage MydashboardPage = new MyDashboardPage();
		    	
		    }
		   else if (e.getSource()==button0) {
			   
			   frame.dispose();
			   
			   WelcomePage welcomePage = new WelcomePage();
			   
		   }
	
		else {
			
	    	JOptionPane.showMessageDialog(button, "user or password it's not valid!!",                         
	    			                       "WARNING!!",JOptionPane.WARNING_MESSAGE);
	    }
		
	}




}
