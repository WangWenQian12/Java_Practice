class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }

}


public class test {

    //合并俩个有序链表
    public Node mergeTwoLists(Node l,Node h){
        Node newHead = null;
        Node last = null;

        Node cur1 = l;
        Node cur2 = h;

        while(cur1 != null && cur2 != null){
            if(cur1.val <cur2.val){
                //尾插
                Node next = cur1.next;
                if(newHead == null){
                    newHead = cur1;
                }else{
                    last.next = cur1;
                }
                last = cur1;
                cur1 = next;
            }else{
                Node next = cur2.next;
                if(newHead == null){
                    newHead = cur2;
                }else{
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }//此循环结束说明有一个链表已遍历结束

        //某一链表遍历结束，将剩下的链表全部尾插至结果链表
        if(cur1 == null){
            last.next = cur2;
        }else{
            last.next = cur1;
        }

        return newHead;

    }


}
