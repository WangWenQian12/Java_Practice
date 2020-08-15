class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }
}

public class JudegCycle {

    //判断链表中是否有环，如果有环，找到入环点
    //思路：
    //1.快慢指针找到相遇点后，jiang相遇点的next置为空
    //2.转换为了俩个链表求相遇结点的问题

    public static int getLength(Node head){
        Node cur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }

    public static Node getIntersectNode(Node l1,Node h1){
        int len1 = getLength(l1);
        int len2 = getLength(h1);

        int steps = len1-len2;//找到链表长度差
        Node p = l1;
        Node q = h1;
        if(steps<0){
            steps = len2 - len1;
            p = h1;
            q = l1;
        }

        for(int i = 0;i<steps;i++){//长链表先走steps步
            p = p.next;
        }

        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static Node getCycleNode(Node head){
        Node fast = head;
        Node slow = head;

        //找到相遇结点
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

        Node l1 = slow.next;//把链表拆成俩个有相交的链表
        fast.next = null;
        Node l2 = head;

        return getIntersectNode(l1,l2);


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
