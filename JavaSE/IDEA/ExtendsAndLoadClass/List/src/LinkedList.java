import java.util.Arrays;

class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }
}

public class LinkedList extends List {
    private Node first = null;

    @Override
    public void insert(int index, int val) {//重写父类中的insert方法

        Node node = new Node(val);
        if(index == 0){//头插
            node.next = first;
            first = node;
        }else if(index == size){//尾插
            Node last =  first;
            while(last.next != null){
                last = last.next;
            }
            last.next = node;
            node.next = null;
        }else{//随插
            Node pre = first;
            for(int i=0;i<index-1;i++){
                pre = pre.next;
            }
            node.next = pre.next;
            pre.next = node;
        }
        size++;
        int[] a = new int[size];
        Node cur = first;
        int i = 0;
        while (cur != null) {
            a[i] = cur.val;
            i++;
            cur = cur.next;
        }

        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushFront(10);
        list.pushFront(20);
        list.pushFront(30);
        list.insert(3, 100);
    }
}
