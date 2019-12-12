

class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }

}

public class Partition {

    //给定val,将链表中小于val的结点放到前面，等于大于val的结点放到后面，分割后保持原来的相对顺序不变
    //创建俩个新链表，less用来保存小于val的结点，great用来保存大于等于val的结点
    //Node cur = head，让cur遍历源链表，小于vla的尾插到less，大于的尾插到great
    //如若less和great均不为空，令lessLast.next = great，greatLess.next = null,输出less
    //如若less为空，输出great
    //如若great为空，输出less
    public static Node partition(Node head,int val){
        Node less = null;
        Node great = null;
        Node lessLast = null;
        Node greatLast = null;

        Node cur = head;
        while(cur != null){
            if(cur.val < val){
                //尾插
                if(less == null){
                    less = cur;
                }
                else{
                    lessLast.next = cur;
                }
                lessLast = cur;
            }
            else{
                if(great == null){
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
            return great;
        }
        else {
            lessLast.next = great;
            if (greatLast != null) {
                greatLast.next = null;
            }

            return less;
        }
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


    public static void main(String[] args){
        Node head = new Node(3);
        head.next = new Node(6);
        head.next.next = new Node(2);
        head.next.next.next = new  Node(7);
        head.next.next.next.next = new  Node(5);
        print(head);
        print(partition(head,6));

    }
}
