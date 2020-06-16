class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

// 输入一个链表，输出该链表中倒数第k个结点。

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        if(k > count){
            return null;
        }
        cur = head;
        for(int i = 0; i < count - k;i++){
            cur = cur.next;
        }
        return cur;
    }
}
