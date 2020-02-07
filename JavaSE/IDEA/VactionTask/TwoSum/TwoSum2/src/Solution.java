import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    //哈希表映射：加快索引，空间换取时间

    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<> ();
        for(int i = 0;i < nums.length;i++){
            map.put (nums[i],i);
        }

        for(int i = 0;i < nums.length;i++){
            int res = target - nums[i];
            if(map.containsKey (res) && map.get (res) != i){
                int j = map.get (res);
                return new int[] {i,j};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println (Arrays.toString (twoSum (arr,9)));
        //twoSum (arr,9);
    }
}
