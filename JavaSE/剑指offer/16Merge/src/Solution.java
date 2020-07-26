class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {

    // 合并两个排序的列表
    // 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode cur1 = list1;
        ListNode cur2 = list2;

        ListNode res = null;  //结果链表
        ListNode last = null;  //结果链表的最后一个结点

        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                if(res == null){
                    res = cur1;
                }
                else{
                    last.next = cur1;
                }
                // 更新 last 和 cur1
                last = cur1;
                cur1 = cur1.next;
            }
            else{
                if(res == null){
                    res = cur2;
                }else{
                    last.next = cur2;
                }
                // 更新 last 和 cur2
                last = cur2;
                cur2 = cur2.next;
            }

            // 更新位置之后，必然会在某时某个链表遍历结束
            // 如果 cur1 遍历结束，则直接把剩下的 cur2 跟在后面
            if(cur1 != null){
                last.next = cur1;
            }else{
                // 如果 cur1 遍历结束，则直接把剩下的 cur2 跟在后面
                last.next = cur2;
            }
        }
        return res;

    }
}