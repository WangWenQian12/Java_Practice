import java.util.Stack;

public class Solution {

    //给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
    //思路：
    //遍历字符串，将字母入栈
    //遍历字符串，将字母位的字符换成栈顶元素

    public static String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<> ();
        for(int i = 0; i < S.length ();i++) {
            if (isLetter (S.charAt (i))) {
                stack.add (S.charAt (i));
            }
        }

        String s = "";
        for (int j = 0; j < S.length (); j++) {
            if(isLetter (S.charAt (j))){
                s += stack.pop ();
            }else{
                s += S.charAt (j);
            }

        }

        return s;
    }

    public static boolean isLetter(char c){
        return (c < 'z' && c > 'a') || (c < 'Z' && c > 'A');
    }

    public static void main(String[] args) {
        System.out.println (reverseOnlyLetters ("Test1ng-Leet=code-Q!"));
    }
}
