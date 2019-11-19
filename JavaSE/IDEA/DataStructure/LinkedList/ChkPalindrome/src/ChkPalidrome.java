class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }

}

public class ChkPalidrome {

    //判断是否为回文数字
    //1.先得到链表长度，找到最中间结点.
    //2.从中间结点开始逆置链表（头插）
    //3.比较前半段和逆置之后的字符串

    public static boolean chkPalidrome(Node head){
        Node mid = MidList(head);
        Node newList = reverseList(mid);

        Node cur1 = head;
        Node cur2 = newList;

        while(cur1 !=null && cur2 !=null){
            if(cur1.val != cur2.val){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;

        }
        return true;

    }

    public static Node MidList(Node head){
        Node p1 = head;
        Node p2 = head;

        while(p1 != null){
            p1 = p1.next;
            if(p1 == null){
                break;
            }
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;

    }

    public static Node reverseList(Node head){
        Node cur = head;
        Node result = null;

        while(cur != null){
            //头插
         Node next = cur.next;

         cur.next = result;
         result = cur;
         cur = next;


        }
        return result;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(4);
        l1.next.next.next = new Node(3);
        l1.next.next.next.next = new Node(7);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);
        l2.next.next.next = new Node(3);
        l2.next.next.next.next = new Node(1);

        if(chkPalidrome(l1) == true){
            System.out.println("yes!");
        }
        else{
            System.out.println("no!");
        }
        if(chkPalidrome(l2) == true){
            System.out.println("yes!");
        }
        else{
            System.out.println("no!");
        }

    }
}
