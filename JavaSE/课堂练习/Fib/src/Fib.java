import java.util.Arrays;
import java.util.Scanner;

public class Fib {

    //Fibonacci数列
    //随机给出一个数字，要求求出它最少加几或者减几能变成Fibonacci数列中的某一个数字


    public static int fib(int n){
        int f = 0;
        if(n == 0){
            f = 0;
        }
        if(n == 1 || n == 2){
            f = 1;
        }
        if(n > 2){
            f = fib(n-1) + fib(n-2);
        }
        return f;
    }


    public static int[] findSteps(int n,int[] arr,int[] res) {
        for(int i = 0;i<arr.length;i++){
            res[i] = Math.abs(arr[i] - n);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[33];
        for(int i = 0;i<33;i++){
            arr[i] = fib(i);
        }
        //System.out.println (Arrays.toString(arr));

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] res = new int[33];
        Arrays.sort(findSteps (n,arr,res));


        System.out.println (res[0]);
    }
}
