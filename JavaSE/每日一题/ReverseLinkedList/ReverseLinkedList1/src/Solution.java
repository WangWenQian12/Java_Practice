import java.util.ArrayList;

class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }
}

public class Solution {

    // 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

    public ArrayList<Integer> printListFromTailToHead(Node listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Node cur = listNode;
        while(cur != null){
            list.add(0,cur.val); // 放置顺序表最前
            cur = cur.next;
        }
        return list;
    }
}
