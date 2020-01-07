public class MyQueue2 {

    private int[] array = new int[2];
    private volatile int size;
    private int front;
    private int rear;

    private Object full = new Object ();
    private Object empty = new Object ();

    //不在方法上加锁是因为如果当前对象进入等待集，他释放的只是full锁，带着this锁进入等待集，别人再也请求不到this锁，造成死锁，将锁细粒度化

    public void put(int message) throws InterruptedException {
        //while的作用：
        //因为大的框架没有加锁，消费者之间无法互斥
        //比如现在就绪队列中有一个生产者，一个消费者
        //现在生产者生产了一个物品，它唤醒了一个消费者，此时唤醒的这个消费者进入就绪队列，俩个消费者争抢CPU
        //很遗憾的是抢到CPU的不是刚被唤醒的那个消费者，在CPU上的这个消费者消费物品，物品size变为0
        //这时先前被唤醒的消费者抢到CPU，它要做的是消费，但队列里的物品个数为0，如过它直接往下执行肯定出错，所以必须进行二次判断
        do {
            while (size == array.length) {
                synchronized (full) {
                    full.wait ();
                }
            }

        //原先：如果指向到这步，size一定是小于arr.length的
        //加锁是一个很漫长的过程，如果在这个过程中该线程没有抢占到CPU
        //而其他线程抢占，比如被生产者抢占，它生产物品导致size == array.length,就不能保证this还是我们之前判断的情况，所以要二次判断
        //所以要加dowhile，如果二次判断之后size==array.length;则回到程序最前面,该线程进入等待集
            synchronized (this) {
                if(size == array.length){
                    continue;
                }
                //判断之后不等于，则当前线程进行生产
                array[rear] = message;
                rear = (rear + 1) % array.length;
                size++;
            }

            synchronized (empty) {
                empty.notify ();//生产的达到了最多，唤醒empty等待集上的消费着
            }
            //唤醒一个消费者，退出循环，结束
            return;
        }while(true);
    }

    public int take() throws InterruptedException {
        do {
            while (size == 0) {
                synchronized (empty) {
                    empty.wait ();
                }
            }

            int message;
            //加锁是一个很漫长的过程，如果在这个过程中该线程没有抢占到CPU
            //而其他线程抢占，就不能保证this还是我们之前判断的情况，所以要二次判断
            synchronized (this) {
                if(size == 0){
                    continue;
                }
                message = array[front];
                front = (front + 1) % array.length;
                size--;
            }

            synchronized (full) {
                full.notify ();
            }
            return message;

        }while(true);
    }

}
