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

public class Inbox extends JFrame implements ActionListener {
    JLabel lb1, lb2, lb3,lb4;    
    JButton b1,b2,b3;
    JTextField t1,t2,t3;
    String username;
    
    Inbox(){}
    Inbox(String u){
        username=u;
        lb1=new JLabel("WELCOME TO THE PERSONAL BANK");  lb1.setBounds(50,15,300,30);
        lb1.setForeground(Color.blue);
        lb1.setFont(new Font("Courier ", Font.ITALIC, 20));  
        lb2=new JLabel("To view balance ");      lb2.setBounds(15,100,150,30);
        lb3=new JLabel("To transfer funds ");    lb3.setBounds(15,145,150,30);
        lb4=new JLabel("To change password ");   lb4.setBounds(15,190,150,30);
        t1=new JTextField();       t1.setBounds(200,145,100,30);
        t2=new JTextField();       t3.setBounds(200,190,100,30);
        t3=new JTextField();       t1.setBounds(200,235,100,30);
        b1=new JButton("Click here");     b1.setBounds(200,100,75,30);
        b2=new JButton("depost money");   b2.setBounds(200,320,75,30);
        b1=new JButton("Change");         b3.setBounds(200,280,75,30);
        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);
        add(b1);
        add(b2);
        add(b3);
        add(t1);
        add(t2);
        add(t3);
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");   
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
                PreparedStatement ps=con.prepareStatement("Select from customer where Username="+username);                
                ResultSet rs=ps.executeQuery();              
                JOptionPane.showMessageDialog(this,"Your balance is "+rs.getString(7));
                con.close();
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }            
        }
        else if(e.getSource()==b2)
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");   
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
                PreparedStatement ps=con.prepareStatement("Select from customer where Username="+username);                
                ResultSet rs=ps.executeQuery();    
                rs.moveToInsertRow();
                rs.updateInt(7,Integer.parseInt(t1.getText()));
                rs.insertRow();
                rs.moveToCurrentRow();
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }                                
        }
     else if(e.getSource()==b3)
     {
         try{
                Class.forName("com.mysql.jdbc.Driver");   
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
                PreparedStatement ps=con.prepareStatement("Select from customer where Username="+username);                
                ResultSet rs=ps.executeQuery(); 
                String pass=rs.getNString(3);
                if(t2.getText()==pass)
                {
                    rs.moveToInsertRow();
                    rs.updateString(3,t3.getText());
                    rs.insertRow();
                    rs.moveToCurrentRow();
                    JOptionPane.showMessageDialog(this,"Password updated successfully :)");
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Wrong Password");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }  
         
     }
    }
    
    
}