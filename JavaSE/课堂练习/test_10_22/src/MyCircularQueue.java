public class MyCircularQueue {

    private int[] array;
    private int size;
    private int front;
    private int rear;

    public MyCircularQueue(int k){
        array = new int[k];
        size = 0;
        front = 0;
        rear = 0;
    }
    //插入
    public boolean insert(int val){
        if(size == array.length){
            return false;
        }
        array[rear] = val;
        rear = (rear + 1)%array.length;
        size++;
        return true;
    }

    //删除
    public boolean delete(int val){
        if(size == 0){
            return false;
        }
        front = (front + 1)%array.length;
        size--;
        return true;
    }

    //返回队首元素
    public int getFront(){
        if(size == 0){
            return -1;
        }
        return array[front];
    }

    //返回队尾元素
    public int getRear(){
        if(size == 0){
            return -1;
        }
        return array[(array.length+rear-1)%array.length];
    }

    //判空
    public boolean isEmpty(){
        return size == 0;
    }

    //判满
    public boolean isFull(){
        return size == array.length;
    }



}
