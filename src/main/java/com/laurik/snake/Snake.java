

package com.laurik.snake;

import javax.swing.JFrame;

public class Snake {

    public static void main(String[] args) {
        
        GUI window = new GUI();
        window.setSize(800, 800); //dimensiunile ferestrei
        window.setVisible(true); // deschidem fereastra 
        window.setTitle("Snake Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}
