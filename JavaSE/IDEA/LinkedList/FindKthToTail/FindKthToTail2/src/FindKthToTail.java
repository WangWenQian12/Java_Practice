class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }
}

public class FindKthToTail {

    //找到链表中的倒数第k个结点
    //1.求得链表长度len
    //2.创建一个新的引用指向head
    //3.head遍历len-k个结点得到的就是倒数第k个结点

    public static Node FindKthToTail(Node head,int k){
        int len = getLength(head);

        if(len < k){
            return null;
        }
        int steps = len-k;
        Node result  = head;
        for(int i = 0;i<steps;i++){
            result = result.next;
        }
        return result;

    }

    public static int getLength(Node head){
        int len = 0;
        for(Node cur = head;cur != null;cur = cur.next){
            len++;
        }
        return len;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(12);
        head.next.next.next.next.next = new Node(8);
        System.out.println((FindKthToTail(head,5).val));
    }

}
