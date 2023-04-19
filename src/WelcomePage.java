import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomePage {
	
	JFrame frame;
	JPanel panel;
	JTextField textfield;
	JButton reservbutton,helpbutton,searbutton,admibutton;
	
	WelcomePage(){
		
		ImageIcon image = new ImageIcon("hotel.png");
	     
		JLabel label = new JLabel();
		    label.setIcon(image);
			label.setBackground(new Color(250,235,215));
			label.setOpaque(true);
			
			JLabel textlabel = new JLabel();
			textlabel.setText("WELCOME TO HOTEL EL FDIDDNATTE");
			textlabel.setBounds(20,20,700,50);
			textlabel.setFont(new Font(null, Font.PLAIN,35));
			textlabel.setForeground(new Color(	0,0,255));
			textlabel.setBackground(new Color(255,228,196));
			textlabel.setOpaque(true);
			
			admibutton = new JButton("Adminstrastion");
			admibutton.setBounds(735,0,120,50);
			admibutton.setBackground(new Color(255,228,196));
			admibutton.setOpaque(true);
			admibutton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					frame.dispose();
					AdminePage admin = new AdminePage();
					
				}
				
			});
			
			reservbutton = new JButton("Reservation");
			reservbutton.setBounds(860,0,120,50);
			reservbutton.setBackground(new Color(255,228,196));
			reservbutton.setOpaque(true);
			reservbutton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					frame.dispose();
					ReservationPage page = new ReservationPage();
					
				}
				
			});
			
			frame = new JFrame("Hotel El Fdiddnatte");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1000,450);
			frame.setLocationRelativeTo(null);
			
			 ImageIcon image1 = new ImageIcon("hotel.png");
		        frame.setIconImage(image1.getImage());
			
			//label.add(helpbutton);
			//label.add(searbutton);
			label.add(reservbutton);
			label.add(admibutton);
			label.add(textlabel);
			frame.add(label);
			frame.setVisible(true);
			
		
	}


	
}


