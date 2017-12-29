/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JOptionPane;

/**
 *
 * @author Amina
 */
public class Ball implements Runnable{
    public Point pos=new Point();
    public Color CurrentColor;
    public int Speed;
    public String imgPath;
    public int BallRadius=4;
    
    public Ball(int S, int x, int y)
    {  
        imgPath="C:\\Users\\Amina\\Documents\\NetBeansProjects\\Ch8Threads\\ball.jpg";
        Speed=S;
        pos.x=x;
        pos.y=y;
    }
    
        public  void move(int width)
    {
          pos.y-=Speed;
        if (pos.y+50>width)
        {
            Speed= -Speed;
        }
        if (pos.y<0)
        {
            Speed= -Speed;
        }
    }
  
   @Override
    public void run
        () 
    {
        for (int i=0;i<400;i++)
        {
           pos.y-=Speed;
          try {
             Thread.sleep(10);
            } 
          catch (InterruptedException ex)
            {}
        }
    }
        }
              
                