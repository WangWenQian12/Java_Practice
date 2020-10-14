import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // 字符流中第一个不重复的字符
    // 使用队列

    static Queue<Character> queue = new LinkedList<> ();
    static int[] charCount = new int[256];

    //Insert one char from stringstream
    public static void Insert(char ch){
        if(++charCount[ch] == 1){
            queue.offer (ch);
        }else{
            queue.remove (ch);
        }
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce(){
        return queue.peek() == null ? '#' : queue.peek();
    }

    public static void main(String[] args) {
        char[] a = {'g','o','o','g','l','e'};
        for(int i = 0;i < a.length;i++) {
            Insert (a[i]);
        }
        System.out.println (FirstAppearingOnce ());
    }
}