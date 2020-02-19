class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }

    public String toString(){
        return String.format ("%d",val);
    }
}

public class Main {

    //俩个链表，位数是倒置的，求他们的和，并且将结果倒置链表输出

    public static ListNode plusAB(ListNode a, ListNode b) {
        ListNode res = null;
        ListNode last = null;

        //ListNode l1 = reverse (a);
        //ListNode l2 = reverse (b);

        int val1 = sum (a);
        int val2 = sum (b);

        int plusnum = val1 + val2;

        while (plusnum > 0) {
            int n = plusnum % 10;
            plusnum /= 10;
            ListNode node = new ListNode (n);
            //尾插至结果链表
            if (res == null) {
                res = node;
            } else {
                last.next = node;
            }
            last = node;
        }
        return res;
    }


    public static int sum(ListNode head) {
        ListNode cur = head;
        int count = 0;
        int val = 0;
        while (cur != null) {
            val += (cur.val) * (Math.pow (10,count));
            count++;
            cur = cur.next;
        }
        return val;
    }

    public static ListNode reverse(ListNode head) {
        //头插
        ListNode cur = head;
        ListNode res = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = res;
            res = cur;
            cur = next;
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
        ListNode head = new ListNode (3);
        head.next = new ListNode (1);
        head.next.next = new ListNode (2);
//        head.next.next.next = new ListNode(5);
//        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next.next.next = new ListNode(3);

        ListNode head2 = new ListNode (1);
        head2.next = new ListNode (4);
        head2.next.next = new ListNode (4);
//        head2.next.next.next = new ListNode(5);
//        head2.next.next.next.next = new ListNode(3);
//        head2.next.next.next.next.next = new ListNode(6);
//        head2.next.next.next.next.next.next = new ListNode(9);
//        head2.next.next.next.next.next.next.next = new ListNode(3);

        print (plusAB (head, head2));
    }
}
