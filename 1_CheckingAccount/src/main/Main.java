package main;
import javax.swing.JOptionPane;
import java.text.*;
/**
 *
 * @author thinh_nguyen
 */
public class Main

{
    public static String message0, message1, message2;
    public static NumberFormat fmt = NumberFormat.getCurrencyInstance();
    public static int transcode;
    public static double transAmt;
    public static boolean flag;
    public static CheckingAccount check;
    
   public static void main (String[] args)

   {
      String initalstr, codestr, transtr;
      int again;
      double inital;
      initalstr = JOptionPane.showInputDialog ("Enter the Inital Balance: ");
      inital = Double.parseDouble(initalstr);
      check = new CheckingAccount(inital);
      
        do 

      {  
         codestr = JOptionPane.showInputDialog ("Enter trans code: ");
         transcode = Integer.parseInt(codestr);
         
         if (transcode == 1)
         {
           
            transtr = JOptionPane.showInputDialog ("Enter the trans amount: ");
            transAmt = Double.parseDouble(transtr);
            processCheck(transAmt);
            JOptionPane.showMessageDialog (null, message1);
            
            
         }
         else if (transcode == 2)
         {
             transtr = JOptionPane.showInputDialog ("Enter the trans amount: ");
             transAmt = Double.parseDouble(transtr);
             processDeposit(transAmt);
             JOptionPane.showMessageDialog (null, message2);
         }
         else if (transcode == 0)
         {
          break;
         }

         again = JOptionPane.showConfirmDialog (null, "Do Another?");

      }

      while (again == JOptionPane.YES_OPTION);
      
      //check.setBalance(transAmt, transcode);
      message0 = "Transaction: End\n" +

                  "Current Balance: "+fmt.format(check.getBalance())+"\n" +

                  "Total Service Charge: "+fmt.format(check.getServiceCharge()) + "\n" +
                  "Final Balance: " + fmt.format(check.getBalance()- check.getServiceCharge());
              
      
             JOptionPane.showMessageDialog (null, message0);
    


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

