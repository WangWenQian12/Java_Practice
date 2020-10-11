class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // 链表中环的入口结点

    public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }

        ListNode p = pHead;
        ListNode q = slow;
        while(p != null){
            p = p.next;
            q = q.next;
        }

        return p;
    }
}