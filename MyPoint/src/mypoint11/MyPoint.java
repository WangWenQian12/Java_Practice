
package mypoint11;

public class MyPoint {
    double x=0;
    double y=0;
    MyPoint(){
        this.x=x;
        this.y=y;
    }
    MyPoint(double x,double y){
        this.x=x;
        this.y=y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double distance(double x,double y){
        return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
    }
    public double distance(MyPoint mypoint){
        return Math.sqrt((this.x-mypoint.getX())*(this.x-mypoint.getX())+(this.y-mypoint.getY())*(this.y-mypoint.getY()));
    }

    public static void main(String[] args) {
        MyPoint mypoint1 = new MyPoint(0,0);
        MyPoint mypoint2 = new MyPoint(10,30.5) ;
        System.out.println("The distance between ( "+mypoint1.getX()+" , "+mypoint1.getY()+" ) and ( "
                +mypoint2.getX()+" , "+mypoint2.getY()+" ) is "+mypoint1.distance(mypoint2));
        
    }
    
}
