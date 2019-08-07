class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }
}


public class DetectCycle {

    //判断链表中是否有环
    //1.快慢俩个引用，慢的走一步，快的走俩步（快的走3步或大于2步，俩个会错过，一直都遇不到）
    //2.如果快的遇到null，说明没有环
    //3.如果快的和慢的相遇，说明有环

    //如果有环，求入环点
    //定理：一个结点p从head开始走，一个结点从相遇点开始走，那么他们相遇的地方就是入环点

    public static Node detectCycle(Node head){
        Node fast = head;
        Node slow = head;
        do{
            if(fast == null){ //如果fast遇到null，表示没环
                return null;
            }
            fast = fast.next;
            if(fast == null){
                return null;
            }
            fast = fast.next;
            slow = slow.next;
        }while(fast != slow);

        //求入环点
        Node p = head;
        Node q = slow;
        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        Node h1 = new Node(7);
        Node h2 = new Node(1);
        Node h3 = new Node(2);
        Node h4 = new Node(3);
        Node h5 = new Node(4);
        Node h6 = new Node(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = h3;

        System.out.println(detectCycle(h1).val);

    }
}
