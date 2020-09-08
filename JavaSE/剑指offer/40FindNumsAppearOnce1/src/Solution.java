public class Solution {

    // 数组中只出现一次的数据（两个）
    // num1,num2分别为长度为1的数组。传出参数
    // 将num1[0],num2[0]设置为返回结果

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int key = array[0];
        for(int i = 1;i < array.length;i++){
            key = key ^ array[i];
        }

        // 找到位数不同的是第几位
        int index = 1;
        while((index & key) == 0){
            index <<= 1;
        }

        int res1 = 0;
        int res2 = 0;
        for(int i = 0;i < array.length;i++){
            if((index & array[i]) == 0){
                res1 ^= array[i];
            }else {
                res2 ^= array[i];
            }
        }
        num1[0] = res1;
        num2[0] = res2;
    }
}