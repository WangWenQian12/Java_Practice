
package fan11;

import java.util.*;

public class Fan {
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;  
    
    private int speed ;
    private boolean on ;
    private double radius ;
    String color ;
    
    Fan(){
        speed = SLOW;
        on = false;
        radius = 5;
        color = "blue";
    }
    
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    public int getSpeed(){
        return speed;
    }
    public void setOn(boolean newOn){
        on=newOn;
    }
    public boolean getOn(){
        return on;
    }
    public void setRadius(double newRadius){
        radius=newRadius;
    }
    public double getRadius(){
        return radius;
    }
    public void setColor(String newColor){
        color = newColor;
    }
    public String getColor(){
        return color;
    }
    public String toString(){
        if(on==false){
            return "fan is off."+"\nThe color is "+getColor()
                    +"\nThe radius is "+getRadius();              
        }
        else{
            return "The speed is "+getSpeed()
                    +"\nThe color is "+getColor()
                    +"\nThe radius is "+getRadius();
        }
    }      
       
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        
        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        
        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);
        
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
    
}
