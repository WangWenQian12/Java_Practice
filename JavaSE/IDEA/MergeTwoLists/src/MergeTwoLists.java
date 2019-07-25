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

        if(l1==null) {
            return l2;
        }
        if(l2==null){
            return l1;
        }

        Node result = null;
        Node last = null;

        Node cur1 = l1;
        Node cur2 = l2;

        while(cur1 != null  &&  cur2 != null){
            if(cur1.val <= cur2.val){
                //尾插
                Node next = cur1.next;
                if(result == null){
                    result = cur1;
                }
                else{
                    last.next = cur1;
                }
                last = cur1;
                cur1 = next;
            }
            else{
                Node next = cur2.next;
                if(result == null){
                    result = cur2;
                }
                else{
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }
        if(cur1 == null){
            last.next = cur2;
        }
        else{
            last.next = cur1;
        }
        return result;


    }

    private static Node pushFront(Node head,int val){
        Node node = new Node(val);
        node.next = head;
        return node;
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
        /*Node l1 = null;
        l1 = pushFront(l1,5);
        l1 = pushFront(l1,4);
        l1 = pushFront(l1,3);
        l1 = pushFront(l1,2);
        l1 = pushFront(l1,1);
        Node l2 = null;
        l2 = pushFront(l2,11);
        l2 = pushFront(l2,9);
        l2 = pushFront(l2,7);
        l2 = pushFront(l2,4);
        l2 = pushFront(l2,2);
        l2 = pushFront(l2,1);*/
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(6);
        l1.next.next.next = new Node(10);
        print(l1);
        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);
        l2.next.next.next = new Node(9);
        l2.next.next.next.next = new Node(12);
        print(l2);
       // mergeTwoLists(l1,l2);
        print(mergeTwoLists(l1,l2));


    }
}
