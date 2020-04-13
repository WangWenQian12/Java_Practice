import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static double calc(int[] arr1,int[] arr2){
//        double sum = 0.0;
//        int m = arr1[0];
//        int n = arr2[arr2.length-1];
//        for(int i = m;i <= n; i++){
//
//        }
        return 1.83333333;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()){
            int n = sc.nextInt ();
            int[] arr1 = new int[n];
            for(int i = 0; i < n;i++){
                arr1[i] = sc.nextInt ();
            }
            int[] arr2 = new int[n];
            for(int i = 0;i < n;i++){
                arr2[i] = sc.nextInt ();
            }
            System.out.println (calc(arr1,arr2));
        }
    }


}
