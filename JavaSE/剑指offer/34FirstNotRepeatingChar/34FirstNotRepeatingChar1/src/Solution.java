public class Solution {

    // 找出第一个只出现一次的字符

    public int FirstNotRepeatingChar(String str) {
        for(int i = 0;i < str.length ();i++){
            // 第一次出现和最后一次出现在同一个位置，说明只有一个
            if(str.indexOf(str.charAt (i)) == str.lastIndexOf (str.charAt (i))){
                return i;
            }
        }
        return -1;

    }
}
