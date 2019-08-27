class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }
}

public class RevolveLinkedList {

    //逆置链表
    //思路：
    //遍历链表，将每一个结点头插到新链表上

    public static Node revolveLinkedList(Node head){
        Node cur = head;
        Node newHead = null;

        while(cur != null){
            Node next = cur.next;
            cur.next = newHead;//结点头插
            newHead = cur;//更新逆置后的头结点
            cur = next;

        }
        return newHead;
    }

    public static void print(Node head){
        for(Node cur = head;cur != null;cur = cur.next){
            System.out.print(cur.val+"-->");
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(7);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next = new Node(3);

        print(revolveLinkedList(head));
    }
}
