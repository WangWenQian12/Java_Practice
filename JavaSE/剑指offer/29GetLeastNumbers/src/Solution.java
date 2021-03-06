import java.util.*;

public class Solution {

    // 最小的k个数

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length == 0){
            return list;
        }
        if(k > input.length){
            return list;
        }
        Arrays.sort(input);
        for(int i = 0;i < k;i++){
            list.add(input[i]);
        }
        return list;
    }
}