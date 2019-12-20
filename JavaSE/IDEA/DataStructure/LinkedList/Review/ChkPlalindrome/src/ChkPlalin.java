class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }
}

public class ChkPlalin {

    //判断链表是否为回文结构
    //思路：
    //1.回文结构是正序和反序都相等的结构
    //2.将整个链表逆置（头插），和原链表比较
    //3.如果链表有奇数个结点，我们可以取中间结点，将后半段逆置（头插），然后前半段和后半段进行比较
    //4.如果链表有偶数个结点，同样取中间结点，此时中间结点为最中间俩个结点的后一个，将后半段逆置（头插），从原链表开头进行比较


    //找中间节点，利用快慢指针
    public static Node getMid(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null){
            fast = fast.next;
            if(fast == null){
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    //逆置链表，头插
    public static Node reverseList(Node head){
        Node result = null;
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }

    public static boolean checkPlalindrome(Node head){
        Node mid = getMid(head);
        Node newList = reverseList(mid);

        Node cur1 = head;
        Node cur2 = newList;
        while(cur1 != null && cur2 != null){
            if(cur1.val != cur2.val){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node h1 = new Node(1);
        Node h2 = new Node(1);
        Node h3 = new Node(2);
        Node h4 = new Node(2);
        Node h5 = new Node(3);
        Node h6 = new Node(3);
        Node h7 = new Node(6);
        Node h8 = new Node(6);

        h1.next = h3;
        h3.next = h5;
        h5.next = h7;
        h7.next = h8;
        h8.next = h6;
        h6.next = h4;
        h4.next = h2;

        System.out.println(checkPlalindrome(h1));

    }
}
