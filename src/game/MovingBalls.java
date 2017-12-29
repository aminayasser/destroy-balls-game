/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Amina
 */
public class MovingBalls extends JPanel implements Runnable{
   public ArrayList<Ball>b = new ArrayList<>(5);
   public Madrab Madrab=new Madrab();
   public Madrab M2= new Madrab();
   
    public MovingBalls()
    {
        setSize(600,600);
        Madrab.pos.x=320;
        Madrab.pos.y=340;
        M2.pos.x=220;
        M2.pos.y=240;
        this.addKeyListener(new keylist());
        
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                Madrab.mover();
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                Madrab.movel();
            }
            if(e.getKeyCode()== KeyEvent.VK_UP)
            {
                Madrab.moveup();
            }
            if(e.getKeyCode()== KeyEvent.VK_DOWN)
            {
                Madrab.movedown();
            }
            if(e.getKeyCode()==KeyEvent.VK_A)
            {
                M2.movel();
            }
            if(e.getKeyCode()==KeyEvent.VK_D)
            {
                M2.mover();
            }
            if(e.getKeyCode()==KeyEvent.VK_S)
            {
                M2.movedown();
            }
            if(e.getKeyCode()==KeyEvent.VK_W)
            {
                M2.moveup();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
       
        
        try
     {
        BufferedImage imgBall = ImageIO.read(new File(Madrab.img));
        g.drawImage(imgBall,Madrab.pos.x, Madrab.pos.y, null);
        
        BufferedImage imgBall1 = ImageIO.read(new File(M2.img));
        g.drawImage(imgBall1,M2.pos.x, M2.pos.y, null);
      }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Ball OneBall: b)
        
        { 
            g.fillOval(OneBall.pos.x,OneBall.pos.y, 50, 50);  //el ball
            if (Madrab.pos.distance(OneBall.pos.x, OneBall.pos.y)<=50)
            {  
                b.remove(OneBall);
                game.num--;
                Madrab.score++;
                if( game.num==0)
                {
                    int result=JOptionPane.showConfirmDialog(null," Madrab 1 wins with score "+Madrab.score,"Game Over",JOptionPane.DEFAULT_OPTION);
                    if( result==JOptionPane.OK_OPTION)
                    {
                        exit(0);
                    }
                }
                break;
            }
            if(M2.pos.distance(OneBall.pos.x, OneBall.pos.y)<=50)
            {
                b.remove(OneBall);
                game.num--;
                Madrab.score++;
                if( game.num==0)
                {
                    int result=JOptionPane.showConfirmDialog(null," Madrab 2 wins with score "+Madrab.score,"Game Over",JOptionPane.DEFAULT_OPTION);
                    if( result==JOptionPane.OK_OPTION)
                    {
                        exit(0);
                    }
                }
                break;
            }
        }
    }
    
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Ball OneBall: b)
        {
            OneBall.move(this.getWidth());
        }    
        
        
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
}
