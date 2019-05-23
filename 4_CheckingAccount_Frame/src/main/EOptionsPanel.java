/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;
import static main.Main.check;
import static main.Main.flag;
import static main.Main.fmt;
import static main.Main.message1;
import static main.Main.message2;
import static main.Main.transcode;

 

public class EOptionsPanel extends JPanel

{

   private JLabel prompt;

   private JRadioButton one, two, three, four, five, six, seven;
   public static int transcode;
   public static double transAmt;
   public static String initalstr, codestr, transtr;
 

   //-----------------------------------------------------------------

   //  Sets up a panel with a label and a set of radio buttons

   //  that present options to the user.

   //-----------------------------------------------------------------

   public EOptionsPanel()

   {
      
       
      prompt = new JLabel ("Choose Action:");

      prompt.setFont (new Font ("Helvetica", Font.BOLD, 35));

       setLayout (new FlowLayout()); 

      one = new JRadioButton ("Enter Transaction",true);
      one.setBackground (Color.yellow);
      two = new JRadioButton ("List all Transaction",false);
      two.setBackground (Color.yellow);
      three = new JRadioButton ("List all Check",false);
      three.setBackground (Color.yellow);
      four = new JRadioButton ("List all Deposit",false);
      four.setBackground(Color.yellow);
      five = new JRadioButton ("List all Service Charge",false);
      five.setBackground(Color.yellow);
      six = new JRadioButton ("Read from file", false);
      six.setBackground(Color.yellow);
      seven = new JRadioButton ("Write to the file", false);
      seven.setBackground(Color.yellow);
      
      ButtonGroup group = new ButtonGroup();

      group.add (one);
      group.add (two);
      group.add (three);
      group.add (four);
      group.add (five);
      group.add (six);
      group.add (seven);

            

      EOptionListener listener = new EOptionListener();

      one.addActionListener (listener);
      two.addActionListener (listener);
      three.addActionListener (listener);
      four.addActionListener (listener);
      five.addActionListener (listener);
      six.addActionListener (listener);
      seven.addActionListener (listener);

      add (prompt);

      add (one);
      add (two);
      add (three);
      add (four);
      add (five);
      add (six);
      add (seven);
      

      setBackground (Color.yellow);

      setPreferredSize (new Dimension(300, 200));

   }

 

   //*****************************************************************

   //  Represents the listener for the radio buttons

   //*****************************************************************

   private class EOptionListener implements ActionListener

   {

      //--------------------------------------------------------------

      //  Calls the method to process the option for which radio

      //  button was pressed.

      //--------------------------------------------------------------

      public void actionPerformed (ActionEvent event)

      {

         Object source = event.getSource();

 

         if (source == one)
         {
            Main.inputTransaction();
            
            
            
         }
          
            
         
         else if (source == two)
            {
                Main.listTransaction();
                
            }

               

         else if (source == three)

            {   
                Main.listCheck();

            }
         else if (source == four)
         {
             Main.listDeposit();
         }
         else if (source == five)
         {
             Main.listservice();
         }
         else if (source == six)
         {
             Main.readfile();
         }
         else if (source == seven)
         {
             Main.writefile();
         }
         
      }

   }
   public static void processCheck(double transAmt)        
   {
       check.setServiceCharge(0.15);
       check.setBalance(transAmt, transcode);
       message1 = "Transaction: check in amount " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---charge $0.15\n" +
                    "Total Service Charge: " + fmt.format(check.getServiceCharge());
       if (check.getBalance() < 500 && flag == false)
       {
            check.setServiceCharge(5.00);
            flag = true;
            message1 = "Transaction: check in amount " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---Charge $0.15\n" +
                    "Service Charge : Below $500 ---Charge $5.00\n" +
                    "Total Service Charge: " + fmt.format(check.getServiceCharge());
            if (check.getBalance()< 50)
            {
             message1 = "Transaction: check in amount " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---Charge $0.15\n" +
                    "Service Charge : Below $500 ---Charge $5.00\n" +
                    "Warning: Balance below $50\n" +
                    "Total Service Charge: " + fmt.format(check.getServiceCharge());
                    
             if (check.getBalance()<0)
             {
                 check.setServiceCharge(10.00);
                 message1 = "Transaction: check in amount " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---Charge $0.15\n" +
                    "Service Charge : Below $500 ---Charge $5.00\n" +
                    "Warning: Balance below $50\n" +
                    "Service Charge: Below $0 ---charge $10\n" +
                    "Total Service Charge: " + fmt.format(check.getServiceCharge());
             }
            }
                    
       }
       else if (check.getBalance()< 50)
       {
           message1 = "Transaction: check in amount " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---Charge $0.15\n" +
                    "Warning: Balance below $50\n" +
                   "Total Service Charge: " + fmt.format(check.getServiceCharge());
           if(check.getBalance()< 0)
           {
            check.setServiceCharge(10.00);
            message1 = "Transaction: check in amount " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---charge $0.15\n" +
                    "Warning: Balance below $50\n" +
                    "Service Charge: Below $0 ---charge $10\n" +
                    "Total Service Charge: " + fmt.format(check.getServiceCharge());
           
            }
       }
       else if(check.getBalance()< 0)
       {
           check.setServiceCharge(10.00);
           message1 = "Transaction: check in amount " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---charge $0.15\n" +
                    "Warning: Balance below $50\n" +
                    "Service Charge: Below $0 ---charge $10\n" +
                    "Total Service Charge: " + fmt.format(check.getServiceCharge());
           
       }
   }
   public static void processDeposit(double transAmt)

   {
       check.setServiceCharge(0.10);
       check.setBalance(transAmt, transcode);
       message2 = "Transaction: Deposit in amount " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---charge $0.10\n" +
                    "Total Service Charge: "+fmt.format(check.getServiceCharge());
       
   }

}

