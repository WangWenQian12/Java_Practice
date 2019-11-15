
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class Main {

    //一个数字n，你想让它变为一个斐波那契数，每一步可以将数字变为n-1或n+1
    //现在给你一个数字n，求最小步数将其变为斐波那契数

    public static int fib(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return fib(n-1)+fib(n-2);
    }

    public static int fib2(int n){
        int f0 = 0,f1 = 1;
        int f = 0;
        while(n > 0){
            f = f0+f1;
            f0 = f1;
            f1 = f;
            n--;
        }
        return f;
    }

    public static int[] fibArray(int n){
        int[] arr = new int[n+1];
        for(int i = 0;i <= n;i++ ){
            arr[i] = fib2 (i);
        }
        return arr;
    }

    public static int calcSteps(int[] arr,int num){
        int min = MAX_VALUE;
        for(int i = 0;i< arr.length;i++){
            int steps = Math.abs (arr[i] - num);
            if(steps < min){
                min = steps;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int num = sc.nextInt ();
        //1000000以内共有36个斐波那契数
        System.out.println (calcSteps (fibArray (36),num));
    }

}
