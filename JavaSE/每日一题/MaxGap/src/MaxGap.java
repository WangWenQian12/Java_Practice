import java.util.*;

public class MaxGap {

    // 贪心算法
    // 给定一个长度为N(N>1)的整型数组A，可以将A划分成左右两个部分，左部分A[0..K]，右部分A[K+1..N-1]，K可以取值的范围是[0,N-2]。
    // 求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值，最大是多少？

    public static int findMaxGap(int[] A, int n) {
        // write code here
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=A[i];
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                dp[i][j]=Math.max(dp[i][j-1],A[j]);
            }
        }
        int max=0;
        for(int k=0;k<n-1;k++){
            if(Math.abs(dp[0][k]-dp[k+1][n-1])>max){
                max=Math.abs(dp[0][k]-dp[k+1][n-1]);
            }
        } 
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,3,1,1};
        System.out.println (findMaxGap (arr,5));
    }
}