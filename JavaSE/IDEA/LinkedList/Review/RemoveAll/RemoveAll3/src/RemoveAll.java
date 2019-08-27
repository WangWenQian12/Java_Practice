class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }

    public String toString(){
        return String.format("%d",val);
    }
}

public class RemoveAll {

    //删除链表中所有值为val的结点
    //思路：
    //1.删除结点需要其前驱结点
    //2.需要考虑头结点的值为val的情况
    //1）先处理头结点值等于val的情况
    //2）Node一个新结点newHead
    //3）特殊处理

    public static Node removeAll(Node head,int val){
        Node pre = null;
        Node cur = head;
        while(cur != null){
            if(cur.val == val){
                if(head == cur){
                    head = cur.next;//如果val相等，且为头结点，则让head = cur .next
                }
                else{
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

    public static void print(Node head){
        for(Node cur = head;cur != null;cur = cur.next){
            System.out.print(cur+"-->");
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
        print(removeAll(head, 3));
    }
}
