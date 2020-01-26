class Node{
    Node next = null;
    int val;

    Node(int val){
        this.val = val;
        this.next = next;
    }
}


public class RemoveAll {

    //删除链表中所有值为val的结点
    //思路：
    //1.删除链表中的结点需要找到他的前驱结点
    //2.需要考虑头结点等于val的情况：
    //1）先处理其他节点，再处理头结点
    //2）实例化一个新的头结点
    //3）特殊处理

    public static Node removeAll(Node head,int val){

        if(head.val == val){
            head = head.next;
        }

        Node cur = head;
        Node pre = null;

        while(cur != null){
            if(cur.val == val){
                 pre.next = cur.next;
            }
            else{
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }

    public static void print(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.val+"-->");
            cur = cur.next;
        }
        System.out.println("null");
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
        print(removeAll(head, 3));
    }
}
