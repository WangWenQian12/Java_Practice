class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }
}

public class FindKthToTail {

    //找到链表中的倒数第k个结点
    //1.创建俩个结点，让第一个引用先往后遍历k个，然后和第二个一起往后遍历
    //2.当第一个引用为空时，第二个引用所指向的为倒数第k个结点
    public static Node findKthToTail(Node head,int k){
        Node p1 = head;
        Node p2 = head;

        /*int len = getLength(head);
        if(len<k){
            return null;
        }*/
        for(int i = 0;i<k;i++){
            if(p1 == null){
                return null;
            }
            p1 = p1.next;
        }
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }

    public static int getLength(Node head){
        int len =0;
        for(Node cur = head;cur != null;cur = cur.next){
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(12);
        System.out.println(findKthToTail(head,2).val);
    }
}
