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

 
public class LoginForm //extends JFrame implements ActionListener{
{
 /*JLabel l1, l2, l3;
 JTextField tf1;
 JButton btn1;
 JPasswordField p1;*/
 LoginForm() {
  /*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  JFrame frame = new JFrame("Login Form");
  l1 = new JLabel("Login Form");
  l1.setForeground(Color.blue);
  l1.setFont(new Font("Serif", Font.BOLD, 20));
 
  l2 = new JLabel("Username");
  l3 = new JLabel("Password");
  tf1 = new JTextField();
  p1 = new JPasswordField();
  btn1 = new JButton("Login");
 
  l1.setBounds(100, 30, 400, 30);
  l2.setBounds(80, 70, 200, 30);
  l3.setBounds(80, 110, 200, 30);
  tf1.setBounds(300, 70, 200, 30);
  p1.setBounds(300, 110, 200, 30);
  btn1.setBounds(150, 160, 100, 30);
 
  frame.add(l1);
  frame.add(l2);
  frame.add(tf1);
  frame.add(l3);
  frame.add(p1);
  frame.add(btn1);
 
  frame.setSize(400, 400);
  frame.setLayout(null);
  frame.setVisible(true);
  btn1.addActionListener(this);
 }
 @Override
 public void actionPerformed(ActionEvent ae)
 {*/
   try{
       Class.forName("com.mysql.jdbc.Driver");   
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
       //PreparedStatement ps=con.prepareStatement("Select * from customer where Username=?");
       Statement stmt=con.createStatement();
       //stmt.setString(1,"chinmayp");
       //ResultSet rs=stmt.executeQuery("Select * from customer where Username=chinmayp");
       //System.out.println(rs.getString(3));
       /*if(rs.getString(3).equals((p1.getText())))
       {
           Inbox i=new Inbox(tf1.getText());
       }
       else
       {
           JOptionPane.showMessageDialog(this,"Incorrect login or password",
                "Error",JOptionPane.ERROR_MESSAGE);
           tf1.setText("");
           p1.setText("");           
       }*/
   }
   catch(Exception e)
   {
       JOptionPane.showMessageDialog(null,e);
       
   }
      
   
  }
 public static void main(String []args)
 {
     LoginForm l =new LoginForm();
 }
}
 

