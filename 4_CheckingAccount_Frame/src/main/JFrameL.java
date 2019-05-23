/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Thinhman
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JFrameL extends JFrame implements WindowListener
{
    
    /** Creates a new instance of JFrameL */
    public JFrameL(String title) {
        super(title);
        addWindowListener(this);
    }
    public void windowClosing(WindowEvent e) 
    {
        System.out.println("WindowListener method called: windowClosed.");
        String message = "";
        int confirm;
            //This will only be seen on standard output.
        if (!Main.flag2)
        {
            message += "Would you like to save your file?";
            confirm = JOptionPane.showConfirmDialog(null, message);
             if (confirm == JOptionPane.YES_OPTION)
             {
                 Main.writefile();
             }
        }
        
       
        
       
       this.setVisible(false);
       System.exit(0);
    }

    public void windowClosed(WindowEvent e) {    }

    public void windowOpened(WindowEvent e) {    }

    public void windowIconified(WindowEvent e) {    }

    public void windowDeiconified(WindowEvent e) {    }

    public void windowActivated(WindowEvent e) {    }

    public void windowDeactivated(WindowEvent e) {    }    
}

