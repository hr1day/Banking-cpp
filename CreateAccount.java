package com.bank;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;


public class CreateAccount implements ActionListener
{
 JLabel l1, l2, l3,l4,l5,l6,l7,l8;
 JTextField tf2,tf3,tf6,tf7,tf8;
 JButton btn1;
 JPasswordField p4,p5;

 CreateAccount() {

  JFrame frame = new JFrame("Create an Account");
  l1 = new JLabel("Create an Account");
  l1.setForeground(Color.blue);
  l1.setFont(new Font("Serif", Font.BOLD, 20));
 
  l2 = new JLabel("Username");      
  l3 = new JLabel("Name");          
  l4 = new JLabel("Password");      
  l5 = new JLabel("Confirm Password");
  l6 = new JLabel("E-mail");        
  l7 = new JLabel("Phone Number");  
  l8 = new JLabel("Country");       
  tf2 = new JTextField();           
  tf3 = new JTextField(); 
  tf6 = new JTextField();
  tf7 = new JTextField();
  tf8 = new JTextField();
  p4 = new JPasswordField();
  p5 = new JPasswordField();
  btn1 = new JButton("Create");
 
  l1.setBounds(100, 30, 400, 30);
  l2.setBounds(80, 70, 200, 30);
  l3.setBounds(80, 110, 200, 30);
  l4.setBounds(80, 150, 200, 30);
  l5.setBounds(80, 190, 200, 30);
  l6.setBounds(80, 230, 200, 30);
  l7.setBounds(80, 270, 200, 30);
  l8.setBounds(80, 310, 200, 30);
  
  tf2.setBounds(300, 70, 200, 30);
  tf3.setBounds(300, 110, 200, 30);
  tf6.setBounds(300, 230, 200, 30);
  tf7.setBounds(300, 270, 200, 30);
  tf8.setBounds(300, 310, 200, 30);
  p4.setBounds(300, 150, 200, 30);
  p5.setBounds(300, 190, 200, 30);
  btn1.setBounds(150, 350, 100, 30);
 
  frame.add(l1);
  frame.add(l2);
  frame.add(l3);
  frame.add(l4);
  frame.add(l5);
  frame.add(l6);
  frame.add(l7);
  frame.add(l8);
   
  frame.add(tf2);
  frame.add(tf3);
  frame.add(tf6);
  frame.add(tf7);
  frame.add(tf8);
  frame.add(p4);
  frame.add(p5);
  frame.add(btn1);
  
 
  frame.setSize(400, 400);
  frame.setLayout(null);
  frame.setVisible(true);
  btn1.addActionListener(this);
  
  
  
  
 }



    public void actionPerformed(ActionEvent ae) 
    {
        if(String.valueOf(p4.getPassword()).equals(String.valueOf(p5.getPassword())))
        {
            /*int low=0,up=0,s=0,n=0;

            char p[]=String.valueOf(p4.getPassword()).toCharArray();
            for(int i=0;i<p.length;i++)
            {
                if((char)p[i]>=97 && (char)p[i]<=122 )
                {
                    low++;
                }
                if((char)p[i]>=65 && (char)p[i]<=90 )
                {
                    up++;
                }
                if((char)p[i]>=35 && (char)p[i]<=47 )
                {
                    s++;
                }
                if((char)p[i]>=48 && (char)p[i]<=57 )
                {
                    n++;
                }
            }
            if(low>=1 && up>=1 && s>=1 && n>=1)
            {*/
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                    PreparedStatement ps=con.prepareStatement("Insert into customer values(?,?,?,?,?,?,?)");
                    ps.setString(1,tf2.getText());
                    ps.setString(2,tf3.getText() );
                    ps.setString(3, String.valueOf(p4.getPassword()));
                    ps.setString(4, tf6.getText());
                    ps.setString(5,tf7.getText() );
                    ps.setString (6,tf8.getText() );
                    ps.setInt(7,0);
                    int status = ps.executeUpdate();
                    con.close();
                    JOptionPane.showMessageDialog(null,"Account created successfully!");
                }
                catch(Exception e)
                {
                    System.out.println("Error caught"+e);
                    
                }
            //}
            /*else
            {
                JOptionPane.showMessageDialog(null,"Invalid Password",
                "Error",JOptionPane.ERROR_MESSAGE);
            }*/
        }
        else
        {
                JOptionPane.showMessageDialog(null,"Passwords do not match",
                "Error",JOptionPane.ERROR_MESSAGE);
        }
    
    }
}