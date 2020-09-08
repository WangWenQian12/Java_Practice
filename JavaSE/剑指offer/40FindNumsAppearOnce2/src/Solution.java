import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 数组中只出现一次的数字（两个）

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer> ();
        for(int i = 0;i < array.length;i++){
            int n = map.getOrDefault (array[i],0);
            map.put (array[i],n+1);
        }
        boolean flag = true;
        for(int i = 0;i < array.length;i++){
            if(map.get (array[i]) == 1 ){
                if(flag == true){
                    flag = false;
                    num1[0] = array[i];
                }else{
                    num2[0] = array[i];
                }
            }
        }
    }
}