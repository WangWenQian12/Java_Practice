public class MyPriorityQueue {

    //优先级队列

    private static int[] array;
    private static int size;

    MyPriorityQueue(){
        array = new int[10];
        size = 0;
    }

    //插入元素
    public static void offer(int e){
        array[size++] = e;
        Heap.shiftUpSmall(array,size-1);
    }

    //删除元素(队首元素)
    public static int poll(){
        int tmp = array[0];
        array[0] = array[--size];
        Heap.shiftDown (array,0,size);
        return tmp;
    }

    //返回队首元素
    public static int peek(){
        return array[0];
    }

    public static void main(String[] args) {
        MyPriorityQueue queue =  new MyPriorityQueue ();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println (peek ());
        System.out.println (poll ());
        System.out.println (peek ());
    }
}
