



class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }
}

/*public class test {

    //逆置链表
    public static Node reverseList(Node head){
        Node cur = head;
        Node result = null;

        while(cur != null){//头插
            Node next = cur.next;
            cur.next = result;
            result = cur;
            cur = cur.next;
        }
        return result;
    }

    //递归
    public static Node reverse2(Node head){
        if(head == null && head.next == null){
            return head;
        }
        Node result = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    //合并链表
    public static Node mergeTwoLists(Node l1,Node h1){
        Node result = null;
        Node last = null;

        Node cur1 = l1;
        Node cur2 = h1;
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){//尾插
                Node next = cur1.next;
                if(result == null){
                    result = cur1;
                }else{
                    last.next = cur1;
                }
                last = cur1;
                cur1 = next;
            }else{
                Node next = cur2.next;
                if(result == null){
                    result = cur2;
                }else{
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }

        return result;
    }

    public static void print(Node head){
        for(Node cur = head;cur != null;cur = cur.next){
            System.out.print(cur.val+"-->");
        }
        System.out.print("null");
        System.out.println();

    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(3);
        Node l3 = new Node(4);
        Node l4 = new Node(5);
        Node l5 = new Node(6);
        Node l6 = new Node(19);
        l1.next= l2;
        l2.next= l3;
        l3.next= l4;
        l4.next= l5;
        l5.next= l6;

        Node h1 = new Node(2);
        Node h2 = new Node(5);
        Node h3 = new Node(7);
        Node h4 = new Node(8);
        Node h5 = new Node(9);
        Node h6 = new Node(12);
        Node h7 = new Node(13);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = h7;

        print(mergeTwoLists(l1,h1));

    }

}*/

public class test{
    int size = 0;

    public void insert(int index,int val){
        System.out.println("null");
    }
    public void pushFront(int val){
        insert(0,val);
    }
    public void pushBack(int val){
        insert(size,val);
    }
}

