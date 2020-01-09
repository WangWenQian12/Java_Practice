import java.util.TimerTask;

class MyTimer1{
    public void execute(Runnable task,long delay) {
        //方法不好，因为每要执行一个任务就要开辟一个线程，所以我们把任务带着时间放到一个优先级队列中
        new Thread (new Runnable () {//创建一个新的线程
            @Override
            public void run() {
                try {
                    Thread.sleep (delay);//先休眠
                    task.run ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }).start ();
    }

}

public class UseTimer {

    //类闹钟

    private static class MyTimerTask extends TimerTask{
        @Override
        public void run() {
            System.out.println ("该起床了");
        }
    }

    public static void main(String[] args) {
        //Timer timer = new Timer ();
        //timer.schedule (new MyTimerTask (),1000);//先打印我是另一个人，再打印该起床了
        //System.out.println ("我是另一个人");

        MyTimer timer = new MyTimer ();
        timer.execute (new Runnable () {
            //匿名类
            @Override
            public void run() {
                System.out.println ("该起床了");
            }
        },1000);

        System.out.println ("我是另一个人");

    }

}
