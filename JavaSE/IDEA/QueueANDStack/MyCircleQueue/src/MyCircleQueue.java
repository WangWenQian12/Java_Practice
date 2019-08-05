public class MyCircleQueue {

    //MyCircularQueue(k): 构造器，设置队列长度为 k 。
    //	Front: 从队首获取元素。如果队列为空，返回 -1 。
    //	Rear: 获取队尾元素。如果队列为空，返回 -1 。
    //	enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
    //	deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
    //	isEmpty(): 检查循环队列是否为空。
    //	isFull(): 检查循环队列是否已满。

    private int[] array;
    private int size;
    private int front;
    private int rear;

    public MyCircleQueue(int k){
        array = new int[k];
        size = 0;
        front = 0;
        front = 0;
    }

    //插入
    public boolean enQueue(int value){
        if(size == array.length){
            return false;//此时队列已满
        }
        array[rear] = value;
        rear = (rear+1)%array.length;
        size++;
        return true;
    }

    //删除
    public boolean deQueue(){
        if(size == 0){
            return false;
        }
        front = (front+1)%array.length;
        size--;
        return false;
    }

    //获取首元素
    public int getFront(){
        if(size == 0 ){
            return -1;
        }
        return array[front];
    }

    //获取尾元素
    public int getRear(){
        if(size == 0){
            return -1;
        }
        int index = (rear + array.length -1)%array.length;
        return array[index];
    }

    //判空
    public boolean isEmpty(){
        return size == 0;
    }

    //判满
    public boolean isFull(){
        return size == array.length;
    }

    public static void main(String[] args) {
        MyCircleQueue circle = new MyCircleQueue(6);

        System.out.println(circle.enQueue(7));
        System.out.println(circle.enQueue(3));
        System.out.println(circle.enQueue(2));
        System.out.println(circle.enQueue(5));
        System.out.println(circle.enQueue(8));
        System.out.println(circle.enQueue(1));
        System.out.println(circle.enQueue(9));

        System.out.println(circle.getFront());//7
        System.out.println(circle.getRear());//1

        System.out.println(circle.deQueue());
        System.out.println(circle.getFront());//3
        System.out.println(circle.getRear());//1

        System.out.println(circle.isEmpty());
        System.out.println(circle.isFull());



    }
}
