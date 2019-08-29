class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }

}

public class JudgeCycle {

    //判断链表中是否有环，如果有环，找到入环点
    //思路：
    //1.Node快慢指针，快的走俩步，慢的走一步（快的如果多于俩步会出错）
    //2.如果有环，快指针和慢指针会在某一结点处相遇
    //3.此时找入环点，Node指针p从head出发，指针q从相遇点出发
    //4.指针p和q相遇的结点就为入环点

    public static Node getCycleNode(Node head){
        Node fast = head;
        Node slow = head;

        //因为fast和slow在刚开始时都指向head，
        //如果是while循环，俩个指针在第一个结点处就会停下来
        //所以用do循环让整个循环至少循环一次
        do{
            if(fast == null){
                return null;
            }
            fast = fast.next;
            if(fast == null){
                return null;
            }
            fast = fast.next;
            slow = slow.next;
        }while(fast != slow);

        Node p = head;
        Node q = slow;
        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(3);
        Node l4 = new Node(4);
        Node l5 = new Node(5);
        Node l6 = new Node(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l3;

        System.out.println(getCycleNode(l1).val);
    }
}
