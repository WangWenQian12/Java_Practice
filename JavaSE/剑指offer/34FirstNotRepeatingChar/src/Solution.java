import java.util.HashMap;

public class Solution {

    // 第一个只出现一次的字符

    public int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> map = new HashMap<> ();

        for(int i = 0;i < str.length ();i++){
            int n = map.getOrDefault (str.charAt (i),0);
            map.put (str.charAt (i),n+1);
        }


        for(int i = 0;i < str.length ();i++){
            if(map.get (str.charAt (i)) == 1){
                return i;
            }
        }
        return -1;
    }
}