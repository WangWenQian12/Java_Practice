import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    // 栈的压入、弹出序列
    // 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
    // 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
    // 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
    // （注意：这两个序列的长度是相等的）
    // 思路：
    // （1）添加一个辅助战，将 pushA 中的数据依次入栈
    // （2）同时判断辅助战的栈顶元素是否等于出栈序列，如果相等，辅助栈栈顶元素出栈

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer> ();
        int i = 0;
        int j = 0;
        for(;i < pushA.length;i++){
           stack.add (pushA[i]);
           while(j < popA.length && stack.peek () == popA[j]){
               stack.pop ();
               j++;
           }
        }
        if(stack.isEmpty ()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] in = {1,2,3,4,5};
        int[] out = {4,5,3,2,1};
        System.out.println (IsPopOrder (in,out));
    }
}