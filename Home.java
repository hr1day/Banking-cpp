package com.bank;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Home extends JFrame{
    JButton btn1,btn2;
    Home(){
    JFrame frame = new JFrame("Home");
    btn1 = new JButton("Login");
    btn2 = new JButton("Create Account");
    btn1.setBounds(150, 160, 100, 30);
    btn2.setBounds(255, 160, 100, 30);
    frame.add(btn1);
    frame.add(btn2);
    frame.setSize(400, 400);
    frame.setLayout(null);
    frame.setVisible(true);
    btn1.addActionListener(new ButtonListener());
    btn2.addActionListener(new ButtonListener());
    }
    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==btn1)
            {
                LoginForm l=new LoginForm();
                
            }
            else if(ae.getSource()==btn2)
            {
               CreateAccount c= new CreateAccount();
            }
        }
    }    
    static 
    {
        try{
                Class.forName("com.mysql.jdbc.Driver");  
        }
        catch(Exception ee)
                {
                    System.out.println(ee.getMessage());
                    
                }
                
    }
   
}
