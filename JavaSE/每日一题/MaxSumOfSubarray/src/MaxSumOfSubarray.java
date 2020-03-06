import java.util.Scanner;

public class MaxSumOfSubarray {

    //输入一个整型数组，数组里有正数也有负数。
    //数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。
    //要求时间复杂度为O(n).
    //例如输入的数组为{1，-2，3，10，-4，7，2，-5}，和最大的子数组为{3，10，-4，7，2}，因此输出该数组的和为18
    //思路：
    //1.题目要求时间复杂度O(n),故只能遍历一遍数组
    //2.数组中一个或连续的多个整数的最大和，是做题的关键
    //3.我们定义一个变量sum，它用来记录一个或者连续的整数的和
    //4.定义一个变量maxSum，它用来记录最大的那个和
    //5.遇到某一个为负数的元素，如果sum小于0，则将sum清零（需要连续），重新找
    //6.sum大于0时，也需要判断加上这个元素是否为maxSum


    public static int getMaxSum(int[] a){
        int sum = 0;
        int maxSum = 0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
            if(sum>0) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }else{
                    sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please inter the capacity of the array:");
        int n = input.nextInt();

        int[] array = new int[n];
        System.out.println("Please inter the array:");
        for(int i=0;i<n;i++){
            array[i] = input.nextInt();
        }

        System.out.println(getMaxSum(array));


    }
}
