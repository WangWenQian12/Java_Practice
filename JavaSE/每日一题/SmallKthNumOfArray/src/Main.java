import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    //找出数组前k个最小的数字
    //输入的一串数字共有n+1个，最后一个为k的值，前n个为数组元素

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String s = sc.nextLine ();
        String[] input = s.split (" ");
        String[] res = Arrays.copyOfRange (input,0,input.length-1);
        int[] arr = new int[res.length];
        for(int i = 0;i < res.length;i++){
            arr[i] = Integer.parseInt (input[i]);
        }

        int k = Integer.parseInt (input[input.length-1]);

        Arrays.sort (arr);

        for(int i = 0;i < k;i++){
            System.out.print (arr[i]+" ");
        }



    }
}
