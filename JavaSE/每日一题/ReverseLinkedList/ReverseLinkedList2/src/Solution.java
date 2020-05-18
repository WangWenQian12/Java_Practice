import java.util.ArrayList;
import java.util.Stack;

class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }
}

public class Solution {
    // 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
    // 利用栈

    public ArrayList<Integer> printListFromTailToHead(Node listNode) {
        ArrayList<Integer> list = new ArrayList<> ();
        Stack<Integer> stack = new Stack<> ();
        Node cur = listNode;
        while(cur != null){
            stack.add (cur.val);
            cur = cur.next;
        }
        // 出栈进顺序表
        while(!stack.isEmpty ()){
            int tmp = stack.pop ();
            list.add (tmp);
        }
        return list;
    }
}
