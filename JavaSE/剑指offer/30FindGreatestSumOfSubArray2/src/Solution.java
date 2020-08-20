public class Solution {

    // 连续子数组的最大和

    public static int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        int maxSum = array[0];
        dp[0] = array[0];
        for(int i = 1;i < array.length;i++){
            int sum = dp[i-1] + array[i];
            if(sum < array[i]){
                dp[i] = array[i];
            }else{
                dp[i] = sum;
            }
            if(dp[i] > maxSum){
                maxSum = dp[i];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println (FindGreatestSumOfSubArray (arr));
    }
}