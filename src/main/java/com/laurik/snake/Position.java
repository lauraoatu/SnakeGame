
package com.laurik.snake;

public class Position {
    int x , y ;
    int lastX, lastY ;
    public Position (int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void movePosition (int x ,int y ){
        lastX = this.x;
        lastY = this.y;
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x ;
    }
     public int getY(){
        return y ;
    }
     public int getLastX(){
        return lastX ;
    }
     public int getLastY(){
        return lastY ;
    }

    
}
