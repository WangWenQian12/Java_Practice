import java.util.concurrent.PriorityBlockingQueue;

public class MyTimer {

    PriorityBlockingQueue<MyTimerTask> queue = new PriorityBlockingQueue<> ();
    Worker worker;

    private static class Worker extends Thread{
        PriorityBlockingQueue<MyTimerTask> queue;

        Worker(PriorityBlockingQueue<MyTimerTask> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while(true){
                try{
                    MyTimerTask task = queue.take ();
                    long current = System.currentTimeMillis ();

                    //在时间之内
                    if(task.delay <= current){
                        task.target.run ();
                    }else{
                        //不在时间内，把取出来的任务放进去，休眠
                        queue.put (task);
                        Thread.sleep (task.delay - current);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    //一调用当前类，就会启动该构造方法，开始执行线程
    MyTimer(){
        worker = new Worker (queue);
        worker.start ();
    }

    //把需要执行的任务放进队列里
    void execute(Runnable target,long delay){
        queue.put (new MyTimerTask (target,delay));
    }

    public static void main(String[] args) {
        MyTimer timer = new MyTimer ();
        //把任务放进队列里
        timer.execute (new Runnable () {
            @Override
            public void run() {
                System.out.println ("该起床了");
            }
        },2000);

        System.out.println ("另一个人");
    }
}
