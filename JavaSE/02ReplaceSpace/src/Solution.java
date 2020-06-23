public class Solution {

    // 请实现一个函数，将一个字符串中的每个空格替换成 “%20” 。
    // 例如，当字符串为 We Are Happy. 则经过替换之后的字符串为 We%20Are%20Happy 。
    // 思路：
    // 在当前字符串上进行替换。
    // （1）先计算替换后的字符串需要多大的空间，并对原字符串空间进行扩容；
    // （2）从后往前替换字符串的话，每个字符串只需要移动一次；
    // （如果从前往后，每个字符串需要多次移动，效率较低。）

    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for(int i = 0;i < str.length ();i++){
            if(str.charAt (i) == ' '){
                count ++;
            }
        }
        int oldLength = str.length ();
        int oldIndex = oldLength - 1;
        int newLength = oldLength + count*2;
        str.setLength (newLength); //扩容
        int newIndex = newLength - 1;
        for( ;oldIndex >= 0 && oldLength < newLength;oldIndex--){
            if(str.charAt (oldIndex) == ' '){
                str.setCharAt (newIndex--,'0');
                str.setCharAt (newIndex--,'2');
                str.setCharAt (newIndex--,'%');
            }else{
                str.setCharAt (newIndex--,str.charAt (oldIndex));
            }
        }
        return str.toString ();
    }
}