/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8threads;

import static java.lang.System.exit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Amina
 */
public class finishtime
{  
    Timer t;
    
    public finishtime(int sec)
    {
       t=new Timer();
       t.schedule(new ToDo(), sec*1000);
    }
    
    class ToDo extends TimerTask
    {

        @Override
        public void run() 
        {
            JOptionPane.showMessageDialog(null," Time is out");
            if( JOptionPane.OK_OPTION==0)
            {
              exit(0);  
            }
            
            t.cancel();
        }
        
    }
}
