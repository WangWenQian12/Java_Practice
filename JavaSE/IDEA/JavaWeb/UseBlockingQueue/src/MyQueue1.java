import java.util.Random;

public class MyQueue1 {

    private int[] array = new int[2];
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    //private Object empty = new Object ();//当前对象为空时等到empty的等待集上
    //private Object full = new Object ();//当前对象满时等到full的等待集上
    //此时消费者唤醒的一个是生产者，生产者唤醒的一定是消费者

    public synchronized void put(int message) throws InterruptedException {
        while(size == array.length){
            //while的作用：
            //假设CPU现在上是一个生产者，它发现队列已满，这个生产者进入等待集，且唤醒了等待集上所有的线程
            //这些被唤醒的线程回到就绪队列，一起争抢CPU和锁，假设这次是另外一个生产者抢到，此时队列是满的
            //所以当我被唤醒之后我还要判断一次我现在的队列是否是满的，如果是满的，我继续等待
            wait ();
        }

        array[rear] = message;
        rear = (rear + 1)% array.length;
        size++;
        notifyAll ();
    }

    public synchronized int take() throws InterruptedException {
        while(size == 0){
            wait ();
        }

        int message = array[front];
        front = (front + 1) % array.length;
        size--;
        notifyAll ();
        return message;
    }

    private static final MyQueue1 queue = new MyQueue1 ();

    private static class Producer extends Thread{
        @Override
        public void run() {
            Random random = new Random ();
            while(true){
                try {
                    int message = random.nextInt (100);
                    queue.put (message);
                    System.out.println ("放入消息:"+ message);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    private static class Customer extends Thread{
        @Override
        public void run() {
            while(true){
                try {
                    int message = queue.take();
                    System.out.println ("收到消息" + message);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread p1 = new Producer ();
        Thread p2 = new Producer ();
        Thread p3 = new Producer ();
        Thread c1 = new Customer ();
        Thread c2 = new Customer ();
        Thread c3 = new Customer ();
        Thread c4 = new Customer ();

        p1.start ();
        p2.start ();
        p3.start ();
        c1.start ();
        c2.start ();
        c3.start ();
        c4.start ();

    }
}
