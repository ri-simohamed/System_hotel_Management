import java.awt.Color;


import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import javax.swing.*;

public class ReservationPage {

	JFrame frame;
	JComboBox comtext,combtext;
	JButton bacbutton,valibutton;
	JTextField ftext,ltext,matext,nutext,cintext;
	JLabel firstName,lastName,CIN,phone,email,roomnum,typroom;
	
	ReservationPage(){
		
		Pageres();
		connect();
		
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void connect() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost/clients","root","");
	
		}
		catch(ClassNotFoundException ex) {
			
		}
		catch(SQLException ex) {
			
		}
	}
	

	
	public void Pageres() {
		frame = new JFrame("Hotel El Fdiddnatte");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,450);
		frame.setLocationRelativeTo(null);
		
		ImageIcon image = new ImageIcon("hotel.png");
		frame.setIconImage(image.getImage());
		
		JLabel label = new JLabel();
		label.setBackground(new Color(250,235,215));
		label.setOpaque(true);
		
		firstName = new JLabel("First_Name:");
		firstName.setBounds(5,15,150,40);
		firstName.setFont(new Font(null,Font.PLAIN,17));
		label.add(firstName);
		
		lastName = new JLabel("Last_Name: ");
		lastName.setBounds(5,70,150,40);
		lastName.setFont(new Font(null,Font.PLAIN,17));
		label.add(lastName);
		
		CIN = new JLabel("CIN: ");
		CIN.setBounds(5,130,150,40);
		CIN.setFont(new Font(null,Font.PLAIN,17));
		label.add(CIN);
		
		phone = new JLabel("Phone: ");
		phone.setBounds(5,210,150,40);
		phone.setFont(new Font(null,Font.PLAIN,17));
		label.add(phone);
		
		email = new JLabel("Email: ");
		email.setBounds(500,15,150,40);
		email.setFont(new Font(null,Font.PLAIN,17));
		label.add(email);
		
		roomnum = new JLabel("Room_Number:");
		roomnum.setBounds(500,145,150,40);
		roomnum.setFont(new Font(null,Font.PLAIN,17));
		label.add(roomnum);
		
		typroom = new JLabel("Type_Room: ");
		typroom.setBounds(500,80,150,40);
		typroom.setFont(new Font(null,Font.PLAIN,17));
		label.add(typroom);
		
		ftext = new JTextField();
		ftext.setBounds(150,15,200,35);
		ftext.setFont(new Font(null,Font.PLAIN,20));
		label.add(ftext);
		
		ltext = new JTextField();
		ltext.setBounds(150,70,200,35);
		ltext.setFont(new Font(null,Font.PLAIN,20));
		label.add(ltext);
		
		matext = new JTextField();
		matext.setBounds(150,130,200,35);
		matext.setFont(new Font(null,Font.PLAIN,20));
		label.add(matext);
		
		cintext = new JTextField();
		cintext.setBounds(650,15,200,35);
		cintext.setFont(new Font(null,Font.PLAIN,20));
		label.add(cintext);
		
		String[] type = {"Simpel","Double"};
		 comtext = new JComboBox(type);
		 comtext.setBounds(650,85,200,35);
		 comtext.setFont(new Font(null,Font.PLAIN,20));
		label.add( comtext);
		
       Integer[] numberRoom = {1,2,3,4,5,6,7,8,9,10};
		combtext = new JComboBox(numberRoom);
		combtext.setBounds(650,148,200,35);
		combtext.setFont(new Font(null,Font.PLAIN,20));
		label.add(combtext);
		
		nutext = new JTextField();
		nutext.setBounds(150,210,200,35);
		nutext.setFont(new Font(null,Font.PLAIN,20));
	     nutext.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyTyped(KeyEvent e) {
	                char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')) {
	                    e.consume();
	                }
	            }
	        });
		label.add(nutext);
		
		bacbutton = new JButton("Back");
		bacbutton.setBounds(5,320,200,50);
		bacbutton.setBackground(new Color(255,228,196));
		bacbutton.setOpaque(true);
		bacbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				WelcomePage window = new WelcomePage();
				
			}
			
		});
		label.add(bacbutton);
		
		valibutton = new JButton("Valide");
		valibutton.setBounds(750,320,200,50);
		valibutton.setBackground(new Color(255,228,196));
		valibutton.setOpaque(true);
		valibutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)  {
			
		String first,last,mail,cin,num,com;
		int comb;
		
				
			first = ftext.getText();
			last = ltext.getText();
			mail = matext.getText();
			cin = cintext.getText();
			comb = combtext.getSelectedIndex();
			com = comtext.getActionCommand();
			num = nutext.getText();
			
			try {
				pst = con.prepareStatement("insert into client(First_Name,Last_Name,CIN	Phone,Email,Room_type,Room_Number)valeues(?,?,?,?,?,?,?)");
                pst.setString(1, first);
                pst.setString(2, last);
                pst.setString(3, mail);
                pst.setString(4, cin);
                pst.setInt(5, comb);
                pst.setString(6, com);
                pst.setString(7, num);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Your Reservation addedd!!");
               ftext.setText("");
    		   ltext.setText("");
    		   matext.setText("");
    		   cintext.setText("");
    		   combtext.setSelectedIndex(0);
    		   comtext.setActionCommand("");
    		   nutext.getText();
    		   ftext.requestFocus();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			
			}
			
		});
		label.add(valibutton);
		
		frame.add(label);
		frame.setVisible(true);
		
	}



}
