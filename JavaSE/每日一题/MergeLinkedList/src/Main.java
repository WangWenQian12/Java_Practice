class ListNode{
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}


public class Main {

    //合并俩个有序链表

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode res = null;
        ListNode last = null;

        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                if (res == null) {
                    res = cur1;
                } else {
                    last.next = cur1;
                }
                last = cur1;
                cur1 = cur1.next;
            } else {
                if (res == null) {
                    res = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;
                cur2 = cur2.next;
            }

            if (cur1 != null) {
                last.next = cur1;
            } else {
                last.next = cur2;
            }
        }
        return res;
    }


    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print (cur.val + "-->");
            cur = cur.next;
        }
        System.out.print ("null");
        System.out.println ();
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode (1);
        l1.next = new ListNode (2);
        l1.next.next = new ListNode (6);
        l1.next.next.next = new ListNode (10);
        print (l1);
        ListNode l2 = new ListNode (1);
        l2.next = new ListNode (3);
        l2.next.next = new ListNode (4);
        l2.next.next.next = new ListNode (9);
        l2.next.next.next.next = new ListNode (12);
        print (l2);
        // mergeTwoLists(l1,l2);
        print (Merge (l1, l2));


    }
}
