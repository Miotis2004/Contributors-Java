/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ronnie_joubert_cs230_unit1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Ronnie Joubert
 */
public class TimerClass implements ActionListener
{
    int count = 0;
    Timer t;
    
    public TimerClass ()
    {
        t = new Timer(1, this);
        t.start();
    }
    
    public void StopTimer()
    {
        t.stop();
        System.out.println("Search took " + count + " ms.");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        count = count + 1;
    }

}
