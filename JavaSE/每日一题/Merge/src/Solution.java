import java.util.Arrays;

public class Solution {

    //给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    //说明:
    //初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    //你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

    //注意：
    //nums1 数组有足够的空间，而其中的元素个数为m

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length-1;
        int i = m-1;
        int j = n-1;
        while(i >=0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[len--] = nums1[i--];
            }else{
                nums1[len--] = nums2[j--];
            }
        }
        while(j >= 0){
            nums1[len--] = nums2[j--];
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] a = {2,0};
        int[] b = {1};
        System.out.println (Arrays.toString (merge (a,1,b,1)));
    }

    
}
