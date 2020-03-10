class ListNode{
    int val;
    ListNode next;
}

public class Main {

    //分割链表

    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode left = null;
        ListNode leftLast = null;
        ListNode right = null;
        ListNode rightLast = null;

        ListNode cur = pHead;
        while(cur != null){
            if(cur.val < x){
                if(left == null){
                    left = cur;
                }else{
                    leftLast.next = cur;
                }
                leftLast = cur;
            }else{
                if(right == null){
                    right = cur;
                }else{
                    rightLast.next = cur;
                }
                rightLast = cur;
            }
            cur = cur.next;
        }

        if(left == null){
            return right;
        }else{
            leftLast.next = right;
            if(rightLast != null){
                rightLast.next = null;
            }
            return left;

        }


    }
}
