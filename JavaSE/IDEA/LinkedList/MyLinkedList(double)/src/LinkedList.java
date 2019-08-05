class Node{
    int val;
    Node next = null;
    Node prev = null;

    Node(int val){
        this.val = val;
    }
}

public class LinkedList {

    //双链表的插删
    //插入时注意插入前链表是否为空
    //删除时注意删除后链表是否为空

    Node head = null;
    Node last = null;
    int size = 0;

    //头插
    public void pushFront(int val){
        Node node  = new Node(val);
        node.next = head;
        if(head != null){
            head.prev = node;
        }
        else {
            last = node; //head为空时，只需将last置为node
        }
        head = node;//不管链表为不为空，都要将node置为head

        size++;
    }

    //尾插
    public void pushBack(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
        }
        else{
            last.next = node;
        }
        node.prev = last;
        last = node;
    }

    //头删
    public void popFront(){
        if(size <= 0){
            System.err.println("链表为空，无法进行删除！");
            return;
        }
        head = head.next;
        if(head != null) {
            head.prev = null;
        }
        else {
            last = head = null;
        }
        size--;
    }

    //尾删
    public void popBack(){
        if(size <= 0){
            System.err.println("链表为空，无法删除！");
            return;
        }
        if(last != null) {
            last = last.prev;
            last.prev = null;
        }else {
            head = last = null;
        }
        size--;

    }

    //插入
    public void push(int index,int val){
        if(index < 0 || index >size){
            System.err.println("error!");
            return;
        }

        if(index == 0){
            pushFront(val);
        }//头插

        else if(index == size){
            pushBack(val);
        }//尾插
        else {
            Node node = new Node(val);
            Node pos = getNode(index);
            node.prev = pos.prev;
            node.next = pos;
            node.prev.next = node;
            node.next.prev = node;

            size++;
        }

    }


    //删除
    public void delete(int index){

        if(head == null){
            System.err.println("链表为空，无法删除");
            return;
        }
        if(index < 0 || index >size){
            System.err.println("error!");
            return;
        }

        if(index == 0){
            popFront();
        }
        else if(index == size){
            popBack();
        }
        else {
            Node pos = getNode(index);
            pos.prev.next = pos.next;
            pos.next.prev = pos.prev;

            size--;
        }
    }

    //找到下标为index的结点，如果在前半部分从前往后找，反之从后往前走
    public Node getNode(int index){
        int back = size - 1 - index;
        Node pos;
        if(index <= back ){
            pos = head;
            for(int i=0;i<index;i++){
                pos = pos.next;
            }
        }
        else{
            pos = last;
            for(int i=0;i<back;i++){
                pos = pos.prev;
            }
        }
        return pos;
    }

    public void print(Node head){
        for(Node cur = head; cur != null;cur = cur.next){
            System.out.print(cur.val+"-->");
        }
        System.out.print("null");
        System.out.println();
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void reset() {
        head = last = null;
        size = 0;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.pushFront(3);
        list.pushFront(2);
        list.pushFront(1);

        System.out.println("1 2 3");

        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);

        System.out.println("1 2 3 10 20 30");

        list.popFront();
        list.popBack();

        System.out.println(" 2 3 10 20 ");

        list.push(1,20);
        list.push(3,60);

        System.out.println(" 2 20 3 60 10 20 ");

        list.delete(5);
        list.delete(2);

        System.out.println(" 2 20  60 10 ");

    }

    
}
