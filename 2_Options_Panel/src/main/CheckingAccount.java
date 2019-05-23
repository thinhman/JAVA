/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.*;
/**
 *
 * @author thinh_nguyen
 */
public class CheckingAccount

{

      
      private ArrayList <Transaction> transList = new ArrayList();  // keeps a list of Transaction objects for the account

      private double balance;

      private double totalServiceCharge;

      private  int transCount;   // the count of Transaction objects and used as the ID for each transaction 

                           

      public  void addTrans( Transaction newTrans)   // adds a transaction object to the transList
      {
          transList.add(newTrans);
          transCount++;
      }

 

      public int gettransCount()  //returns the current value of transCount
      {
          return transCount;
      }

 

      public  Transaction getTrans(int i) // returns the i-th Transaction object in the list
      {
          return transList.get(i);
      }

     

 

      public CheckingAccount(double initialBalance)

      {

            balance = initialBalance;

            totalServiceCharge = 0.00;
            
            transCount = 0;
            
            
            
            

      }

 

      public double getBalance()

      {

            return balance;

      }

 

      public void setBalance(double transAmt, int tCode)

      {

            if(tCode == 1)
            {
            balance = balance - transAmt;
            
            }
            else if(tCode == 2)
            {    
            balance = balance + transAmt;
            }
            else if (tCode == 0)
            {
            balance -= totalServiceCharge;
            }
            
      }

 

      public double getServiceCharge()

      {

            return totalServiceCharge;

      }

 

        public void setServiceCharge(double currentServiceCharge)

      {

            totalServiceCharge += currentServiceCharge;

      }

}

