
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
    public void run() {// este obligatoriu acest run atunci and exinzi clasa TimerTask
        //System.out.println("Timer runing");
        int x = gui.getPositionX();
        int y = gui.getPositionY();
        
        
        if( x >= 800){
             gui.resetPositionX(0); 
             //System.out.println("Margina");
        }
        else if (x <= 0) 
             gui.resetPositionX(800); 
        
        
        if( y >= 800)
            gui.resetPositionY(0); 
        else if (y <= 0) 
              gui.resetPositionY(800);  
      
        if (lastKey == 40)//in jos
             gui.moveSnake(gui.getPositionX(), gui.getPositionY()+10);
        else if (lastKey == 38)// in sus
             gui.moveSnake(gui.getPositionX(), gui.getPositionY()-10);
        else if (lastKey == 39)//dreapta
             gui.moveSnake(gui.getPositionX() + 10, gui.getPositionY());
         else if (lastKey == 37)//stanga
             gui.moveSnake(gui.getPositionX() - 10, gui.getPositionY());
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()>=37 && e.getKeyCode()<=40){
       if((lastKey == 40) && e.getKeyCode() != 38)
           lastKey = e.getKeyCode();
       
       else if((lastKey == 38) && e.getKeyCode() != 40)
           lastKey = e.getKeyCode();
        
        else if((lastKey == 37) && e.getKeyCode() != 39)
           lastKey = e.getKeyCode();
        
        else if((lastKey == 39) && e.getKeyCode() != 37)
           lastKey = e.getKeyCode();
       
        else if(lastKey == 0)
            lastKey = e.getKeyCode();
        
        }
        //System.out.println(lastKey);
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
    
}
