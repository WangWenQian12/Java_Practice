class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }
}

public class MeregTwoLists {

    //合并俩个有序链表
    //思路：
    //1.遍历俩个链表，比较当前cur结点的值，小的哪一个就尾插到结果链表中
    //2.直到有一个链表遍历结束后，把另一个链表余下的链表全部尾插至结果链表

    public static Node mergeTwoLists(Node h1,Node l1){
        Node cur1 = h1;
        Node cur2 = l1;
        Node newHead = null;
        Node last = null;//结果链表的最后一个结点

        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){//尾插
                Node next = cur1.next;
                if(newHead == null){
                    newHead = h1;
                }
                else{
                    last.next = cur1;
                }
                last = cur1;
                cur1 = next;
            }
            else{
                Node next = cur2.next;
                if(newHead == null){
                    newHead = l1;
                }
                else{
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }
        if(cur1 == null){//某一链表遍历结束，将剩下的链表全部尾插至结果链表
            last.next = cur2;
        }else{
            last.next = cur1;
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
        Node h1 = new Node(1);
        Node h2 = new Node(3);
        Node h3 = new Node(5);
        Node h4 = new Node(6);
        Node h5 = new Node(7);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;

        Node l1 = new Node(2);
        Node l2 = new Node(3);
        Node l3 = new Node(4);
        Node l4 = new Node(7);
        Node l5 = new Node(8);
        Node l6 = new Node(9);
        Node l7 = new Node(10);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        print(mergeTwoLists(h1,l1));



    }
}
