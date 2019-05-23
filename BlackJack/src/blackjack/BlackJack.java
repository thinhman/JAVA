
package blackjack;

import java.applet.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class BlackJack 
{
    
    public static JFrame F;
    public static boolean flag = false;
   
     public static Player p1 , d1 = new Player(0);
    public static PlaySound play1;
   
    public static void main(String[] args) throws InterruptedException
    {
        String ba = "";
        int bal = 0;
        JTextField field1 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Please enter how much money you want to convert to coins!"));
        panel.add(field1);
        field1.addAncestorListener(new SetFocus());
       
        int result = JOptionPane.showConfirmDialog(null, panel, "Test",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION)
       {
                    ba =field1.getText();
                    bal = Integer.parseInt(ba);
                    p1 = new Player (bal);
                    
                   
        F = new JFrame("BlackJack");
        F.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        JPanel Panel = new BlackJackPanel();
        Panel.setLayout(null);
        F.getContentPane().add(Panel);
        F.setResizable(false);
        F.pack();
        F.setLocationRelativeTo(null);
        F.setVisible(true);
         File sound = new File ("Dean Martin - Ain't That a Kick in the Head.wav");
         try
        {
                      play1.myPlay(sound);
                      
        } catch (InterruptedException ie) 
        {
                System.out.println(ie);
        } 
                    
      }
        
         
         //BlackJackPanel.timer.start();
        
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
    
   
   
}
