class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val= val;
        this.next = next;
    }
}

public class RemoveAllElements {

    public static Node removeAll(Node head,int v){
        Node pre = null;
        Node cur = head;
        while(cur != null){
            if(cur.val == v) {
                if (cur == head) {
                    head = cur.next;
                } else {
                    pre.next = cur.next;
                }
            }
            else{
                 pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //尾插
    public static Node pushBack(Node head,int v){
        Node node  = new Node(v);
        if(head==null){
            return node;
        }
        Node last = head;
        while(last.next != null ){
            last = last.next;
        }
        last.next = node;
        return head;

    }

    public static void print(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.val+"-->");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();

    }

    public static void main(String[] args){
        /*Node head = new Node(3);
        head.next = new Node(7);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next = new Node(3);*/
        Node head = null;
        head =pushBack(head,1);
        head =pushBack(head,3);
        head =pushBack(head,3);
        head =pushBack(head,4);
        head =pushBack(head,3);
        head =pushBack(head,7);
        head =pushBack(head,9);
        print(removeAll(head,3));

    }
}
