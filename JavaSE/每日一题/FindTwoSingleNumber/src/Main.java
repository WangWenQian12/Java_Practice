import java.util.*;

public class Main{

    // 找出数组中单独出现的两个数字（其余为成对出现）

    public static void findSingleNum(int[] arr){
        int num = 0;
        // 两个单独的数字不相等的位（0，1不相等的位）
        for(int i = 0;i < arr.length;i++){
            num ^= arr[i];
        }

        // 将数组中的数字分为两拨
        int pos = -1;
        for(int i = 0; i < 32;i++){
            if(((num >> i) & 1 ) == 1){
                pos = i;
                break;
            }
        }

        int x = 0,y = 0;
        for(int i = 0; i < arr.length;i++){
            if(((arr[i] >> pos) & 1 ) == 1){
                x ^= arr[i];
            }else{
                y ^= arr[i];
            }
        }
        System.out.println (x + " " + y);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        findSingleNum(arr);
    }
}