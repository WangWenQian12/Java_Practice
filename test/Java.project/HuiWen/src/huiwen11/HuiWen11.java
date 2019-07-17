
package huiwen11;

import java.util.Scanner;

public class HuiWen11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a three-digits number :");
        int number = input.nextInt();
        int number1 = number%10;
        int number2 = number/100;
        if(number1==number2){
            System.out.println("This number is a palindrome.");
        }
        else{
            System.out.println("This number is not a palindrome.");
        }
        
    }
    
}
