class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }
}

public class Division {

    //以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 。
    //1.创建俩个新的链表，一个存放小于x的值，一个存放大于x的值
    //2.遍历链表，将小于x的值尾插至less中，大于x的值尾插至more中
    //3.连接俩个链表，less的最后的一个结点的next改为more的头结点

    public static Node disList(Node head,int x){
        Node less = null;
        Node more = null;
        Node lessLast = null;
        Node moreLast = null;

        Node cur = head;
        while(cur != null){
            if(cur.val < x){
                if(less == null){
                    less = cur;
                }
                else{
                    lessLast.next = cur;
                }
                lessLast = cur;
            }else{
                if(more == null){
                    more = cur;
                }
                else{
                   moreLast.next = cur;
                }
                moreLast = cur;
            }
            cur = cur.next;
        }

        if(less == null){
            return more;
        }else{
            if(more == null){
                return less;
            }
            lessLast.next = more;
        }


        return less;
    }

    public static void print(Node head){
        for(Node cur=head;cur != null;cur = cur.next){
            System.out.print(cur.val+"-->");
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        Node h1 = new Node(5);
        Node h2 = new Node(8);
        Node h3 = new Node(3);
        Node h4 = new Node(7);
        Node h5 = new Node(2);
        Node h6 = new Node(1);
        Node h7 = new Node(9);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = h7;

        print(disList(h1,5));

    }
}
