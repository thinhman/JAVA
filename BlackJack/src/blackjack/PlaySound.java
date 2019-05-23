/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Thinhman
 */
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


 class PlaySound 
 {
    public static void myPlay(File url) throws InterruptedException
    {

        try
           {
                //long delay = 5;
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(url));
                clip.start();
                Thread.sleep(clip.getMicrosecondLength()/1000);

            } catch (Exception e) 
            {
                System.out.println(e);
            }
    }
}
