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
public class Deposit extends Transaction 
{
    
    private double checkAmt;
    
    private double cashAmt;

 

    public Deposit(int tId, double tAmt, int tCount, double check, double cash) 
    {

        super(tId, tCount, tAmt);
        
        checkAmt = check;
        
        cashAmt = cash;

    }

 

    
    public double getCheckAmt() {

        return checkAmt;

    }
    public double getCashAmt() {

        return cashAmt;

    }

    
}
