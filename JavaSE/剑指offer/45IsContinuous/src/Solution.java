import java.util.Arrays;

public class Solution {

    // 扑克牌顺子

    public boolean isContinuous(int [] numbers) {
        if(numbers.length != 5){
            return false;
        }
        // 将数组排序
        Arrays.sort (numbers);
        int i = 0;
        // 过滤为0的元素
        while(numbers[i] == 0){
            i++;
        }
        // 判断最大数和最小数的差是否大于等于5
        for(int j = i;j < numbers.length-1;j++){
            if(numbers[j] == numbers[j+1]){
                return false;
            }
            if(numbers[j+1] - numbers[i] >= 5){
                return false;
            }
        }
        return true;
    }
}