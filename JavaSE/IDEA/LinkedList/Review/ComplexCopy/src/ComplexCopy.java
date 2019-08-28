class CNode{
    int val;
    CNode next = null;
    CNode random = null;

    CNode(int val){
        this.val = val;
    }
}

public class ComplexCopy {

    //现有一链表每个结点除过其next指向，还附带一可指向任何结点的random指向，先对此链表进行深度拷贝
    //思路：
    //1.先拷贝一份只有val和next指向的链p2
    //2.将链表p1和p2糅合在一起，在p1不为空的情况下，让p2.next = p1.next；p1.next = p2；
    //3.拷贝其random指向
    //4.将俩个表分开

    public static CNode complexCopy(CNode head){
        if(head == null){
            return null;
        }

        //拷贝val和next指向
        CNode p1 = head;
        while(p1 != null){
            CNode p2 = new CNode(p1.val);
            p2.next = p1.next;
            p1.next = p2;

            p1 = p2.next;
        }

        //赋值random指向
        p1 = head;
        while(p1 != null){
            CNode p2 = p1.next;
            if(p1.random != null){
                p2.random = p1.random.next;
            }
            p1 = p2.next;
        }

        //拆分表
        p1 = head;
        CNode result = head.next;//找到赋值的链表的head
        while(p1 != null) {
            CNode p2 = p1.next;
            p1.next = p2.next;
            if(p2.next != null){
                p2.next = p2.next.next;
            }

            p1 = p1.next;
        }
        return result;
    }

    public static void print(CNode head){
        CNode cur = head;
        while(cur != null){
            System.out.print(cur.val + "-->");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        CNode h1 = new CNode(1);
        CNode h2 = new CNode(3);
        CNode h3 = new CNode(5);
        CNode h4 = new CNode(7);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h1.random = h3;
        h2.random = h1;
        h3.random = h3;
        h4.random = null;

        print(complexCopy(h1));
        System.out.println((complexCopy(h1).random).val);

    }
}
