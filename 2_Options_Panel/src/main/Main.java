package main;
//import javax.swing.JOptionPane;
import java.text.*;
import java.awt.*;
import javax.swing.*;
import static main.EOptionsPanel.codestr;
import static main.EOptionsPanel.transtr;

/**
 *
 * @author thinh_nguyen
 */
public class Main

{
    public static String message0, message1, message2;
    public static NumberFormat fmt = NumberFormat.getCurrencyInstance();
    public static int transcode, ID;
    public static double transAmt, amount;
    public static boolean flag, flag1;
    public static CheckingAccount check;
    public static Transaction transAct;
    public static JFrame frame;
    public static void main (String[] args)
    

   {
      String initalstr;
      double inital;
      initalstr = JOptionPane.showInputDialog ("Enter the Inital Balance: ");
      inital = Double.parseDouble(initalstr);
      check = new CheckingAccount(inital);
      frame = new JFrame ("Choose Option");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      EOptionsPanel panel = new EOptionsPanel();
      frame.getContentPane().add (panel);
      frame.pack();
      frame.setVisible(true);
     


   }

   public static void inputTransaction()
   {
        frame.setVisible(false);
        int index;
        codestr = JOptionPane.showInputDialog ("Enter trans code: ");
        transcode = Integer.parseInt(codestr);
        if (transcode == 0)
            {
             message0 = "Transaction: End\n" +

                  "Current Balance: "+fmt.format(check.getBalance())+"\n" +

                  "Total Service Charge: "+fmt.format(check.getServiceCharge()) + "\n" +
                  "Final Balance: " + fmt.format(check.getBalance()- check.getServiceCharge());
              
      
             JOptionPane.showMessageDialog (null, message0);
             
            }
        
        
        else if (transcode == 1)
        {
           transtr = JOptionPane.showInputDialog ("Enter the transaction amount: ");
        transAmt = Double.parseDouble(transtr);   
        index = check.gettransCount();
        transAct = new Transaction(index,transcode,transAmt);
        check.addTrans(transAct);
           processCheck(transAmt);
           if (check.getBalance() < 500 && flag1 == false)
            {
            index = check.gettransCount();
            transAct = new Transaction(index,3,5.00);
            check.addTrans(transAct);
            flag1 = true;
            }
           if (check.getBalance() < 0)
           {
               index = check.gettransCount();
               transAct = new Transaction(index,3,10.00);
               check.addTrans(transAct);
            
           }
           
           JOptionPane.showMessageDialog (null, message1);
           
        }
        else if (transcode == 2)
          {
            transtr = JOptionPane.showInputDialog ("Enter the transaction amount: ");
            transAmt = Double.parseDouble(transtr);   
            index = check.gettransCount();
            transAct = new Transaction(index,transcode,transAmt);
            check.addTrans(transAct);
             processDeposit(transAmt);
             JOptionPane.showMessageDialog (null, message2);
          }
        
        
        
        frame.setVisible(true);
   }
   
   public static void listTransaction()
   {
       
      JTextArea text = new JTextArea();
      String message = "";
      
      text.setOpaque(false);
      text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
      text.setBorder(null);
      message+="List All Transaction\n\n";
      message+="ID        Type                   Amount\n";
      for (int num=0; num < check.gettransCount();num++)
      {  
        
         String type = "";
         transAct = check.getTrans(num);
         if (transAct.getTransId() == 1)
         {
             type = "Check";
         }
         else if (transAct.getTransId() == 2)
         {
             type = "Deposit";
         }
         else if (transAct.getTransId() == 3)
         {
             type = "Svc. Chrg.";
         }
         message += String.format("%-2d        %-10s            %7s\n", num,
                  type, fmt.format(transAct.getTransAmount()));
         
         
      }
      text.setText(message);
      JOptionPane.showMessageDialog(null, text);
   }
   public static void listDeposit()
   {
      JTextArea text = new JTextArea();
      String message = "";
      
      text.setOpaque(false);
      text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
      text.setBorder(null);
      message+="ID      Amount\n\n";
       for (int num = 0; num < check.gettransCount(); num++)
       {
           if (check.getTrans(num).getTransId() == 2)
           {
               message+= String.format ("%-2d  %10s\n" , num ,fmt.format(check.getTrans(num).getTransAmount()));
           }
       }
       text.setText(message);
       JOptionPane.showMessageDialog(null, text);
   }
   
   public static void listCheck()
   {
      JTextArea text = new JTextArea();
      String message = "";
      
      text.setOpaque(false);
      text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
      text.setBorder(null);
      message+="ID      Amount\n\n";
       for (int num = 0; num < check.gettransCount(); num++)
       {
           if (check.getTrans(num).getTransId() == 1)
           {
                message+= String.format ("%-2d  %10s\n" , num ,fmt.format(check.getTrans(num).getTransAmount()));
           }
       }
       text.setText(message);
       JOptionPane.showMessageDialog(null, text);
   }
   public static void listservice()
   {
      JTextArea text = new JTextArea();
      String message = "";
      
      text.setOpaque(false);
      text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
      text.setBorder(null);
      message+="ID      Amount\n\n";
       for (int num = 0; num < check.gettransCount(); num++)
       {
           if (check.getTrans(num).getTransId() == 3)
           {
               message+= String.format ("%-2d  %10s\n" , num ,fmt.format(check.getTrans(num).getTransAmount()));
           }
       }
       text.setText(message);
       JOptionPane.showMessageDialog(null, text);
   }
   public static int getTransCode()

   {
       return transcode;
   }

   public static double getTransAmt()

   {
       return transAmt;
   }

   public static void processCheck(double transAmt)        
   {
       
       int index;
       index =  check.gettransCount();
       check.setServiceCharge(0.15);
       transAct = new Transaction (index, 3, 0.15);
       check.addTrans(transAct);
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
       int index;
       index = check.gettransCount();
       check.setServiceCharge(0.10);
       transAct = new Transaction (index, 3, 0.10);
       check.addTrans(transAct);
       check.setBalance(transAmt, transcode);
       message2 = "Transaction: Deposit in amount " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---charge $0.10\n" +
                    "Total Service Charge: "+fmt.format(check.getServiceCharge());
       
   }

 

}

