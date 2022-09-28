
package com.laurik.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class GUI extends JFrame {
     ArrayList<Position> bodyList = new ArrayList<Position>();
     Random rand = new Random();
     int randomX = rand.nextInt(80) * 10;
     int randomY = rand.nextInt(80) * 10;
     Position mar = new Position(randomX,randomY);
     Timer timer = new Timer();//executam la fiecare 0.1 sec o miscare sarpelui 
     JPanel panel = new JPanel(); 
     JLabel jText = new JLabel("Start Game");
     int scor = 0;
     JLabel jScor; 
     
     
    
    public GUI (){
        super();
        jScor = new JLabel("Scor: " + String.valueOf(scor));
        bodyList.add(new Position(400,400));
        
        this.add(jText);
        jText.setFont(new Font("Calibri", Font.BOLD, 40));
        jText.setForeground(Color.GREEN);
        jText.setBounds(300, 370, 500, 40);
        
        this.add(jScor);
        jScor.setFont(new Font ("Calibri", Font.BOLD, 20));
        jScor.setForeground(Color.WHITE);
        jScor.setBounds(670, 740, 500, 20);
        
        this.setLayout(null);
        getContentPane().setBackground( Color.black );
        
        UpdateTask updateTask = new UpdateTask(this);//this reprezinta GUI ul curent
        timer.schedule(updateTask, 10, 100);// executa periodic un task
        addKeyListener(updateTask); // este un listener care asculta daca s a aparat ceva de la tastatura
        
        
            }
    
    void addSegment(){
        bodyList.add(new Position(1000,1000));
    }
    
    void moveSnake(int x, int y){
        jText.setVisible(false);
        bodyList.get(0).movePosition(x, y);
        for (int i = 1; i < bodyList.size(); i++){
                bodyList.get(i).movePosition(bodyList.get(i-1).getLastX(),bodyList.get(i-1).getLastY());
         }
      
        if((bodyList.get(0).getX() == mar.getX()) &&(bodyList.get(0).getY() == mar.getY()) ){
            
            scor ++;
            jScor.setText("Scor: " + String.valueOf(scor));
            addSegment();
            randomX = 10 + rand.nextInt(78) * 10;
            randomY = 30 + rand.nextInt(76) * 10;
            System.out.println(randomX + " "+ randomY );
            mar.movePosition(randomX, randomY);
        }
       detectColision();
       
        repaint();
    }
    
    void detectColision(){
        int headX = bodyList.get(0).getX();
        int headY = bodyList.get(0).getY();
        
        for(int i = 1 ; i < bodyList.size() ; i++ ){
       
            if(( headX == bodyList.get(i).getX()) && ( headY == bodyList.get(i).getY())){
                System.out.println("Coleziune detectata");
                timer.cancel();//opreste timmerul ce muta la fiecare 0.01 s sarpele
                jText.setText("GAME OVER");
                jText.setForeground(Color.RED);
                jText.setVisible(true);
                break;
            }
            }
                
        }
    
        
    int getPositionX(){
        return bodyList.get(0).getX() ;
    }
    
    int getPositionY(){
       return bodyList.get(0).getY() ;
    }
    
    void resetPositionX(int x){
      bodyList.get(0).movePosition(x,bodyList.get(0).getY());
    }
    
    void resetPositionY(int y){
        bodyList.get(0).movePosition(bodyList.get(0).getX(),y);
    }
    
    public void paint(Graphics g){
        super.paint(g);//paint din clasa mostenita (JFrame)redeseneaza fereastra cand este necesar
        for (int i=0; i < bodyList.size();i++ ){
            g.drawOval(bodyList.get(i).getX(),bodyList.get(i).getY(),10,10);
            g.setColor(Color.white);
            g.fillOval(bodyList.get(i).getX(), bodyList.get(i).getY(), 10, 10);
         }
        
        g.drawOval(mar.getX(), mar.getY(), 10,10 );
            g.setColor(Color.red);
            g.fillOval(mar.getX(), mar.getY(), 10,10);
                 
    }

 
}
