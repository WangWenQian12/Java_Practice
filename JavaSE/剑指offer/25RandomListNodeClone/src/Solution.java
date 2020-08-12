class Node {
    int val;
    Node next = null;
    Node random = null;

    Node(int val) {
        this.val = val;
    }
}

public class Solution {

    // 复杂链表的复制

    public static Node complexCopy(Node head){
        if(head == null){
            return null;
        }

        //糅合俩个链表
        Node p1 = head;
        while(p1 != null){
            Node p2 = new Node(p1.val);
            p2.next = p1.next;
            p1.next = p2;

            p1 = p2.next;
        }

        //2.复制random指向
        p1 = head;
        while(p1 != null){
            Node p2 = p1.next;
            if(p1.random != null) {
                p2.random = p1.random.next;
            }
            p1 = p2.next;
        }

        //3.拆表
        p1 = head;
        Node newHead = head.next;
        while(p1 != null) {
            Node p2 = p1.next;
            p1.next = p2.next;
            if (p2.next != null) {
                p2.next = p2.next.next;
            }
            p1 = p1.next;
        }
        return newHead;
    }

}