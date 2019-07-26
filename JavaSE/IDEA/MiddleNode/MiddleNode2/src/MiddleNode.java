class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }
}

public class MiddleNode {

    //找到链表的中间结点
    //1.创建俩个结点fast = head和slow = head
    //2.每次fast遍历俩个结点，slow遍历一个结点
    //3.当fast指向空时，此时slow必指向middleNode

    public static Node middleNode(Node head){
        Node p1 = head;
        Node p2 = head;

        while( p1!= null){
            p1 = p1.next;
            if(p1 == null){
                break;
            }
            p2 = p2.next;
            p1 = p1.next;

        }
        return p2;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(12);
        head.next.next.next.next.next = new Node(8);
        System.out.println((middleNode(head).val));

    }
}
