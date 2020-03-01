import java.util.HashMap;
import java.util.Map;

public class Solution {

    //给定一个整数数组，判断是否存在重复元素。
    //如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<> ();
        for(int n : nums){
            int count = map.getOrDefault (n,0);
            if(count == 1){
                return true;
            }
            map.put (n,count+1);
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println (containsDuplicate (arr));
    }
}
