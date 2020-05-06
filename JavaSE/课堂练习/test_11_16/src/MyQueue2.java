public class MyQueue2 {
    private int[] array = new int[2];
    private volatile int size;
    private int front;
    private int rear;

    private Object full = new Object();
    private Object empty = new Object();

    public void put(int message) throws InterruptedException {
        do {
            while (size == array.length) {
                synchronized (full) {
                    full.wait();
                }
            }


            // 这里保证，size 一定是 < array.length 的
            synchronized (this) {   // 持续时间很久
                if (size == array.length) {
                    continue;
                }
                //加锁是一个很漫长的过程，如果在这个过程中该线程没有抢占到CPU
                //而其他线程抢占，就不能保证this还是我门之前判断的情况，所以要二次判断
                array[rear] = message;
                rear = (rear + 1) % array.length;
                size++;
            }

            synchronized (empty) {
                empty.notify();
            }
            return;
        } while (true);
    }

    public synchronized int take() throws InterruptedException {
        do {
            while (size == 0) {
                synchronized (empty) {
                    empty.wait();
                }
            }

            int message;
            synchronized (this) {   // 这句代码可能会执行很长时间
                if (size == 0) {
                    continue;
                }
                message = array[front];
                front = (front + 1) % array.length;
                size--;
            }

            synchronized (full) {
                full.notify();
            }

            return message;
        } while (true);
    }
}
