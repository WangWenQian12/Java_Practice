import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool2 {

    //提前不启动线程，来了任务再启动线程，最多启动固定好的线程数
    //懒加载

    private BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<> (10);
    private int maxThreads = 5;//最大线程数
    private int currentThreads = 0;//目前启动的线程数为0个
    private Thread[] works = new Thread[maxThreads];//线程池


    //没有共享，不需要考虑线程安全
    public void execute(Runnable cmd) throws InterruptedException {
        if(currentThreads == maxThreads) {//达到了最大线程数，将该线程放进队列中
            workQueue.put (cmd);
        }else{//还没达到最大线程数，放进队列并启动该线程
            Worker worker = new Worker (workQueue);
            works[currentThreads++] = worker;
            worker.start ();
            workQueue.put (cmd);
        }
    }

    //调用stop，停止程序
    public void stop(){
        for(int i = 0; i < 5;i++){
            works[i].interrupt ();
        }
    }

    //通过线程获取到整个工作队列
    //从队列中去任务
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

        pool.stop ();

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
