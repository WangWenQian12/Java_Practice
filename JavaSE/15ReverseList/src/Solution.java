class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // 反转链表
    // 输入一个链表，反转链表后，输出新链表的表头。

    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode newHead = null;
        while(cur != null ){
            ListNode next = cur.next;
            cur.next = newHead; // 头插
            newHead = cur; // 更新newHead的位置
            cur = next;
        }
        return newHead;
    }

}
