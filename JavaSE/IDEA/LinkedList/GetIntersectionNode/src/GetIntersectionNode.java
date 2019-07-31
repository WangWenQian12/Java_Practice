
class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }
}

public class GetIntersectionNode {

    //判断俩个链表是否相交过
    //注意：俩个链表相交于一结点，之后的链表肯定是一样的，因为一个结点不可能同时有俩个next
    //1.求出俩个链表的长度len1，len2
    //2.俩长度之差记为steps，让长链表先遍历steps个结点
    //3.然后俩个链表一起向后走

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

        int steps = len1 - len2;
        Node longer = l1;
        Node shorter = l2;

        if(len1 < len2){
            steps = len2-len1;
            longer = l2;
            shorter = l1;
        }

        for(int i = 0;i<steps;i++){
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
        Node l1 = new Node(3);
        Node l2 = new Node(4);
        Node l3 = new Node(10);
        Node l4 = new Node(8);
        Node l5 = new Node(6);
        Node l6 = new Node(6);
        Node l7 = new Node(6);
        Node l8 = new Node(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l8.next = l7;
        l7.next = l4;





        System.out.println(getIntersectionNode(l1,l8).val);
        //print(getIntersectionNode(l1,h1));
    }
}
