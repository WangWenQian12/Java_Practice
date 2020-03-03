
import java.util.Scanner;
public class Palindrome {

    public static boolean isPalindrome(int num){
        int sum = 0;
        int value = 0;
        int number = num;
        while(number != 0) {
            //value += number % 10;
            sum = sum * 10 + number % 10;
            number = number/10;
        }
        if(sum == num){
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

        if(isPalindrome(num)){
            System.out.println(num+" is a palindrome.");
        }
        else{
            System.out.println(num+" is not a palindrome.");
        }

    }
}
