import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //GrayCode格雷码（递归）


    public static String[] getGray(int n){
        //先创建数组
        int size = (int)Math.pow(2,n);
        String[] arr = new String[size];

        if(n == 1){
            arr[0] = "0";
            arr[1] = "1";
            return arr;
        }

        //n-1时的数组
        String[] pre = getGray (n-1);

        for(int i = 0;i < pre.length;i++){
            arr[i] = "0" + pre[i];
            arr[arr.length-1-i] = "1" + pre[i];
        }
        return arr;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        System.out.println (Arrays.toString(getGray (n)));
    }
}
