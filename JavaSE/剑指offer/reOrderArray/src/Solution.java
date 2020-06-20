import java.util.Arrays;

public class Solution {

    // 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    // 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变。


    public static void reOrderArray1(int [] array) {
        if(array.length == 1){
            return;
        }
        int i = 0;
        while(i < array.length){
            int j = i + 1;
            // 如果 array[i] 为偶数，则去找 i 之后的第一个为奇数的元素
            if(array[i] % 2 == 0){
                // array[j] 为偶数，则 j++
                while(array[j] % 2 == 0){
                    if(j == array.length - 1){
                        return ;
                    }
                    j++;
                }
                // 找到了第一个为奇数的元素，则在数组内进行移动
                int key = array[j];
                int count = j - i;
                for(int m = 0; m < count;m++){
                    array[j - m] = array[j - m - 1];
                }
                array[i] = key;
            }
            i++;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,4,6,7,3,8,9};
        int[] arr2 = {2};
        reOrderArray1 (arr2);
        System.out.println (Arrays.toString (arr2));
    }
}