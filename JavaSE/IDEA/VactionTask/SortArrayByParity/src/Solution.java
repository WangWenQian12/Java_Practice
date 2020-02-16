import java.util.Arrays;

public class Solution {

    //给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
    //双指针相向遍历

    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length-1;
        while(i < j){
            while(A[i] % 2 == 0 && i < j){ // 偶数
                i++;
            }
            while(A[j] % 2 == 1 && i < j){ // 奇数
                j--;
            }
            swap(i,j,A);
            i++;
            j--;
        }

        return A;
    }

    public static void swap(int i,int j,int[] arr){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,4};
        System.out.println (Arrays.toString (sortArrayByParity (arr)));
    }
}
