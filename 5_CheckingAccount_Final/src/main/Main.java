package main;
//import javax.swing.JOptionPane;
import java.text.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.Collections;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import static main.EOptionsPanel.codestr;
import static main.EOptionsPanel.transtr;



/**
 *
 * @author thinh_nguyen
 */
public class Main 

{
    public static String message0, message1, message2, checkstr;
    public static NumberFormat fmt = NumberFormat.getCurrencyInstance();
    public static int transcode, ID, checknum, vectorIndex = 0;
    public static double transAmt, amount;
    public static boolean flag, flag1, flag2 = false;
    public static CheckingAccount check;
    public static Transaction transAct;
    public static JFrame frame, frame1;
    public static Check Checks;
    public static Deposit Deposits;
    public static String filename = "";
    public static CheckingAccount[] clist;
    public static JTextArea ta;
    public static Vector<CheckingAccount> Accounts; 
    
    public static void main (String[] args)
   {
      //String initalstr, name;
      //double inital;
      //name = JOptionPane.showInputDialog ("Enter the Account Name: ");
      //initalstr = JOptionPane.showInputDialog ("Enter the Inital Balance: ");
      //inital = Double.parseDouble(initalstr);
      //check = new CheckingAccount(inital, name);
      //Accounts.addElement(check);
      //vectorIndex++;
      //frame = new JFrameL ("Checking Account Options");
      //frame.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
      Accounts = new Vector<CheckingAccount>();
      EOptionsPanel frame = new EOptionsPanel("Checking Account Operations");
      ta = new JTextArea(10,50);
      ta.setFont(new Font("Monospaced",Font.PLAIN, 12));
      frame.getContentPane().add (ta);
      frame.pack();
      frame.setVisible(true);
     


   }

   public static void inputTransaction()
   {
       if (check.getBalance() < 500)
       {
           flag = true;
       }
       flag2 = false;
       //frame.setVisible(false);
        int index;
        codestr = JOptionPane.showInputDialog ("0->End\n"+"1->Check\n"+"2->Deposit\n"+"Enter Trans code:");
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
        checkstr = JOptionPane.showInputDialog ("Enter the Check Number: ");
        checknum = Integer.parseInt(checkstr);
        transtr = JOptionPane.showInputDialog ("Enter the transaction amount: ");
        transAmt = Double.parseDouble(transtr);   
        index = check.gettransCount();
        //transAct = new Transaction(index,transcode,transAmt);
        Checks = new Check (index,transAmt, transcode, checknum);
        check.addTrans(Checks);
        processCheck(transAmt);
           
           
           JOptionPane.showMessageDialog (null, message1);
           
        }
        else if (transcode == 2)
          {
            String ch = "", ca = "";
            double chNum = 0.0 , caNum = 0.0;
            //frame.setVisible(false);
            
                JTextField field1 = new JTextField("");
                JTextField field2 = new JTextField("");
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Cash"));
                panel.add(field1);
                panel.add(new JLabel("Check"));
                panel.add(field2);
                field1.addAncestorListener(new SetFocus());
                int result = JOptionPane.showConfirmDialog(null, panel, "Test",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION)
                {
                    ca =field1.getText();
                    ch =field2.getText();
                    chNum = Double.parseDouble(ch);
                    caNum = Double.parseDouble(ca);
                }
                transAmt = chNum + caNum;
                index = check.gettransCount();
                Deposits = new Deposit (index,transAmt, transcode, chNum, caNum);
            
            
            check.addTrans(Deposits);
             processDeposit(transAmt);
             JOptionPane.showMessageDialog (null, message2);
             
          }
        
        
        
