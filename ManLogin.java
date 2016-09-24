package labProject;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.awt.image.*;

import javax.imageio.*;

import java.awt.image.BufferedImage.*;

import javax.swing.border.*;
public class ManLogin extends JFrame implements ActionListener
{
	JLabel l1,l2,hl;
	JButton b1,b2,back,home;
	JTextField t1;
	JPasswordField p1;
	Color c;
	Validate v;
	ManLogin()
	{
		v = new Validate();
		BufferedImage img = null,img1 = null,img2 = null,img4 = null,img5 = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\back.jpg"));	
			img1 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\home.jpg"));
			img2 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\bck.jpg"));
			img4 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\login.jpg"));
			img5 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\clear.jpg"));
		} 
		catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		Image dimg = img.getScaledInstance(500, 500,Image.SCALE_SMOOTH);
		Image dimg1 = img1.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		Image dimg2 = img2.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		Image dimg4 = img4.getScaledInstance(70, 70,Image.SCALE_SMOOTH);
		Image dimg5 = img5.getScaledInstance(70, 70,Image.SCALE_SMOOTH);
		
		setTitle("Manager Login Page");		
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(dimg)));
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setSize(500,500);
		pack();
		setLocationRelativeTo(null);
		
		Font f=new Font("Arial",Font.BOLD,15);
		
		c=new Color(127,127,150);
		
		Color c1=new Color(96,96,96);
		
		Font f1=new Font("Arial",Font.ITALIC,15);
		Font f2=new Font("Arial",Font.BOLD,30);
		
		hl=new JLabel("Manager Login");
		hl.setBounds(130,50,300,40);
		hl.setFont(f2);
		//hl.setForeground(c1);
		add(hl);
		
		l1=new JLabel("User ID");
		l1.setBounds(80,120,100,20);
		l1.setFont(f);
		l1.setForeground(c1);
		add(l1);
		
		t1=new JTextField(20);
		t1.setBounds(230,120,200,20);
		t1.setFont(f1);
		add(t1);
		
		
		
		l2=new JLabel("Password");
		l2.setBounds(80,190,100,20);
		l2.setFont(f);
		l2.setForeground(c1);
		add(l2);
		
		p1=new JPasswordField(20);
		p1.setBounds(230,190,200,20);
		p1.setFont(f1);
		add(p1);
		
		b1=new JButton();
		b1.setIcon(new ImageIcon(dimg4));
		b1.setBounds(150,270,70,70);
		b1.setBackground(c);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setBorder(null);
		add(b1);
		
		b2=new JButton();
		b2.setIcon(new ImageIcon(dimg5));
		b2.setBounds(260,270,70,70);
		b2.setBackground(c);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setBorder(null);
		add(b2);
		

		setSize(499,499);
		setSize(500,500);
		
	
		
		
		
		back=new JButton();
		back.setIcon(new ImageIcon(dimg2));
		back.setBounds(440,380,50,50);
		back.setBackground(c);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		add(back);
		
		home=new JButton();
		home.setIcon(new ImageIcon(dimg1));
		home.setBounds(0,380,50,50);
		home.setBackground(c);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		add(home);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(499,499);
		setSize(500,460);
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		back.addActionListener(this);
		home.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			//User-ID Password Check 
			//DBMS Connectivity
			int r=0 , id = Integer.parseInt(t1.getText());
			String pass = new String(p1.getPassword());
			try {
				r = v.manager(id ,  pass);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			if(r==0) {
				JOptionPane.showMessageDialog(this, "Id doesn't exist");
				setVisible(false);
				new Start();
			}
			else if(r==1) {
				JOptionPane.showMessageDialog(this, "Wrong password!!!!");
				setVisible(false);
				new Start();
			}
			else {
				new ManDisplay();
				setVisible(false);
			}
		}
		else if(ae.getSource()==b2)
		{
			t1.setText("");
			p1.setText("");
		}
		else if(ae.getSource()==back)
		{
			new Start();
			setVisible(false);
		}
		else if(ae.getSource()==home)
		{
			new Start();
			setVisible(false);
		}
	}
}