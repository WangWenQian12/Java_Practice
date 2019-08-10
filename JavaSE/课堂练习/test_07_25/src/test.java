class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }
    public String toString(){
        return String.format("Node(%d)",val);
    }

}


public class test {

    //头插
    public static Node pushFront(Node head,int val){
        Node node = new Node(val);
        node.next = head;
        return node;
    }

    //尾插
    public static Node pushBack(Node head,int val){
        Node node = new Node(val);
        if(head==null){
            return node;
        }
        Node last = head;
        while(last.next!=null) {
            last = last.next;
        }
        last.next = node;
        return head;
    }

    //逆置
    public static Node reverse(Node head){
        Node p1 = null;
        Node p2 = head;
        while(p2!=null){
            Node p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        return p1;
    }

    //在pos之后插入新结点
    private static void pushAfter(Node pos,int val){
        Node node = new Node(val);
        node.next = pos.next;
        pos.next = node;
    }


    //删除pos后的结点
    private static void popAfter(Node pos){
        pos.next = pos.next.next;
    }

    //删除链表中所有的val
    public Node removeElements(Node head,int val){
         Node result = null;
         Node last = null;
         Node cur  = head;

         while(cur!=null){
             if(cur.val == val){
                 cur = cur.next;
                 continue;
             }
         }
    }


    //如果head等于val
    public Node removeEle(Node head,int val){
        Node tmpHead = new Node(-1);
        tmpHead.next = head;
        Node prev = tmpHead;
        Node cur = head;

        while(cur!=null){
            if(cur.val==val){
                prev.next = cur.next;
            }
            else{
                prev = cur;
            }
            cur = cur.next;
        }
        return tmpHead.next;
    }

    //将俩个有序链表合并成一个有序列表
    public Node mergeTwoLists(Node l1,Node l2){

        if(l1==null){return l2;}
        if(l2==null){return l1;}

        Node result  = null;
        Node last = null;

        Node cur1 = l1;
        Node cur2 = l2;

        while(cur1!=null && cur2!=null){
            if(cur1.val <= cur2.val) {
                //尾插
                Node next = cur1.next;
                if (result == null) {   //走且仅走一次
                    result = cur1;
                }
                else{
                    last.next = cur1;//last始终指向result的最后一个结点
                }
                last = cur1;
                cur1 = next;
            }
            else{
                Node next = cur2.next;
                if (result == null) {
                    result = cur2;
                }
                else{
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
            if(cur1 != null){
                last.next = cur2;
            }
            else{
                last.next = cur1;
            }
        }
        return result;

    }

    //打印
    public static void print(Node head){

    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        pushFront(head,3);


    }

}
