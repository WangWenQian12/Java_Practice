import java.sql.SQLOutput;

class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }
}


public class test {

    //删除有序链表中重复的结点
    public static Node deleteAll(Node head){
        Node p1 = head;
        Node p2 = head.next;
        Node pre = null;
        while(p2 != null){
            if(p1.val != p2.val){//没有重复，一起往后遍历
                pre = p1;
                p1 = p2;
                p2 = p2.next;
            }else {//相等删除，需要前驱结点
                while (p2 != null && p1.val == p2.val) {//发现重复，p2往后走，直到不相等
                    p2 = p2.next;
                }
                if (pre == null) {//此时是链表开始就是重复的，所以pre依旧为空，让head直接等于p2
                    head = p2;
                } else {
                    pre.next = p2;//如果是中间有重复结点，则让pre.next=p2，然后三个指针归位
                }
                p1 = p2;
                if(p2 != null) {
                    p2 = p2.next;
                }
            }
        }
        return head;
    }


    //继承：ArrayList继承自List

    


    public static void main(String[] args) {

    }
}
