import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class MyDashboardPage implements ActionListener{

	JFrame frame;
	JPanel panel;
	ImageIcon image;
	JButton button;
	
	MyDashboardPage(){
			
			   panel = new JPanel();
		        frame = new JFrame("Hotel El Fdiddnatte");
		        frame.setSize(1000,450);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setLocationRelativeTo(null);
		        frame.add(panel);

		        image = new ImageIcon("hotel.png");
		        frame.setIconImage(image.getImage());
		        
		        button = new JButton("Log_Out");
		        button.setBounds(5,350,150,50);
		        button.setBackground(new Color(255,228,196));
				button.setOpaque(true);
		        button.addActionListener(this);
		        panel.add(button);
		        
		        panel.setLayout(null);
		        panel.setBackground(new Color(250,235,215));
				panel.setOpaque(true);
				
				
				
				frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button) {
			
			frame.dispose();
			AdminePage adminePage = new AdminePage();
			
		}
		
	}
	
}
