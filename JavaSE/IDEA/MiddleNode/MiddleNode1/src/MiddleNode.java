class Node{
    int val ;
    Node next = null;

    Node(int val){
        this.val = val;
    }

}

public class MiddleNode {

    //找到链表中间的结点,如果链表结点个数为偶数则打印中间俩个靠后的那个结点
    //1.遍历得到链表结点长度
    //2.链表长度除以二，得到mid，直接将链表遍历mid个，得到midNode
    public static int getLength(Node head){
        int len =0;
        for(Node cur = head;cur != null;cur = cur.next){
            len++;
        }
        return len;
    }

    public static Node middleNode(Node head){
        int mid = getLength(head)/2;
        Node cur = head;
        for(int i=0;i<mid;i++){
            cur = cur.next;
        }
        return cur;

    }
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(12);
        head.next.next.next.next.next = new Node(8);
        System.out.println((middleNode(head).val));
    }

}
