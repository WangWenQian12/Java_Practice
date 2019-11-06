public class JoinDemo {

    private static class MyThread extends Thread {
        @Override
        public void run() {
            while(true){

            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new MyThread();
        t1.start ();
        System.out.println (System.currentTimeMillis ());
        t1.join(2000);//等你俩秒
        System.out.println (System.currentTimeMillis ());
    }
}
