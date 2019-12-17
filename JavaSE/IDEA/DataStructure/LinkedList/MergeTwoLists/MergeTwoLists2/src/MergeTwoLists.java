class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoLists {

    public static Node mergeTwoLists(Node l1,Node l2){
        if(l1 == null){return l2;}
        if(l2 == null){return l1;}

        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
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
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);
        l2.next.next.next = new Node(8);
        l2.next.next.next.next = new Node(10);
        print(mergeTwoLists(l1,l2));


    }
}
