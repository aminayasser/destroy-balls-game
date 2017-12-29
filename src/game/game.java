/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Amina
 */
public class game {
    /**
     * @param args the command line arguments
     */
     static int num=6;
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame jf=new JFrame();
        jf.setSize(600, 600);
        
        int result=JOptionPane.showConfirmDialog(null," It's a multiplayer game where two black boards distroys moving balls in 5 sec","start",JOptionPane.DEFAULT_OPTION);
        if(result== JOptionPane.OK_OPTION)
        {
            
        
        MovingBalls mb=new MovingBalls();
        mb.b.add(new Ball(40,4,30));
        mb.b.add(new Ball(10,50,70));
        mb.b.add(new Ball(4,500,150));
        mb.b.add(new Ball(79,300,400));
        mb.b.add(new Ball(39,320,120));
        mb.b.add(new Ball(49,120,300));
        
        finishtime ft= new finishtime(10);
        
        
        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        t1.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    }
}
