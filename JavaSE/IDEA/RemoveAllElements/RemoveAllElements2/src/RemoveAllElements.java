
class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val= val;
        this.next = next;
    }
}

public class RemoveAllElements {

    /*
    * 如果head就等与val的话，会造成pre空指针异常，所以我们定义一个形式tmpHead
    * tmpHead为链表的头结点，tmpHead.next为head
    * */
    public static Node removeAll(Node head,int val){
        Node tmpHead = new Node(-1);
        tmpHead.next = head;
        Node pre = null;
        Node cur = head;

        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }
            else{
                pre = cur;
            }
           cur = cur.next;
        }
        return tmpHead.next;
    }

    //尾插
    public static Node pushBack(Node head,int val){
        Node node = new Node(val);
        if(head == null){
            return node;
        }
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = node;
        return head;
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
        Node head = null;
        head =pushBack(head,1);
        head =pushBack(head,3);
        head =pushBack(head,3);
        head =pushBack(head,4);
        head =pushBack(head,3);
        head =pushBack(head,7);
        head =pushBack(head,9);
        print(removeAll(head,3));
    }
}
