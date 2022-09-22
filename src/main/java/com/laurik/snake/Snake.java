

package com.laurik.snake;

public class Snake {

    public static void main(String[] args) {
        
        GUI window = new GUI();
        window.setSize(800, 800); //dimensiunile ferestrei
        window.setVisible(true); // deschidem fereastra 
        window.setTitle("Snake Game");
        window.moveSnake(100, 100);
        
    }
}