        //frame.setVisible(true);
   }
   private static class SetFocus implements AncestorListener 
   {



    public void ancestorAdded(AncestorEvent e) 
    {
        JComponent component = e.getComponent();
        component.requestFocusInWindow();

   
    }

    public void ancestorMoved(AncestorEvent e) {
    }

    public void ancestorRemoved(AncestorEvent e) {
    }
   }
   
   public static void listTransaction()
   {
      //frame.setVisible(false);
      JTextArea text = new JTextArea();
      String message = "";
      
      text.setOpaque(false);
      text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
      text.setBorder(null);
      message+="Account:" + check.getName() + "\n";
      message += "Balance: " + fmt.format(check.getBalance()) + "\n";
      message+="Total Service Charge: " + fmt.format(check.getServiceCharge()) +"\n\n";
      message+="List of all Transactions:\n\n";
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
      ta.setText(message);
      //JOptionPane.showMessageDialog(null, text);
      //frame.setVisible(true);
   }
 
   public static void listDeposit()
   {
       //frame.setVisible(false);
      JTextArea text = new JTextArea();
      String message = "";
      
      text.setOpaque(false);
      text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
      text.setBorder(null);
      message += "Listing all Deposit for " + check.getName() + " :\n\n";
      message+="ID    Type      Checks   Cash       Amount\n\n";
       for (int num = 0; num < check.gettransCount(); num++)
       {
           if (check.getTrans(num).getTransId() == 2)
           {
               Transaction t = check.getTrans(num);
               Deposit d = (Deposit)t;
               message+= String.format ("%-5d %-9s %-8s %-6s %10s\n" , num, "Deposit", fmt.format(d.getCheckAmt()), fmt.format(d.getCashAmt()) ,fmt.format(check.getTrans(num).getTransAmount()));
           }
       }
       ta.setText(message);
       //JOptionPane.showMessageDialog(null, text);
       //frame.setVisible(true);
   }
   
   public static void listCheck()
   {
       //frame.setVisible(false);
      JTextArea text = new JTextArea();
      String message = "";
      
      text.setOpaque(false);
      text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
      text.setBorder(null);
      message += "Listing all Check for " + check.getName() + "\n\n";
      message+="ID    Check     Amount\n";
       for (int num = 0; num < check.gettransCount(); num++)
       {
           
   
           if (check.getTrans(num).getTransId() == 1)
           {
               Transaction t = check.getTrans(num);
               Check c = (Check)t;
               
                message+= String.format ("%-5d %-5d %10s\n" , num, c.getCheckNumber() ,fmt.format(check.getTrans(num).getTransAmount()));
           }
       }
       ta.setText(message);
       //JOptionPane.showMessageDialog(null, text);
       //frame.setVisible(true);
   }
   public static void listservice()
   {
       frame.setVisible(false);
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
       frame.setVisible(true);
   }
   
   public static void readfile()
   {
       
       chooseFile(1);
       try
       {
           FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fis);
                        Accounts = (Vector<CheckingAccount>)in.readObject();
			in.close();
                        for (int i = 0; i < Accounts.size(); i++)
                        {
                            if (Accounts.get(i).getTrans(i).getTransAmount() == 5 && Accounts.get(i).getTrans(i).getTransId() == 3)
                            {
                                //flag1 = true;
                            }
                            
                        }
                        flag2 = true;
       }
       catch(ClassNotFoundException e)	
                 { 
                     System.out.println(e);
                 }

                catch (IOException e) 
                 { 
                     System.out.println(e);
                 }
   }
   public static void writefile() 
   {  
        chooseFile(2);
      	try
		{
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fos);
                       out.writeObject(Accounts);
                        out.close();
                        flag2 = true;
		
		}	
	catch(IOException e)	
                { 
                     System.out.println(e);
                }
 
   }
   public static void addAccount()
   {
       //CheckingAccount newAccount;
       flag1 = false;
       ta.setText(null);
       String newName, newBalStr;
       double newBalance;
       newName = JOptionPane.showInputDialog ("Enter the Account Name: ");
       newBalStr = JOptionPane.showInputDialog ("Enter the Inital Balance: ");
       newBalance = Double.parseDouble(newBalStr);
       check = new CheckingAccount(newBalance, newName,flag1);
       Accounts.addElement(check);
       vectorIndex++;
       
   }
   public static void findAccount()
   {
       String findName,name, message;
       findName = JOptionPane.showInputDialog ("Enter the Account's name: ");
       for (int index=0; index != Accounts.size(); index++)
	{
	  CheckingAccount temp = Accounts.elementAt(index);
					
	  // check on the name of the element
	  if (findName.equals(temp.getName()))
		{
			name = temp.getName();
			check = temp;
			// display chosen chemical element
      			message = "Found Account for " + name;
                        ta.setText(message);         
		}
	}
       
   }
   public static void chooseFile(int ioOption) 
   {  
      int status;      
                
      
      JFileChooser chooser = new JFileChooser();
      if (ioOption == 1)
          status = chooser.showOpenDialog (null);
      else
          status = chooser.showSaveDialog (null);
      if (status == JFileChooser.APPROVE_OPTION)
      {
          File file = chooser.getSelectedFile();
          filename = file.getPath();
      }
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
       check.setBalance(0.15, 3);
       transAct = new Transaction (index, 3, 0.15);
       check.addTrans(transAct);
       check.setBalance(transAmt, transcode);
       if (check.getBalance() < 500 && check.getChargefee() == false)
            {
            index = check.gettransCount();
            transAct = new Transaction(index,3,5.00);
            check.addTrans(transAct);
            check.setBalance(5.00,3);
            flag = false;
            flag1 = true;
            check.setChargefee(flag1);
            }
           if (check.getBalance() < 0)
           {
               index = check.gettransCount();
               transAct = new Transaction(index,3,10.00);
               check.setBalance(10.00, 3);
               check.addTrans(transAct);
            
           }
       message1 =   check.getName() + " account-\n" +
                    "Transaction: Check #"+ Checks.getCheckNumber() + " in the amount of " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---charge $0.15\n" +
                    "Total Service Charge: " + fmt.format(check.getServiceCharge());
       if (check.getBalance() < 500 && flag == false)
       {
            check.setServiceCharge(5.00);
            flag = true;
            message1 = check.getName() + " account-\n" +
                    "Transaction: Check #"+ Checks.getCheckNumber() + " in the amount of " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---Charge $0.15\n" +
                    "Service Charge : Below $500 ---Charge $5.00\n" +
                    "Total Service Charge: " + fmt.format(check.getServiceCharge());
            if (check.getBalance()< 50)
            {
             message1 = check.getName() + " account-\n" +
                    "Transaction: Check #"+ Checks.getCheckNumber() + " in the amount of " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---Charge $0.15\n" +
                    "Service Charge : Below $500 ---Charge $5.00\n" +
                    "Warning: Balance below $50\n" +
                    "Total Service Charge: " + fmt.format(check.getServiceCharge());
                    
             if (check.getBalance()<0)
             {
                 check.setServiceCharge(10.00);
                 message1 = check.getName() + " account-\n" +
                    "Transaction: Check #"+ Checks.getCheckNumber() + " in the amount of " + fmt.format(transAmt) + "\n" +
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
           message1 = check.getName() + " account-\n" +
                    "Transaction: Check #"+ Checks.getCheckNumber() + " in the amount of " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Check ---Charge $0.15\n" +
                    "Warning: Balance below $50\n" +
                   "Total Service Charge: " + fmt.format(check.getServiceCharge());
           if(check.getBalance()< 0)
           {
            check.setServiceCharge(10.00);
            message1 = check.getName() + " account-\n" +
                    "Transaction: Check #"+ Checks.getCheckNumber() + " in the amount of " + fmt.format(transAmt) + "\n" +
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
           message1 = check.getName() + " account-\n" +
                    "Transaction: Check #"+ Checks.getCheckNumber() + " in the amount of " + fmt.format(transAmt) + "\n" +
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
       check.setBalance(.10,3);
       transAct = new Transaction (index, 3, 0.10);
       check.addTrans(transAct);
       check.setBalance(transAmt, transcode);
       message2 =   check.getName() + " account-\n" +
                    "Transaction: Deposit in the amount of " + fmt.format(transAmt) + "\n" +
                    "Current Balance: " + fmt.format(check.getBalance()) + "\n" +
                    "Service Charge : Deposit ---charge $0.10\n" +
                    "Total Service Charge: "+fmt.format(check.getServiceCharge());
       
   }

 

}

