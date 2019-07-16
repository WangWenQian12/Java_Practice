
package triangle11;

import java.util.*;

class SimpleGeometricObject{
    private String color = "white";
    private boolean filled;
    private Date dateCreated;
    
    public SimpleGeometricObject(){
        dateCreated = new Date();
    }
    public SimpleGeometricObject(String color,boolean filled){
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public boolean isFilled(){
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
    public String toString(){
        return "created on "+dateCreated+"\ncolor: "+color
                + "and filled: "+filled;
    }
    
}

public class Triangle extends SimpleGeometricObject {
    private double side1;
    private double side2;
    private double side3;
    
    Triangle(){
        side1 = side2 = side3 = 1.0;
    }
    Triangle(double side1,double side2,double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    public double getSide1(){
        return side1;
    }
    public double getSide2(){
        return side2;
    }
    public double getSide3(){
        return side3;
    }
    public double getArea(){
        double p = (side1+side2+side3)/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    } 
    public double getPerimeter(){
        return side1+side2+side3;
    } 
    public String toString(){
        return "Triangle:side1 = "+side1+"\nside2 = "+side2+"\nside3 = "+side3;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter three sides:");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();
        
        System.out.println("Enter a color");
        String color = input.next();
        
        System.out.println("Triangle is filled(true or false)?");
        boolean filled = input.nextBoolean();
        
        Triangle triangle = new Triangle(side1,side2,side3);
        triangle.setColor(color);
        triangle.setFilled(filled);
        
        System.out.println(triangle.toString());
        System.out.println("The area is :"+triangle.getArea());
        System.out.println("The perimeter is :"+triangle.getPerimeter());
        System.out.println("The color is :"+triangle.getColor());
        System.out.println("The filled is :"+triangle.isFilled());     
    }
    
}
