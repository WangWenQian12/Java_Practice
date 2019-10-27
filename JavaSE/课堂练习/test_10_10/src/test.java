import java.util.*;

class Node{
    int key;
    Node left;
    Node right;
    Node next;
    Node random;

    Node(int key){
        this.key = key;
    }

}

public class test {

    //课后题（一定记得写）

    //返回Set<>
    //获取二叉树的所有的key
    //直接遍历

    //深拷贝链表
    public Node copyList(Node head){

        //先复制一份链表，然后让l1的头指向和h1的头，h1.next再指向l1.next

        //复制、糅合俩个链表
        Node cur = head;
        while(cur != null){
            Node node = new Node(cur.key);
            node.next = cur.next;
            cur.next = node;

            cur = node.next;
        }

        //复制random指向
        cur = head;
        while(cur != null){
            Node node = cur.next;
            if(cur.random != null){
                node.random = cur.random.next;
            }
            cur = node.next;
        }

        //把俩个链表拆开
        cur = head;
        Node newHead = head.next;
        while(cur != null){
            Node node = cur.next;

            cur.next = node.next;
            if(node.next != null) {
                node.next = cur.next.next;
            }

            cur = cur.next;
        }
        return newHead.next;

    }


    //深度拷贝  Map   利用映射关系
    //遍历原链表，复制出来做尾插
    //MapTree中要求key可以进行比较，而Node要比较就需要构造一个比较器
    public static Node complexCopy(Node head){
        Map<Node,Node> map = new TreeMap<> (new NodeComparator());

        Node newHead = null;
        Node newLast = null;

        Node cur = head;
        while(cur != null){
            if(newHead == null){
                newHead = cur;
            }else{
                newLast.next = cur;
            }
            newLast = cur;

            cur = cur.next;
        }


    }


    //宝石与石头
    public int numJewelsInStons(String J,String S){
        //把所有宝石放到一个集合里
        Set<Character> jewels = new TreeSet<> ();
        for(char j : J.toCharArray ()){
            jewels.add(j);
        }

        //遍历所有石头
        int count = 0;
        for(char s : S.toCharArray ()){
            if(jewels.contains (s)){
                count++;
            }
        }
        return count;

    }


    //看键盘中哪些键坏了





    public static void main(String[] args) {


    }
}
