import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
//生产者发现队列满了阻塞，消费者发现队列空了阻塞

public class UseBlockingQueue {

    //阻塞队列

    public static BlockingQueue<String> queue = new ArrayBlockingQueue<> (1);
    //new LinkedBlockingDeque<>();
    //new PriorityBlockingQueue<>();

    //生产者
    private static class Producer extends Thread{
        @Override
        public void run() {
            Random random = new Random (20191117);
            while(true){
                //BlockingQueue继承自Queue，保留有Queue的一些方法，但offer是没有阻塞效果的，要添加必须要用put
                try {
                    //随机生成100以内的数字把它放到阻塞队列
                    int message = random.nextInt (100);
                    queue.put (String.valueOf (message));
                    System.out.println ("放入消息: " + message);
                    //大概休息1ms，2ms，3ms
                    Thread.sleep (random.nextInt (3)*100);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
    }


    //消费者
    private static class Customer extends Thread{
        @Override
        public void run() {
            Random random = new Random (20191117);
            while(true){
                try {
                    String message = queue.take ();
                    System.out.println ("收到消息: " + message);
                    Thread.sleep (random.nextInt (3)*100);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }

            }
        }
    }

    public static void main(String[] args) {
        Thread producer = new Producer ();
        Thread customer = new Customer ();
        producer.start ();
        customer.start ();
    }

}
