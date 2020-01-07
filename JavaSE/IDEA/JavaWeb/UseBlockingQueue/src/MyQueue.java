public class MyQueue {

    //阻塞队列
    //加俩把锁wait时释放的是当前锁，不是this锁

    private int[] array = new int[10];
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private Object empty = new Object ();//当前对象为空时等到empty的等待集上
    private Object full = new Object ();//当前对象满时等到full的等待集上
    //此时消费者唤醒的一个是生产者，生产者唤醒的一定是消费者

    public synchronized void put(int message) throws InterruptedException {
        //if(size == array.length){
            //加了俩把锁
            synchronized (full) {
                full.wait ();
          //  }
        }

        /*array[rear] = message;
        rear = (rear + 1)% array.length;
        size++;*/
    }

    private static final MyQueue queue = new MyQueue ();

    private static class MyThread extends Thread{
        @Override
        public void run() {
            try{
                queue.put (0);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread ();
        t.start ();
        Thread.sleep (100);

        //如果打印出来了说明put中的wait将this锁释放了,反之说明wait时释放的是full的锁
        synchronized (queue.full){
            System.out.println ("我加到锁了");
        }

    }

    //public synchronized void
}
