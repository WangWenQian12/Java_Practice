class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }

}

public class DetectCycle {

    //找到入环结点
    //快引用走俩步，慢引用走一步，找到相遇点
    //将相遇点.next = null,转换为求相交结点的问题

    public static Node detectCycle(Node head){

        Node fast = head;
        Node slow = head;
        Node l1 = null;
        l1 = head;

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

        Node l2 = slow.next;
        slow.next = null;//将相遇结点的next置为空

        //此时fast为短链表，fast为长链表，转换为俩个链表求相交结点的问题

        return getIntersectionNode(l1,l2);

    }

    public static int getLength(Node head){
        int len = 0;
        for(Node cur = head;cur != null;cur = cur.next){
            len++;
        }
        return len;
    }

    public static Node getIntersectionNode(Node l1,Node l2){
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        int steps = len1-len2;
        Node longer = l1;
        Node shorter = l2;
        if(len1 < len2){
            steps = len2 -len1;
            longer = l2;
            shorter = l1;
        }
        for(int i=0;i<steps;i++){
            longer = longer.next;
        }
        while(longer != shorter){
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;

    }

    public static void print(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.val+"-->");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
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

        print(detectCycle(h1));
    }
}
