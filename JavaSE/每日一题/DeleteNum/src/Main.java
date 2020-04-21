import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int judge(int[] arr,int x){

        // 给出一个序列包含n个正整数的序列A，你可以从中删除若干个数，
        // 使得剩下的数字中的最大值和最小值之差不超过x，请问最少删除多少个数字。

        Arrays.sort(arr);
        int max = arr[0];
        int min = arr[arr.length - 1];
        int index = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[arr.length-1] - arr[i] > x){
                continue;
            }else{
                index = i;
                break;
            }
        }
        return arr.length - index - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int x = sc.nextInt ();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt ();
        }
        System.out.println (judge(arr,x));
    }
}
