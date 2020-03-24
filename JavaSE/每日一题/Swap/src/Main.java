import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //输入一个只有俩个0元素的数组，在不设置中间变量的情况下，交换首元素和尾元素

    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int[] arr = new int[2];
        for(int i = 0;i < 2;i++){
            arr[i] = sc.nextInt ();
        }

        swap(arr,0,1);
        System.out.println (Arrays.toString (arr));
    }
}
