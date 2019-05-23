
package blackjack;




import static blackjack.BlackJack.play1;
import javax.swing.*;

import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.BufferedImage.*;
import java.io.File;

class BlackJackPanel extends JPanel 
{
    
   private final int WIDTH = 720, HEIGHT = 370;
   private final int DELAY = 50, IMAGE_SIZE = 35;
   private ImageIcon image, image1, image2, image3, image4, image5, ph1,back, ph2, ph3, ph4, ph5,dh1,dh2,dh3,dh4,dh5;
   public JButton Deal, Hit, Stay,newHand,bal, coin1, coin5, coin10,coin25,coin100;
   private static boolean soundFlag = true, flag = false, flag1 = false, dealt = false, flag2 = false;
   public static Timer timer, timer2, timer3, timer4, timer5, timer6;
   public static String url = "Dean Martin - Ain't That a Kick in the Head.wav";
   public static int x1 = 295, y1 = -100, x2=380 ,y2=-100,x3= 390,y3 = -100,x4 = 400,y4= -100,x5= 485,y5= -100, a1 = 295, 
                     b1 = -100,a2 = 380, b2 = -100, a3 =390  , b3= -200, a4= 400, b4 = -200 ,stage = 0, AI = 0;
   public Deck PlayingCards;
   public static Cards c1;
   public static JLabel Background, hand1;
   private Thread thread;
   public static String temp;
   public static PlaySound play;
   public File sound = new File ("CardDealing.wav");
   public File sound1 = new File ("cardshuffle.wav");
   public File sound2 = new File ("CoinDrop.wav");

  
   public BlackJackPanel() 
   {
       
       timer = new Timer(DELAY, new Card1Listener());
       timer2 = new Timer(DELAY, new Card2Listener());
       timer3 = new Timer(DELAY, new Card3Listener());
       timer4 = new Timer(DELAY, new Card4Listener());
       timer5 = new Timer(DELAY, new Card5Listener());
       timer6 = new Timer(DELAY, new Card6Listener());
       /*image = new ImageIcon ("blackjack-table.jpg");
       Background = new JLabel(image);
       Background.setBounds(0, 0,730,380);*/
       
       setPreferredSize (new Dimension(WIDTH, HEIGHT));
       
       Deal = new JButton("Deal");
       Deal.setBounds(0, 50, 100, 20);
       Deal.addActionListener(new BlackJackListener());
       add(Deal);
       Hit = new JButton("Hit");
       Hit.setBounds(0, 75 , 100, 20);
       Hit.addActionListener(new BlackJackListener());
       add(Hit);
       Stay = new JButton("Stay");
       Stay.setBounds(0, 100, 100, 20);
       Stay.addActionListener(new BlackJackListener());
       add(Stay);
       newHand = new JButton("New Hand");
       newHand.setBounds(0, 125, 100, 20);
       newHand.addActionListener(new BlackJackListener());
       add(newHand);
       bal = new JButton("Balance");
       bal.setBounds(0, 150, 100, 20);
       bal.addActionListener(new BlackJackListener());
       add(bal);
       
       //adding the coins buttons to add to the bet
       image1 = new ImageIcon("coin1.jpg");
       coin1 = new JButton(image1);
       coin1.setBorder(BorderFactory.createEmptyBorder());
       coin1.setContentAreaFilled(false);
       coin1.setFocusable(false);
       coin1.setBounds(526, 320, 40, 38);
       coin1.addActionListener(new BlackJackListener());
       add(coin1);
       image2 = new ImageIcon("coin5.jpg");
       coin5 = new JButton(image2);
       coin5.setBorder(BorderFactory.createEmptyBorder());
       coin5.setContentAreaFilled(false);
       coin5.setFocusable(false);
       coin5.setBounds(568, 308, 40, 38);
       coin5.addActionListener(new BlackJackListener());
       add(coin5);
       image3 = new ImageIcon("coin10.jpg");
       coin10 = new JButton(image3);
       coin10.setBorder(BorderFactory.createEmptyBorder());
       coin10.setContentAreaFilled(false);
       coin10.setFocusable(false);
       coin10.addActionListener(new BlackJackListener());
       coin10.setBounds(609, 297, 37, 40);
       add(coin10);
       image4 = new ImageIcon("coin25.jpg");
       coin25 = new JButton(image4);
       coin25.setBorder(BorderFactory.createEmptyBorder());
       coin25.setContentAreaFilled(false);
       coin25.setFocusable(false);
       coin25.addActionListener(new BlackJackListener());
       coin25.setBounds(645, 282, 38, 35);
       add(coin25);
       image5 = new ImageIcon("coin100.jpg");
       coin100 = new JButton(image5);
       coin100.setBorder(BorderFactory.createEmptyBorder());
       coin100.setContentAreaFilled(false);
       coin100.setFocusable(false);
       coin100.addActionListener(new BlackJackListener());
       coin100.setBounds(680, 259, 39, 40);
       add(coin100);
       //add(Background);
      
     
            
   }
   /*public synchronized start()
   {
       thread = new Thread(this);
       thread.start();
   }*/
   public void cardDeal()
   {
       try
                  {
                      play1.myPlay(sound);
                      
                   } catch (InterruptedException ie) 
                    {
                        System.out.println(ie);
                    } 
   }
   public void coinDrop()
   {
       try
                  {
                      play1.myPlay(sound2);
                      
                   } catch (InterruptedException ie) 
                    {
                        System.out.println(ie);
                    } 
   }
  public void paintComponent (Graphics page)
   {
      super.paintComponent (page);
      back = new ImageIcon ("blackjack-table.jpg");
      if (back != null)
     {
         back.paintIcon(this,page,0,0);
         
     }
     if (ph1 !=null)
     {
         ph1.paintIcon (this, page, x1, y1);
         
     }
     if (ph2 !=null)
     {
         ph2.paintIcon (this, page, x2, y2);
         
     }
     if(ph3 != null)
     {
         ph3.paintIcon(this, page, x3, y3);
     }
     if(ph4 != null)
     {
         ph4.paintIcon(this, page, x4, y4);
     }
     if(ph5 != null)
     {
         ph5.paintIcon(this, page, x5, y5);
     }
     if (dh1 != null)
     {
         dh1.paintIcon(this, page, a1, b1);
     }
     if (dh2 != null)
     {
         dh2.paintIcon(this, page, a2, b2);
     }
     if (dh3 != null)
     {
         dh3.paintIcon(this, page, a3, b3);
     }
     
     
     
   }
  private class Card1Listener implements ActionListener
  {
      public void actionPerformed (ActionEvent event)
      {
              //x+=15;
          if(stage == 0)
          {
              y1+=25;
              if(y1<225)
              {
                  repaint();
              }
              else
              {
                  
                  timer.stop();
                  repaint();
                  cardDeal();
                  timer2.start();
                  
              }
              
                      
                  
          }
          else if ( stage == 1)
          {
              y3+=25;
              if(y3<225)
              {
                  repaint();
              }
              else
              {
                  cardDeal();
                  if (BlackJack.p1.getHand() > 21)
                 {
                     if (BlackJack.p1.getCount() > 0)
                     {
                         BlackJack.p1.addHand(-10);
                         BlackJack.p1.setcount(-1);
                     }
                     else if (BlackJack.p1.getCount() == 0)
                     {
                          BlackJack.p1.setbalance((BlackJack.p1.getBet()*-1));
                          JOptionPane.showMessageDialog (null, "You Lost!");
                     }
                 
                      
                 }
                if (BlackJack.p1.getbalance() <= 0)
                {
                    JOptionPane.showMessageDialog (null, "You Have no more money!");
                }
                  repaint();
                  timer.stop();
              }      
          }
          else if (stage == 2)
          {
               y4+=25;
              if(y4<225)
              {
                  repaint();
              }
              else
              {
                  cardDeal();
                  if (BlackJack.p1.getHand() > 21)
                 {
                  if (BlackJack.p1.getCount() > 0)
                     {
                         BlackJack.p1.addHand(-10);
                         BlackJack.p1.setcount(-1);
                     }
                     else if (BlackJack.p1.getCount() == 0)
                     {
                          BlackJack.p1.setbalance((BlackJack.p1.getBet()*-1));
                          JOptionPane.showMessageDialog (null, "You Lost!");
                     }
                 }
                if (BlackJack.p1.getbalance() <= 0)
                {
                    JOptionPane.showMessageDialog (null, "You Have no more money!");
                }
                  repaint();
                  timer.stop();
              }  
          }
          else if (stage == 3)
          {
               y5+=25;
              if(y5<225)
              {
                  repaint();
              }
              else
              {
                 cardDeal();
                  if (BlackJack.p1.getHand() > 21)
                 {
                    if (BlackJack.p1.getCount() > 0)
                     {
                         BlackJack.p1.addHand(-10);
                         BlackJack.p1.setcount(-1);
                     }
                     else if (BlackJack.p1.getCount() == 0)
                     {
                          BlackJack.p1.setbalance((BlackJack.p1.getBet()*-1));
                          JOptionPane.showMessageDialog (null, "You Lost!");
                     }
                      
                 }
                if (BlackJack.p1.getbalance() <= 0)
                {
                    JOptionPane.showMessageDialog (null, "You Have no more money!");
                }
                  repaint();
                  timer.stop();
              }  
            
          }
          
              
              
          
      }
  }
  private class Card2Listener implements ActionListener
  {
      public void actionPerformed (ActionEvent event)
      {
          //a+=15;
          y2+=25;
          if(y2<225)
              {
                  repaint();
              }
              else
              {
                  cardDeal();
                  timer2.stop();
                  repaint();
                  timer3.start();
              }        
      }
      
  }
  private class Card3Listener implements ActionListener
  {
      public void actionPerformed (ActionEvent event)
      {
          //a+=15;
          b1+=25;
          if(b1<25)
              {
                  repaint();
              }
              else
              {
                  cardDeal();
                  timer3.stop();
                  repaint();
                  timer4.start();
              }        
      }
      
  }
  private class Card4Listener implements ActionListener
  {
      public void actionPerformed (ActionEvent event)
      {
          //a+=15;
          b2+=25;
          if(b2<25)
              {
                  repaint();
              }
              else
              {
                 cardDeal();
                  timer4.stop();
                  repaint();
                  if (BlackJack.p1.getHand() > 21)
                  {
                    if (BlackJack.p1.getCount() > 0)
                     {
                         BlackJack.p1.addHand(-10);
                     }
                  
                     else if (BlackJack.p1.getCount() == 0)
                     {
                          BlackJack.p1.setbalance((BlackJack.p1.getBet()*-1));
                          JOptionPane.showMessageDialog (null, "You Lost!");
                     }
                      
                  }
                  if (BlackJack.p1.getbalance() <= 0)
                  {
                    JOptionPane.showMessageDialog (null, "You Have no more money!");
                  }
                  
              }        
      }
      
  }
  private class Card5Listener implements ActionListener
  {
      public void actionPerformed (ActionEvent event)
      {
          //a+=15;
          b3+=25;
          if(b3<25)
              {
                  repaint();
              }
              else
              {
                 cardDeal();
                  if (BlackJack.d1.getHand() > 21)
                    {
                        
                            if (BlackJack.p1.getCount() > 0)
                            {
                                BlackJack.p1.addHand(-10);
                            }
                            else if(BlackJack.p1.getCount() == 0)
                            {
                                BlackJack.p1.setbalance(BlackJack.p1.getBet());
                                JOptionPane.showMessageDialog (null, "You Won!");
                            }
                        
                    }
                  if (BlackJack.d1.getHand() < 17 )
                {
                 c1 = PlayingCards.drawCard();
                 BlackJack.d1.addList(c1);
                 BlackJack.d1.addHand(c1.getValue());
                ImageIcon imageIcon6 = new ImageIcon(c1.getImage()); // load the image to a imageIcon
                Image image6 = imageIcon6.getImage(); // transform it 
                Image newimg6 = image6.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
                dh4 =  new ImageIcon(newimg6);
                a1= 145;
                a2= 230;
                a3= 315;
                repaint();
                timer6.start();
                 
                }
                else if (BlackJack.d1.getHand() > 17 && BlackJack.d1.getHand() <= 21 )
                {
                    if (BlackJack.p1.getHand() > BlackJack.d1.getHand())
                    {
                        BlackJack.p1.setbalance(BlackJack.p1.getBet());
                        JOptionPane.showMessageDialog (null, "You Won!");
                    }
                    else if (BlackJack.p1.getHand() < BlackJack.d1.getHand())
                    {
                        BlackJack.p1.setbalance((BlackJack.p1.getBet()*-1));
                        JOptionPane.showMessageDialog (null, "You Lost!");
                        if (BlackJack.p1.getbalance() <= 0)
                        {
                            JOptionPane.showMessageDialog (null, "You Have no more money!");
                        }
                    }
                    else if (BlackJack.p1.getHand() == BlackJack.d1.getHand())
                    {
                        JOptionPane.showMessageDialog (null, "Its a Tie!");
                        flag2 = true;
                    }
                }
                else if (BlackJack.d1.getHand() > 21)
                {
                    BlackJack.p1.setbalance(BlackJack.p1.getBet());
                    JOptionPane.showMessageDialog (null, "You Won!");
                }
                  timer5.stop();
                  repaint();
                  
                  
              }        
      }
      
  }
   private class Card6Listener implements ActionListener
  {
      public void actionPerformed (ActionEvent event)
      {
          //a+=15;
          b4+=25;
          if(b4<25)
              {
                  repaint();
              }
              else
              {
                  cardDeal();
                  if (BlackJack.d1.getHand() > 21)
                    {
                        if (BlackJack.p1.getCount() > 0)
                            {
                            BlackJack.p1.addHand(-10);
                            }
                            else if(BlackJack.p1.getCount() == 0)
                            {
                                BlackJack.p1.setbalance(BlackJack.p1.getBet());
                                JOptionPane.showMessageDialog (null, "You Won!");
                            }
                    }
                  timer6.stop();
                  repaint();
                  
                 
                  
              }        
      }
      
  }
  
