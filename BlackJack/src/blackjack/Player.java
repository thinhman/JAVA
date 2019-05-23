

package blackjack;
import java.util.*;
/**
 *
 * @author Thinhman
 */
public class Player 
{
    
    private  int balance;
    private  int bet;
    private int hand, count;
    public ArrayList <Cards> handList = new ArrayList();
    public Player(int bal)
    {
        hand = 0;
        balance = bal;
        bet = 0;
        count = 0;
    }
    public void setbet(int money)
    {
        bet = money;
    }
    public void addbet(int money)
    {
        bet += money;
    }
     public int getBet ()
    {
        return bet;
    }
      public void setbalance (int money)
    {
        balance += money;
    }
       public int getbalance ()
    {
        return balance;
    }
     public int getHand ()
    {
        return hand;
    }
      public void addHand (int value)
    {
        hand += value;
    }
       public void setHand (int value)
    {
        hand = value;
    }
    public void addList (Cards card)
    {
        if (card.getValue() == 11)
            
        {
            
            count++;
        }
        handList.add(card);
    }
    public void setList ()
    {
        handList = new ArrayList();
    }
        public int getCount ()
    {
        return count;
    }
        public void addcount (int value)
    {
        count += value;
    }
    public void setcount (int value)
    {
        count += value;
    }
        
}
