class Node{
    int val;
    Node next = null;
    Node(){

    }

    Node(int val){
        this.val = val;
    }
    //public String toString(){

    //}

}



public class test {

    public static Node separateX(Node head,int x){
        Node less = null;
        Node lessLast = null;
        Node great = null;
        Node greatLast = null;

        Node cur = head;
        while(cur != null){
            if(cur.val < x){
                //尾插
                if(less == null) {
                    less = cur;
                }
                else{
                    lessLast.next = cur;
                }
                lessLast = cur;//尾插时需要找到链表的最后一个结点，可以记录每次插入的结点，必为最后一个结点

            }
            else{
                if(great == null) {
                    great = cur;
                }
                else{
                    greatLast.next = cur;
                }
                greatLast = cur;
            }
            cur = cur.next;
        }
        if(less == null){
            return great;//原来链表一定为空
        }
        else{
            lessLast.next = great;
            if(greatLast != null){
                greatLast.next = null;
            }
            return less;
        }
    }


    //删除重复结点

    //判断俩个链表是否相交过
    //1.求出俩个链表长度k1，k2
    //2.让长链表先走k1-k2，然后俩个一起走



    //判断链表是否带环
    //快慢指针，慢的指针一次一步，快的一次俩步
    //fast = null,不带环


    public static Node detectCycle(Node head){
        Node fast = head;
        Node slow = head;

        do {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next;
        }while(fast != slow);

        Node p = head;
        Node q = slow;
        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }

    //俩个链表可能相交，可能带环（相交在环外，相交在环内）
    //6种情况

    //复制链表
    //遍历原链表，尾插新的链表里

    public static Node copyList(Node head){
        Node cur = head;
        Node result = null;
        Node last = null;
        while(cur != null){
            Node node = new Node();
            node.val = cur.val;
            if(result == null){
                result = node;
            }
            else{
                last.next = node;
            }
            last = node;
            cur = cur.next;
        }
        return result;
    }

    //深拷贝链表，每个链表都附有一个随机的指针，将背后的指向也要拷贝过来
    //大思路：先复制所有的结点，处理random指向
    //1）拆next的指向，利用p1遍历原链表的每个结点，创建新节点p2，把p2依次插到p1后面
    //2)处理random指向，p1 = head;   p2 = p1.next;  p2.random = p1.random.next;
    //3)俩个链表断开，p1.next = p2.next; if(p2.next != null){p2.next = p2.next.next;} p1 = p1.next;
    //4)返回复制的链表时，在最前面创建一个newHead，返回newHead



    //怎么找环的入口点
    //1.快慢指针相遇的地方的next置为空，转换为求相交结点的问题
    //2.一个引用从起点出发，一个引用从相遇点出发，一定会在环的入口处相遇




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
        Node head = new Node(3);
        head.next = new Node(6);
        head.next.next = new Node(2);
        head.next.next.next = new  Node(7);
        head.next.next.next.next = new  Node(5);
        print(head);
        print(separateX(head,3));


    }
}
