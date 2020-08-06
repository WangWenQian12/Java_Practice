class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // 求链表中倒数第k个结点

    public ListNode FindKthToTail(ListNode head, int k) {
        int len = 0;
        for (ListNode cur = head;cur != null;cur = cur.next){
            len++;
        }

        if(k > len){
            return null;
        }

        int steps = len - k;
        ListNode result = head;
        for(int i = 0;i < steps;i++){
            result = result.next;
        }
        return result;
    }
}
