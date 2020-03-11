import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
    // 如果可以构成，返回 true ；否则返回 false。
    //(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<> ();
        for(int i = 0;i < magazine.length ();i++){
            int count = map.getOrDefault (magazine.charAt (i),0);
            map.put (magazine.charAt (i),count+1);
        }

        char[] arr = ransomNote.toCharArray ();
        for(char r : arr){
            if(map.containsKey (r)){
                int count = map.getOrDefault (r,0)-1;
                if(count < 0){
                    return false;
                }else{
                    map.put (r,count);
                }
            }else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
