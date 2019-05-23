/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author thinh_nguyen
 */
public class CheckingAccount

{

 

      private double balance;

      private double totalServiceCharge;

 

      public CheckingAccount(double initialBalance)

      {

            balance = initialBalance;

            totalServiceCharge = 0.00;

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

