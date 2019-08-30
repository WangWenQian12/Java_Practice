class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }
}

public class GetIntersectNode {

    //输入两个链表，找出它们的第一个公共结点。
    //思路：
    //1.俩个链表长度可能相等，也可能不相等。
    //2.当链表长度不相等时，应先让长链表的指针提前遍历长度差个结点。
    //3.然后俩个链表的指针一起走，直到他们所指的结点相等时，找到公共结点。

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

        int steps = len1-len2;
        Node longer = l1;
        Node shorter = h1;

        if(steps < 0){
            steps = len2-len1;
            longer = h1;
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
        for(Node cur=head;cur != null;cur = cur.next){
            System.out.print(cur.val+"-->");
        }
        System.out.print("null");
        System.out.println();
    }


    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(3);
        Node l4 = new Node(4);
        Node l5 = new Node(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Node h1 = new Node(6);
        Node h2 = new Node(7);
        Node h3 = new Node(8);
        Node h4 = new Node(9);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = l3;

        System.out.println(getIntersectNode(l1,h1).val);

    }
}
