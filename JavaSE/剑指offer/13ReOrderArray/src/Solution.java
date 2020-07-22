public class Solution {

    // 调整数组顺序使奇数位于偶数前面
    // 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    // 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变。

    public void reOrderArray(int [] array) {
        if(array.length == 1){
            return;
        }
        int i = 0;
        while(i < array.length){
            int j = i + 1;
            // 遍历数组，找到为偶数的元素
            if(array[i] % 2 == 0) {
                // 在此偶数之后寻找第一个奇数
                while (array[j] % 2 == 0) {
                    // 遍历结束都为偶数，则排序结束
                    if (j == array.length - 1) {
                        return;
                    }
                    j++;
                }

                // 找到之后，在数组内进行移动
                int tmp = array[j];
                for (int m = j; m > i; m--) {
                    array[m] = array[m - 1];
                }
                array[i] = tmp;
            }
            i++;

        }
    }

}
