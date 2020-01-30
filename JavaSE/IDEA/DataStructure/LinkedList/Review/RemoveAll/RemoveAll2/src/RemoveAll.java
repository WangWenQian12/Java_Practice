
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
    //1.删除结点必须找到其前驱结点
    //2.应考虑头结点的值等于val的情况：
    //1）先考虑头结点的值等于val的情况
    //2）Node一个新的头结点
    //3）特殊处理

    public static Node removeAll(Node head,int val){
        Node newHead = new Node(-1);
        newHead.next = head;
        Node  cur = newHead;
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
        return newHead.next;
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
