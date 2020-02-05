public class Solution {

    //给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
    //如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
    //如果不存在最后一个单词，请返回 0 。

    public static int lengthOfLastWord(String s) {
        s = s.trim ();
        int len = s.length();
//        if(len == 1){
//            if(s.charAt(0) == ' '){
//                return 0;
//            }
//            return 1;
//        }
        int count = 0;
        for(int i = len-1;i >= 0;i--){
            if(s.charAt(i)==' '){
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println (lengthOfLastWord ("hello world" ));
    }
}
