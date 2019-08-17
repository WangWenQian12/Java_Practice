import java.util.Scanner;

public class CheckPow {

    public static boolean checkPow(int num){
        if((num&(num-1))==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please inter the number:");
        int num = input.nextInt();
        System.out.println(checkPow(num));
    }
}
