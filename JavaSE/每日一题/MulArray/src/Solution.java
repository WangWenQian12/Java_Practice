import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static int[] multiply(int[] A) {
        int[] arr = new int[A.length];
        for(int i = 0; i < A.length;i++){
            int res = 1;
            for(int j = 0; j < A.length;j++){
                if (i != j){
                    res *= A[j];
                }
            }
            arr[i] = res;
        }
        return arr;
    }

    public static void main(String[] args) {
         Scanner input = new Scanner (System.in);
         int n = input.nextInt ();
         int[] arr = new int[n];
         for(int i = 0;i < n;i++){
             arr[i] = input.nextInt ();
         }
        System.out.println (Arrays.toString (multiply(arr)));
    }
}