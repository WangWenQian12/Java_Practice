import java.util.*;

public class Main {

    // 爬楼梯，一次只能爬 1，2，3 级，现在有 n 级楼梯，求最多有多少中爬发

    public static int countWays(int n) {

        long[] arr = {1,2,4};
        if(n <= 0){
            return 0;
        }else if(n <= 3){
            return (int)arr[n-1];
        }else{
            for(int i = 4; i <= n;i++){
                long tmp = ((arr[i-1] + arr[i-2])%1000000007 + arr[i-3])%1000000007;
                arr[0] = arr[1];
                arr[1] = arr[2];
                arr[2] = tmp;
            }
        }
        return (int)arr[2];

        // write code here
//        int[] a = new int[100000];
//        a[1] = 1;
//        a[2] = 2;
//        a[3] = 4;
//        for(int i = 4; i <= n;i++){
//            a[i] = ((a[i-1] + a[i-2])%1000000007 + a[i-3]%1000000007);
//        }
//        return a[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()){
            int n = sc.nextInt ();
            System.out.println (countWays(n));
        }
    }
}