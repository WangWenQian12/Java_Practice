class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }

}

public class DeleteDuplication {

    //删除链表中重复的所有结点
    //1.创建三个结点，pre = null，p1 = head，p2 = head.next；
    //2.如果p1.val不等于p2.val，那么三个结点一起往后遍历。
    //3.如果等于，p2往后遍历，直至不等于。
    //4.让pre.next = p2,然后继续重复以上步骤。

    public static Node deleteDuplication(Node head) {
        if (head == null) {
            return null;
        }

        Node pre = null;
        Node p1 = head;
        Node p2 = head.next;

        while (p2 != null) {
            if (p1.val != p2.val) {
                pre = p1;
                p1 = p2;
                p2 = p2.next;
            }
            else {
                while (p2 != null && p1.val == p2.val) {
                    p2 = p2.next;
                }
                if(pre == null){
                    head = p2;
                }
                else {
                    pre.next = p2;
                }
                p1 = p2;
                if(p2 != null){
                    p2 = p2.next;
                }
            }
        }
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
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(3);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(12);
        head.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next = new Node(13);
        print(head);
        print(deleteDuplication(head));

    }
}
