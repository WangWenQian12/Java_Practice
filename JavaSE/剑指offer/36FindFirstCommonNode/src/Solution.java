class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // 找出两个链表的第一个公共结点

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getLength (pHead1);
        int len2 = getLength (pHead2);

        int steps = len1 - len2;
        ListNode longer = pHead1;
        ListNode shorter = pHead2;
        if(len1 < len2){
            steps = len2 - len1;
            longer = pHead2;
            shorter = pHead1;
        }

        for(int i = 0;i < steps;i++){
            longer = longer.next;
        }

        while(longer != shorter){
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;

    }

    public static int getLength(ListNode head){
        int count = 0;
        for(ListNode cur = head;cur != null;cur = cur.next){
            count++;
        }
        return count;
    }
}