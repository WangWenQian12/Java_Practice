import java.util.Scanner;

public class CheckPow {

    public static boolean checkPow(int num){
        while(0==num%2){
            num /= 2;
        }
        if(num==1){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please inter the number:");
        int num = input.nextInt();
        System.out.println(checkPow(num));
    }
}
