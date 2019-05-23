/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class Cards 
{
  private  int value;
  private String Image;
  private  String ID;
  
  public Cards(String path, int val, String id)
  {
      value = val;
      Image =  path;
      ID = id;
  }
  public int getValue()
  {
      return value;
  }
  public void setValue(int val)
  {
      value = val;
  }
  public String getImage()
  {
      return Image;
  }
  public String getID()
  {
      return ID;
  }
}
