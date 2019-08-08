 class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
        this.next = null;
    }
 }
public class ReverseLinkedList {

    private static Node pushFront(Node head,int val){
        Node node = new Node(val);
        node.next = head;
        return node;
    }


    public static Node reverseList(Node head){
        Node p1 = null;
        Node p2 = head;

        while(p2 != null){
            Node p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        return p1;

    }

    public static void print(Node head){
        Node cur = head;
        while(cur!=null){
            System.out.print(cur.val+"-->");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args){
        Node head = null;
        head = pushFront(head,5);
        head = pushFront(head,4);
        head = pushFront(head,3);
        head = pushFront(head,2);
        head = pushFront(head,1);
        print(head);
        //reverseList(head);
        print(reverseList(head));


    }
}
