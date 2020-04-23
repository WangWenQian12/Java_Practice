import java.util.Scanner;

public class Main {

    public static int calc(int[] arr1,int[] arr2,int m,int n){
        int dp[][] = new int[200][200];
        for(int i = 1; i <= m;i++){
            dp[i-1][0] = 0;
            for(int j = 1;j <= n;++j){
                dp[i][j] = Math.max (dp[i-1][j],dp[i-1][j-1] + arr1[i] - arr2[i]*(j-1));
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()){
            int m = sc.nextInt ();
            int n = sc.nextInt ();
            int[] arr1 = new int[m];
            for(int i = 0;i < m;i++){
                arr1[i] = sc.nextInt ();
            }
            int[] arr2 = new int[n];
            for(int i = 0; i < m;i++){
                arr2[i] = sc.nextInt ();
            }
            System.out.println (calc(arr1,arr2,m,n));
        }
    }
}
