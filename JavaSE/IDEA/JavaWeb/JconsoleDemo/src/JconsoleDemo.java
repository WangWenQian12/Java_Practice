public class JconsoleDemo {

    private static Object object = new Object();

    private static class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (object){
                try {
                    Thread.sleep (1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread ();
        t.start ();
        Thread.sleep (10);//确保子线程先运行，把锁拿到

        synchronized (object){
            System.out.println ("success");//此时主线程被阻塞，因为子线程拿着锁去休眠了
        }
    }
}
