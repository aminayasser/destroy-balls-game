/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import com.sun.prism.paint.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author Amina
 */
public class Madrab extends JPanel{
    public Point pos=new Point();
    public int x,y;
    public int speed;
    public String img;
    public int score;
    
    public Madrab ()
    {  
       img="C:\\Users\\Amina\\Documents\\NetBeansProjects\\Ch8Threads\\rectangle.png";
        pos.x=5;
        pos.y=5;
        speed=10;
    }

    void mover() 
    {
        this.pos.x+=speed;
    }
    
    void movel()
    {
        this.pos.x-=speed;
    }
    void moveup()
    {
        this.pos.y-=speed;
    }
    void movedown()
    {
        this.pos.y+=speed;
    }
    
}
