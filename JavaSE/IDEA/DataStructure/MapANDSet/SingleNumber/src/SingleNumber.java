import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    //思路：
    //1.利用map的映射关系
    //2.遍历数组，当在map中找到当前元素时，返回其value值，并修改其value值，即+1
    //3。如果未在map中找到当前元素，直接插入，key为当前元素，value为0+1

    public static Map<Integer,Integer> singleNumber(int[] arr){
        Map<Integer,Integer> map = new HashMap<> ();
        for(int n : arr){
            int c = map.getOrDefault (n,0);
            map.put(n,c+1);
        }
        return map;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,7,7,5,3,1,6};
        System.out.println (singleNumber (nums));
    }
}
