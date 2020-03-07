import java.util.Scanner;

public class pow {

    public static int myPow(int x,int y){
        int sum = 1;
        for(int i=0;i<y;i++){
            sum *= x;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("Please inter the number:");
        int x= input.nextInt();
        System.out.println("Please inter the count:");
        int y = input.nextInt();

        System.out.println(myPow(x,y));
    }
}
