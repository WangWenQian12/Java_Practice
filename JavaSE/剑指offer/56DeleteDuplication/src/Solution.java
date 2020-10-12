class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // 删除链表中重复的结点

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null && pHead.next == null){
            return pHead;
        }
        // 构建新的链表头
        ListNode newHead = null;
        newHead.next = pHead;
        // 将新的链表头当作前置结点
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 直接改变引用，删除重复节点
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;

    }
}