
package com.laurik.snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
    
public class UpdateTask extends TimerTask implements KeyListener {
    public GUI gui;
    int lastKey;
    
    
    
    public UpdateTask(GUI gui){
        super();
        this.gui = gui;
        
    }
    @Override
    public void run() {// este obligatoriu cest run atunci and exinzi clasa TimerTask
        System.out.println("Timer runing");
        int x = gui.getPositionX();
        int y = gui.getPositionY();
        int currentPositionX = gui.getPositionX();
        int currentPositionY = gui.getPositionY();
        
        if( currentPositionX >= 800)
            currentPositionX = 0 ;
        else if (gui.getPositionX() <= 0) 
            currentPositionX = 800 ;
        
        
        if( currentPositionY >= 800)
            currentPositionY = 0 ; 
        else if (gui.getPositionX() <= 0) 
            currentPositionX = 800 ;
      
        if (lastKey == 40)//in jos
             gui.moveSnake(x, y+10);
        else if (lastKey == 38)// in sus
             gui.moveSnake(x, y-10);
         else if (lastKey == 39)//dreapta
             gui.moveSnake(x+10, y);
         else if (lastKey == 37)//stanga
             gui.moveSnake(x-10, y);
         }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if((e.getKeyCode()== 40) || (e.getKeyCode()== 39) || (e.getKeyCode()== 38) || (e.getKeyCode()== 37 ))
            lastKey = e.getKeyCode();
        System.out.println(lastKey);
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
}
