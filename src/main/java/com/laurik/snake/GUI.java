
package com.laurik.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import javax.swing.JFrame;


public class GUI extends JFrame {
    int currentX = 400;
    int currentY = 400;
    
    public GUI (){
        super();
        getContentPane().setBackground( Color.black );
        Timer timer = new Timer();
        UpdateTask updateTask = new UpdateTask(this);//this reprezinta GUI ul curent
        timer.schedule(updateTask, 10, 100);// executa periodic un task
        addKeyListener(updateTask); // este un listener care asculta daca s a aparat ceva de la tastatura
    }
    void moveSnake(int x, int y){
        currentX = x;
        currentY = y;
        repaint();
    }
    
    int getPositionX(){
        return currentX;
    }
    
    int getPositionY(){
        return currentY;
    }
    
    int resetPositionX(){
        return currentX;
    }
    
    int resetPositionY(){
        return currentY;
    }
    
    public void paint(Graphics g){
        super.paint(g);//paint din clasa mostenita (JFrame)redeseneaza fereastra cand este necesar
        g.drawOval(currentX,currentY,10,10);
        g.setColor(Color.white);
        g.fillOval(currentX, currentY, 10, 10);
    }

 
}
