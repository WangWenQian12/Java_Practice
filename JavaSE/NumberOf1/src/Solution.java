import java.util.Scanner;

public class Solution {

    // 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

    public static int NumberOf1(int val) {
        int count  = 0;
        while(val != 0){
            count++;
            val = val & (val - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        System.out.println (NumberOf1 (n));
    }
}