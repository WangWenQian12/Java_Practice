import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool1 {

    //固定线程池，一开始就申请好线程
    //需要多少个线程，我就提前起多少个线程
    //通过阻塞队列提交任务

    private BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<> (10);//工作队列（阻塞队列）

    private Thread[] workers = new Thread[5];//线程池最多有五个工作线程

    //启动线程
    MyThreadPool1(){
        for(int i = 0 ; i < 5;i++){
            workers[i] = new Worker (workQueue);
            workers[i].start ();
        }
    }

    //提交任务
    public void execute(Runnable cmd) throws InterruptedException {
        workQueue.put (cmd);
    }

    //调用stop，停止程序
    public void stop(){
        for(int i = 0; i < 5;i++){
            workers[i].interrupt ();
        }
    }

    //通过线程获取到整个工作队列
    private static class Worker extends Thread{
        private BlockingQueue<Runnable> workQueue;

        Worker(BlockingQueue<Runnable> queue){
            workQueue  = queue;
        }

        //只要线程没有中断，我就不断的从队列里取任务
        //取到后运行任务

        @Override
        public void run() {
            while(! isInterrupted ()){
                try {
                    Runnable cmd = workQueue.take();
                    cmd.run ();
                } catch (InterruptedException e) {
                    break;//如果中断，直接break，即停止所有线程
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool1 pool = new MyThreadPool1 ();
        pool.execute (new Runnable () {
            @Override
            public void run() {
                //while(true) {
                    System.out.println ("第一个任务");
                //}
            }
        });


       pool.execute (new Runnable () {
           @Override
           public void run() {
               //while(true) {
                   System.out.println ("第二个任务");
               //}
           }
       });

       pool.execute (new Runnable () {
           @Override
           public void run() {
               //while(true) {
                   System.out.println ("第三个任务");
               //}
           }
       });

       pool.execute (new Runnable () {
           @Override
           public void run() {
               //while(true) {
                   System.out.println ("第四个任务");
               //}
           }
       });

       //pool.stop ();

        pool.execute (new Runnable () {
            @Override
            public void run() {
                //while(true) {
                    System.out.println ("第五个任务");
                //}
            }
        });

        pool.execute (new Runnable () {
            @Override
            public void run() {
                //while(true) {
                    System.out.println ("第六个任务");
                //}
            }
        });

        pool.stop();
    }
}
