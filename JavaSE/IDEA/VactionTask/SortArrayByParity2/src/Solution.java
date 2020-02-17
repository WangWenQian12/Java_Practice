import java.util.Arrays;

public class Solution {

    //给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
    //双指针同向遍历

    public static int[] sortArrayByParity(int[] A){
        if(A.length == 2 ){
            for(int i = 0; i < 2;i++){
                if(A[i] % 2 == 0 ){
                    swap(0,1,A);
                }
            }
            return A;
        }
        int i = 0;
        while(i < A.length - 1){
            while(A[i] % 2 == 0 && i < A.length - 1){
                i++;
            }
            int j = i;
            while(A[j] % 2 == 1 && j < A.length - 1){
                j++;
            }
            swap(i,j,A);
            i++;
        }
        return A;
    }

    public static void swap(int i,int j,int[] arr){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,3};
        System.out.println (Arrays.toString (sortArrayByParity (arr)));
    }


}