   private class BlackJackListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Updates the position of the image 
      //  whenever the timer fires an action event.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
          Object source = event.getSource();
        
         if(source == Deal)
         {
             if(BlackJack.p1.getBet()!=0)
             {
                 if (dealt == false)
                {
                 PlayingCards = new Deck();
              
              c1 = PlayingCards.drawCard();
              BlackJack.p1.addList(c1);
              BlackJack.p1.setHand(c1.getValue());
              ImageIcon imageIcon = new ImageIcon(c1.getImage()); // load the image to a imageIcon
              Image image = imageIcon.getImage(); // transform it 
              Image newimg = image.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
              ph1 = new ImageIcon(newimg);  // transform it back
              c1 = PlayingCards.drawCard();
              BlackJack.p1.addList(c1);
              BlackJack.p1.addHand(c1.getValue());
              ImageIcon imageIcon2 = new ImageIcon(c1.getImage()); // load the image to a imageIcon
              Image image2 = imageIcon2.getImage(); // transform it 
              Image newimg2 = image2.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
              ph2 =  new ImageIcon(newimg2);
              c1 = PlayingCards.drawCard();
              BlackJack.d1.addList(c1);
              BlackJack.d1.addHand(c1.getValue());
              temp = c1.getImage();
              ImageIcon imageIcon1 = new ImageIcon("Pics/529371_original.jpg"); // load the image to a imageIcon
              Image image1 = imageIcon1.getImage(); // transform it 
              Image newimg1 = image1.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
              dh1 = new ImageIcon(newimg1);  // transform it back
              c1 = PlayingCards.drawCard();
              BlackJack.d1.addList(c1);
              BlackJack.d1.addHand(c1.getValue());
              ImageIcon imageIcon3 = new ImageIcon(c1.getImage()); // load the image to a imageIcon
              Image image3 = imageIcon3.getImage(); // transform it 
              Image newimg3 = image3.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
              dh2 =  new ImageIcon(newimg3);
              
              repaint();
              timer.start();
              dealt = true;
                }
                 
             }
             else if (BlackJack.p1.getBet()==0)
             {
                 JOptionPane.showMessageDialog (null, "Place a bet first!");
             }
             if (BlackJack.d1.getHand() == 21 && BlackJack.p1.getHand() == 21) 
             {
                 flag2 = true;
                 JOptionPane.showMessageDialog (null, "You both got blackjack");
             }
             else if (BlackJack.d1.getCount() > 0 && BlackJack.d1.getHand() == 21)
             {
                 BlackJack.p1.setbalance((BlackJack.p1.getBet()*-1));
                 JOptionPane.showMessageDialog (null, "Sorry Dealer got BlackJack you lost");
             }
             else if (BlackJack.p1.getCount() > 0 && BlackJack.p1.getHand() == 21)
             {
                 BlackJack.p1.setbalance((BlackJack.p1.getBet()*2));
                 JOptionPane.showMessageDialog (null, "YOU GOT BLACKJACK! YOU WON TWICE THE AMOUNT OF YOUR BET!");
             }
           
           
         }
         else if (source == Hit)
         {
             if (flag2 == false)
             {
                 if (dealt == true && stage <= 4 )
             {
                  if (BlackJack.p1.getHand() < 21)
                 {
                     stage++;
                 if (stage == 1)
                {
                 c1 = PlayingCards.drawCard();
                 BlackJack.p1.addList(c1);
                 BlackJack.p1.addHand(c1.getValue());
                ImageIcon imageIcon2 = new ImageIcon(c1.getImage()); // load the image to a imageIcon
                Image image2 = imageIcon2.getImage(); // transform it 
                Image newimg2 = image2.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
                ph3 =  new ImageIcon(newimg2);
                repaint();
                x1= 220;
                x2= 305;
                timer.start();
                 
                }
             else if( stage == 2)
             {
                 c1 = PlayingCards.drawCard();
                 BlackJack.p1.addList(c1);
                 BlackJack.p1.addHand(c1.getValue());
                 ImageIcon imageIcon3 = new ImageIcon(c1.getImage()); // load the image to a imageIcon
                Image image3 = imageIcon3.getImage(); // transform it 
                Image newimg3 = image3.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
                ph4 =  new ImageIcon(newimg3);
                repaint();
                x1= 145;
                x2= 230;
                x3= 315;
                timer.start();
                
            }
           else if ( stage == 3)
            {
                c1 = PlayingCards.drawCard();
                BlackJack.p1.addList(c1);
                BlackJack.p1.addHand(c1.getValue());
                ImageIcon imageIcon4 = new ImageIcon(c1.getImage()); // load the image to a imageIcon
                Image image4 = imageIcon4.getImage(); // transform it 
                Image newimg4 = image4.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
                ph5 =  new ImageIcon(newimg4);
                repaint();
                x5 = 485;
                timer.start();
               
               
                
            }
            else if (stage == 4)
            {
              JOptionPane.showMessageDialog (null, "Sorry you can only have 5 cards MAX");
            }
             
             }
             else if (BlackJack.p1.getHand() > 21)
             {
                 BlackJack.p1.setbalance((BlackJack.p1.getBet()*-1));
                  JOptionPane.showMessageDialog (null, "You Lost!");
                      
             }
             if (BlackJack.p1.getbalance() <= 0)
             {
                    JOptionPane.showMessageDialog (null, "You Have no more money!");
             }
             }
             
                 
                   
         }
           
             
            
         }
         else if (source == Stay)
         {
          flag2 = true;
          AI++;
          if (BlackJack.d1.getHand() > BlackJack.d1.getHand())
          {
               BlackJack.p1.setbalance((BlackJack.p1.getBet()*-1));
                  JOptionPane.showMessageDialog (null, "You Lost!");
          }
          else
          {
              if (BlackJack.d1.getHand() < 17)
          {
              if (AI == 1)
             {
                 c1 = PlayingCards.drawCard();
                 BlackJack.d1.addList(c1);
                 BlackJack.d1.addHand(c1.getValue());
                ImageIcon imageIcon7 = new ImageIcon(temp); // load the image to a imageIcon
                Image image7 = imageIcon7.getImage(); // transform it 
                Image newimg7 = image7.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
                dh1 =  new ImageIcon(newimg7);
                ImageIcon imageIcon5 = new ImageIcon(c1.getImage()); // load the image to a imageIcon
                Image image5 = imageIcon5.getImage(); // transform it 
                Image newimg5 = image5.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
                dh3 =  new ImageIcon(newimg5);
                a1= 220;
                a2= 305;
                repaint();
                timer5.start();
                
                
             }  
          }
          else if (BlackJack.d1.getHand() >= 17)
          {
              if (BlackJack.p1.getHand() > BlackJack.d1.getHand())
              {
                  BlackJack.p1.setbalance(BlackJack.p1.getBet());
                  JOptionPane.showMessageDialog (null, "You Won!");
              }
              else if (BlackJack.p1.getHand() < BlackJack.d1.getHand())
              {
                  ImageIcon imageIcon8 = new ImageIcon(temp); // load the image to a imageIcon
                    Image image8 = imageIcon8.getImage(); // transform it 
                    Image newimg8 = image8.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
                    dh1 =  new ImageIcon(newimg8);
                    repaint();
                  BlackJack.p1.setbalance((BlackJack.p1.getBet()*-1));
                  JOptionPane.showMessageDialog (null, "You Lost!");
                   if (BlackJack.p1.getbalance() <= 0)
                    {
                            JOptionPane.showMessageDialog (null, "You Have no more money!");
                    }
              }
              else if (BlackJack.p1.getHand() == BlackJack.d1.getHand())
              {
                        JOptionPane.showMessageDialog (null, "Its a Tie!");
                        flag2 = true;
              }
            }
          }
          
             
         }
         else if(source == newHand)
         {
             flag = false;
             flag1 = false;
             dealt = false;
             x1 = 295;
             y1 = -100;
             x2=380;
             y2=-100;
             x3= 390;
             y3 = -100;
             x4 = 400;
             y4= -100;
             x5= 485;
             y5= -100;
             a1 = 295;
             b1 = -100;
             a2 = 380;
             b2 = -100;
             a3 =390;
             b3= -500;
             a4= 400;
             b4 = -500;
             repaint();
             stage = 0;
             AI = 0;
             flag2 = false;
             BlackJack.d1.setHand(0);
             BlackJack.p1.setHand(0);
             BlackJack.p1.setbet(0);
             BlackJack.p1.setList();
             BlackJack.d1.setList();
             try
                  {
                      play1.myPlay(sound1);
                      
                   } catch (InterruptedException ie) 
                    {
                        System.out.println(ie);
                    } 
             
             
         }
         else if (source == bal)
         {
             String message = "Your Balance is: ";
             message += BlackJack.p1.getbalance();
             message +=  "\nYour current bet is:";
             message += BlackJack.p1.getBet();
             message +=  "\nYour current Hand is:";
             message += BlackJack.p1.getHand();
             JOptionPane.showMessageDialog (null, message );
         }
         else if (source == coin1)
         {
            
              if (BlackJack.p1.getbalance() <= 0)
              {
                JOptionPane.showMessageDialog (null, "You Have no more money!");
              }
               if ((BlackJack.p1.getBet()+1) <= BlackJack.p1.getbalance())
              {
                  coinDrop();
                BlackJack.p1.addbet(1);
              }
               else if((BlackJack.p1.getBet()+1) > BlackJack.p1.getbalance())
               {
                   JOptionPane.showMessageDialog (null, "Not enough coins!");
               }
         }
         else if (source == coin5)
         {
             
              if (BlackJack.p1.getbalance() <= 0)
              {
                JOptionPane.showMessageDialog (null, "You Have no more money!");
              }
               if ((BlackJack.p1.getBet()+5) <= BlackJack.p1.getbalance())
              {
                  coinDrop();
                BlackJack.p1.addbet(5);
              }
               else if((BlackJack.p1.getBet()+5) > BlackJack.p1.getbalance())
               {
                   JOptionPane.showMessageDialog (null, "Not enough coins!");
               }
         }
         else if (source == coin10)
         {
             
              if (BlackJack.p1.getbalance() <= 0)
              {
                JOptionPane.showMessageDialog (null, "You Have no more money!");
              }
               if ((BlackJack.p1.getBet()+10) <= BlackJack.p1.getbalance())
              {
                  coinDrop();
                BlackJack.p1.addbet(10);
              }
               else if((BlackJack.p1.getBet()+10) > BlackJack.p1.getbalance())
               {
                   JOptionPane.showMessageDialog (null, "Not enough coins!");
               }
         }
         else if (source == coin25)
         {
             
              if (BlackJack.p1.getbalance() <= 0)
              {
                JOptionPane.showMessageDialog (null, "You Have no more money!");
              }
               if ((BlackJack.p1.getBet()+25) <= BlackJack.p1.getbalance())
              {
                  coinDrop();
                BlackJack.p1.addbet(25);
              }
               else if((BlackJack.p1.getBet()+25) > BlackJack.p1.getbalance())
               {
                   JOptionPane.showMessageDialog (null, "Not enough coins!");
               }
         }
         else if (source == coin100)
         {
             
              if (BlackJack.p1.getbalance() <= 0)
              {
                JOptionPane.showMessageDialog (null, "You Have no more money!");
              }
               if ((BlackJack.p1.getBet()+100) <= BlackJack.p1.getbalance())
              {
                  coinDrop();
                  
                BlackJack.p1.addbet(100);
              }
               else if((BlackJack.p1.getBet()+100) > BlackJack.p1.getbalance())
               {
                   JOptionPane.showMessageDialog (null, "Not enough coins!");
               }
         }
         
        
         
      }
   }
   
    
}

