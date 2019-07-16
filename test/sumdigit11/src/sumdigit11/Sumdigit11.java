
package sumdigit11;

import java.util.Scanner;

public class Sumdigit11 {
    public static int sumDigits(long n){
        int sum=0;
        int count=0;
        while(n>0){
            sum += n%10;
            n = n/10;
            count++;            
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = input.nextInt();
        int ret = sumDigits(number);
        System.out.println(ret);
        
        
    }
    
}
