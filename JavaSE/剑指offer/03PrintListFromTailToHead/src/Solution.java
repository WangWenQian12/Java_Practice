import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<> ();
        Stack<Integer> stack = new Stack<> ();
        // 遍历链表，进栈
        for(ListNode cur = listNode;cur != null;cur = cur.next){
            stack.add (cur.val);
        }
        // 出栈，进顺序表
        while(!stack.isEmpty ()){
            int tmp = stack.pop ();
            list.add (tmp);
        }
        return list;
    }
}