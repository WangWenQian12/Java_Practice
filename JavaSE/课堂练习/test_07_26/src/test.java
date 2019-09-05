
class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }

}

public class test {


    //将链表中小于v的结点全都放前面，大于v的全部放后面，分割后保持原来的相对顺序不变
    public Node partition(Node head,int x){
        Node less = null;
        Node lessLast = null;
        Node great = null;
        Node greatLast = null;

        Node cur = head;
        while(cur != null) {
            if (cur.val < x) {
                //尾插至less
                if (less == null) {
                    less = cur;
                } else {
                    lessLast.next = cur;
                }
                lessLast = cur;
            } else {
                if (great == null) {
                    great = cur;
                } else {
                    greatLast.next = cur;
                    cur = cur.next;
                }
            }
            cur = cur.next;
        }
            //lessLast指向great
            //greatLast指向null
            if(less == null){
                return great;
            }
            else{
                lessLast.next = great;
                if(greatLast != null){
                    greatLast.next = null;
                }
            }
        return less;
    }

    //返回链表中间结点
    //1.遍历

    //2.俩个引用



    //输出链表的倒数第k个结点
    //1.求长度，遍历 长度-k
    public int getLength(Node head){
        int len = 0;
        Node cur = head;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        return len;
    }
    public Node FindKthToTail(Node head,int k){
        int len = getLength(head)/2;
        Node cur = head;
        for(int i=0;i<len;i = i+1){
            cur = cur.next;
        }
        return cur;
    }

    //2.俩个引用，先让第一个走k步，然后俩个一起走，第一个走到null时，第二个走到的位置就是k
    public Node FindKthToTail2(Node head,int k) {

        Node first = head;
        Node last = head;

        Node cur = head;
        for(int i = 0;i<k;i++) {

        }

    }

    //不知前驱，删除非末尾结点
    //替换法


    //判断链表的回文结构
    //找到中间结点，将后半部分逆置
    //时间复杂度0（n）,空间复杂度0（1）
    public boolean chkPalindrome(Node A){

    }


    //排好序的链表中有重复结点，把重复的全部删掉
    //三个引用


    public static Node removeAll(Node head,int val){
        Node tmpHead = null;
        tmpHead.next = head;
        Node pre = null; //用来删除
        Node cur = head; //用来遍历

        if(head.val == val){
            head = head.next;
        }
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

    public static Node merge(Node l1,Node l2){
        if(l1 == null){
        return l2;
    }
        if(l2 == null){
        return l1;
        }

        Node cur1 = l1;
        Node cur2 = l2;

        Node result = null;
        Node last = null;

        while(cur1 != null  && cur2 != null) {
            if (cur1.val <= cur2.val) {
                Node next = cur1.next;
                if (result == null) {
                    result = cur1;
                } else {
                    last = cur1.next;
                }
                last = cur1;
                cur1 = next;
            } else {
                Node next = cur2.next;
                if (result == null) {
                    result = cur2;
                } else {
                    last = cur2.next;
                }
                last = cur2;
                cur2 = next;
            }
        }
            if(cur1 == null){
                last.next = cur2;
            }
            else{
                last.next = cur1;
            }
            return result;
    }

    public static void main(String[] args) {

    }
}
