public class CreateThread1 {
    private static class MyThread1 extends Thread{
        @Override
        public void run() {
            //让该线程去做的事情
        }
    }

    //通过实现 Runnable 接口，并且调用 Thread 的构造方法时将 Runnable 对象作为 target 参数传入来创建线程对象。
    //该方法的好处是可以规避类的单继承的限制；但需要通过 Thread.currentThread() 来获取当前线程的引用。
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            //让该线程去做的事情
        }
    }

    public static void main(String[] args) {
        //创建好了Thread的对象，描述
        Thread thread1 = new MyThread1 ();
        Thread thread2 = new Thread (new MyRunnable ());
        Thread thread3 = new Thread(new MyThread1 ());

        //启动线程
        thread1.start ();
        thread2.start ();
        thread3.start ();

        //常见的方法——继承Thread（匿名类/lambda）
        Thread thread4 = new Thread (){
            @Override
            public void run() {
                //覆写run方法的代码
            }
        };

        //常见的方法——继承Runnale（匿名类/lambda）
        Thread thread5 = new Thread (new Runnable () {
            @Override
            public void run() {
                //覆写run方法的内容
            }
        });

        Thread thread6 = new Thread (()->{
           //覆写run方法的代码
        });

    }


}
