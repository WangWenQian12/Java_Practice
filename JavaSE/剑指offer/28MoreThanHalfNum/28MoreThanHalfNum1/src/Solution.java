import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 数组中出现次数超过一半的数字

    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length/2;
        HashMap<Integer,Integer> map = new HashMap<> ();
        for(int i = 0;i < array.length;i++){
            int n = map.getOrDefault (array[i],0);
            map.put (array[i],n+1);
        }

        for(Map.Entry<Integer,Integer> m : map.entrySet ()){
            if(m.getValue () > len){
                return m.getKey ();
            }
        }
        return 0;
    }
}