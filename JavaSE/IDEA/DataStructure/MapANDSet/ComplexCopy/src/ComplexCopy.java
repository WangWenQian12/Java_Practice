import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ComplexCopy {

    //给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    //要求返回这个链表的深拷贝。

    private static class Node{
        int val;
        Node next;
        Node random;

        Node(){}

        Node(int val){
            this.val = val;
        }


        Node(int val,Node next,Node random){
            this.val = val;
            this.next = next;
            this.random = random;
        }

    }

    private static class NodeComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.val - o2.val;
        }
    }


    public static Node complexCopy(Node head){
        Map<Node,Node> map = new TreeMap<> (new NodeComparator());

        Node newHead = null;
        Node newLast = null;
        Node cur = head;
        while(cur != null){
            Node node = new Node();
            node.val = cur.val;
            if(newHead == null){
                newHead = node;
            }else{
                newLast.next = node;
            }
            newLast = node;
            map.put(cur,node);//映射关系为：key为每一个结点，val为赋值的链表
            cur = cur.next;
        }

        //put Random指向
        cur = head;
        Node node = newHead;
        while(cur != null){
            if(cur.random != null){
                node.random = map.get(cur.random);
            }else{
                node.random = null;
            }

            cur = cur.next;
            node = node.next;
        }
        return newHead;
    }

    public static void print(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.val + "-->");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        Node l1 = new Node(3);
        Node l2 = new Node(4);
        Node l3 = new Node(10);
        Node l4 = new Node(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l1.random = l2;
        l2.random = l1;
        l3.random = l3;
        l4.random = null;

        print(complexCopy(l1));
        System.out.println((complexCopy(l1).random).val);
    }


}
