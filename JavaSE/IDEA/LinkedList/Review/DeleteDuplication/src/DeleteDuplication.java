class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }
}

public class DeleteDuplication {

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    //思路：
    //1. 创建三个指针，p1 = head，p2 = head.next，p3 = null
    //2.当p1不等于p2的话三个指针一起向后遍历
    //3.当p1等于p2，p1不动，p2往后遍历，直至p1不等于p2
    //4.此时，让pre.next等于p2，p1=p2,重复以上步骤
    //要考虑链表最开始就有重复的结点，直接让head=p2

    public static Node deleteDuplication(Node head){
        Node pre = null;
        Node p1 = head;
        Node p2 = head.next;

        while(p2 != null){
            if(p1.val != p2.val){
                pre = p1;
                p1 = p2;
                p2 = p2.next;
            }else{
                while(p2 != null && p1.val == p2.val){//p2不为空，且俩个结点的值相等
                    p2 = p2.next;
                }
                if(pre == null){//链表刚开始就有重复结点的情况
                    head = p2;
                }else{
                    pre.next = p2;
                }
                p1 = p2;//同时往后遍历
                if(p2 != null){
                    p2 = p2.next;
                }
            }
        }
        return head;
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
        Node h2 = new Node(4 );
        Node h3 = new Node(3);
        Node h4 = new Node(7);
        Node h5 = new Node(8);
        Node h6 = new Node(8);
        Node h7 = new Node(8);
        Node h8 = new Node(9);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = h7;
        h7.next = h8;

        print(deleteDuplication(h1));
    }
}
