public class Solution {

    // 连续子数组的最大和

    public static int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int maxSum = array[0];
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum > 0) {
                flag = false;
                if (sum > maxSum) {
                    maxSum = sum;
                }
            } else {
                sum = 0;
            }
        }

        // 数组全为负数时
        if(flag == true){
            for(int i = 0; i < array.length;i++){
                if(array[i] > maxSum){
                    maxSum = array[i];
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-8,-1,-5,-9};
        System.out.println (FindGreatestSumOfSubArray (arr));
    }
}