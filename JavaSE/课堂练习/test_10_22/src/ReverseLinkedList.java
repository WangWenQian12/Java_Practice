class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}


public class ReverseLinkedList {
    public static Node reverseLinkedList(Node head){
        Node newHead = null;
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }

        return newHead;
    }

    public Node sortLinkedList(Node head){
        return null;
    }

    public static void print(Node head){
        for(Node cur = head;cur != null;cur = cur.next){
            System.out.print (cur.val+"-->");
        }
        System.out.println ();
    }



    public static void main(String[] args) {
        Node h1 = new Node(3);
        Node h2 = new Node(7);
        Node h3 = new Node(6);
        Node h4 = new Node(1);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;

        print(reverseLinkedList(h1));

    }


}
