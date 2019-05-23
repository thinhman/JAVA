/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.*;
import javax.swing.*;
import java.util.Collections;
import java.io.*;
import java.lang.Object.*;

public class Deck 
{
  private  ArrayList <Cards> cList = new ArrayList() ;
  public  String[] imageList = { "Pics/2_of_clubs.svg.png"                 ,"Pics/2000px-Playing_card_diamond_2.svg.png" ,"Pics/2000px-Playing_card_heart_2_svg.png" ,"Pics/2_of_spades.svg.png",
                                       "Pics/2000px-Playing_card_club_3.svg.png" ,"Pics/2000px-Playing_card_diamond_3.svg.png" ,"Pics/2000px-Playing_card_heart_3_svg.png" ,"Pics/2000px-Playing_card_spade_3.svg.png",
                                       "Pics/819px-Playing_card_club_4.svg.png"  ,"Pics/download.png"                          ,"Pics/2000px-Playing_card_heart_4_svg.png" ,"Pics/2000px-Playing_card_spade_4.svg.png",
                                       "Pics/1000px-Playing_card_club_5.svg.png" ,"Pics/2000px-Playing_card_diamond_5.svg.png" ,"Pics/2000px-Playing_card_heart_5_svg.png" ,"Pics/5_of_spades.svg.png",
                                       "Pics/6_of_clubs.svg.png"                 ,"Pics/2000px-Playing_card_diamond_6.svg.png" ,"Pics/2000px-Playing_card_heart_6_svg.png" ,"Pics/2000px-Playing_card_spade_6.svg.png",
                                       "Pics/7_of_clubs.svg.png"                 ,"Pics/2000px-Playing_card_diamond_7.svg.png" ,"Pics/2000px-Playing_card_heart_7_svg.png" ,"Pics/2000px-Playing_card_spade_7.svg.png",
                                       "Pics/8_of_clubs.svg.png"                 ,"Pics/2000px-Playing_card_diamond_8.svg.png" ,"Pics/2000px-Playing_card_heart_8_svg.png" ,"Pics/8_of_spades.svg.png",
                                       "Pics/2000px-Playing_card_club_9.svg.png" ,"Pics/2000px-Playing_card_diamond_9.svg.png" ,"Pics/Playing_card_heart_9_svg.png"        ,"Pics/9_of_spades.svg.png",
                                       "Pics/10_of_clubs.svg.png"                ,"Pics/2000px-Playing_card_diamond_10.svg.png","Pics/2000px-Playing_card_heart_10_svg.png","Pics/10_of_spades.svg.png",
                                        "Jack_of_clubs2.svg.png"                 ,"Pics/download1.png"                         ,"Pics/Jack_of_hearts2_svg.png"             ,"Pics/download2.png",
                                       "Pics/Queen_of_clubs2.svg.png"            ,"Pics/Queen_of_diamonds2.svg.png"            ,"Pics/Queen_of_hearts2_svg.png"            ,"Pics/Queen_of_spades2.svg.png",
                                        "Pics/King_of_clubs2.svg.png"            ,"Pics/King_of_diamonds2.svg.png"             ,"Pics/King_of_hearts2_svg.png"             ,"Pics/King_of_spades2.svg.png",
                                       "Pics/2000px-Playing_card_club_A.svg.png" ,"Pics/Ace_of_diamonds.svg.png"               ,"Pics/2000px-Playing_card_heart_A_svg.png" ,"Pics/2000px-Playing_card_spade_A.svg.png",};
  public  Cards card, card1, card2, card3;
  public  int count, num;
  public Deck()
  {
      count = 0;
      num = 0;
      setDeck();
  }
  public  void addCard(Cards newCard)
  {
          
          cList.add(newCard);
          
          
  }
  /*public static Cards getCard(int i) // returns the i-th Transaction object in the list
  {
          return cList.get(i);
  }*/
  public Cards drawCard()
  {
      //System.out.println("draw card");
      return cList.get(num++);
      
      
  }
  public void setDeck()
  {
          
          
           if(count < 4)
          {
            card = new Cards (imageList[count], 2 ,"two");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 2 ,"two");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 2 ,"two");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 2 ,"two");
            addCard(card);
            count++;
          }
            
          
           
            if(count >= 4 && count < 8)
          {
            card = new Cards (imageList[count], 3 ,"three");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 3 ,"three");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 3 ,"three");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 3 ,"three");
            addCard(card);
            count++;
          }
             if(count >= 8 && count < 12)
          {
            card = new Cards (imageList[count], 4 ,"four");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 4 ,"four");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 4 ,"four");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 4 ,"four");
            addCard(card);
            count++;
          }
              if(count >= 12 && count < 16)
          {
            card = new Cards (imageList[count], 5 ,"five");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 5 ,"five");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 5 ,"five");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 5 ,"five");
            addCard(card);
            count++;
          }
                  if(count >= 16 && count < 20)
          {
            card = new Cards (imageList[count], 6 ,"six");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 6 ,"six");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 6 ,"six");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 6 ,"six");
            addCard(card);
            count++;
          }
             if(count >= 20 && count < 24)
          {
            card = new Cards (imageList[count], 7 ,"seven");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 7 ,"seven");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 7 ,"seven");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 7 ,"seven");
            addCard(card);
            count++;
          }
              if(count >= 24 && count < 28)
          {
            card = new Cards (imageList[count], 8 ,"eight");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 8 ,"eight");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 8 ,"eight");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 8 ,"eight");
            addCard(card);
            count++;
          }
            if(count >= 28 && count < 32)
          {
            card = new Cards (imageList[count], 9 ,"nine");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 9 ,"nine");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 9 ,"nine");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 9 ,"nine");
            addCard(card);
            count++;
          }
            if(count >= 32 && count < 36)
          {
            card = new Cards (imageList[count], 10 ,"ten");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 10 ,"ten");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 10 ,"ten");
           addCard(card);
            count++;
            card = new Cards (imageList[count], 10 ,"ten");
            addCard(card);
            count++;
          }
            if(count >= 36 && count < 40)
          {
            card = new Cards (imageList[count], 10 ,"jack");
            addCard(card);;
            count++;
            card = new Cards (imageList[count], 10 ,"jack");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 10 ,"jack");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 10 ,"jack");
            addCard(card);
            count++;
          }
            if(count >= 40 && count < 44)
          {
            card = new Cards (imageList[count], 10 ,"queen");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 10 ,"queen");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 10 ,"queen");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 10 ,"queen");
            addCard(card);
            count++;
          }
            if(count >= 44 && count < 48)
          {
            card = new Cards (imageList[count], 10 ,"king");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 10 ,"king");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 10 ,"king");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 10 ,"king");
            addCard(card);
            count++;
          }
            if(count >= 48 && count < 52)
          {
            card = new Cards (imageList[count], 11 ,"ace");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 11 ,"ace");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 11 ,"ace");
            addCard(card);
            count++;
            card = new Cards (imageList[count], 11 ,"ace");
            addCard(card);
            count++;
          }
          Collections.shuffle(cList);  
          
      
  }
}
