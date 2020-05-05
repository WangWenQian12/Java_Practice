public class CreateThread {

    private static class MyThread extends Thread{
        private int n = 0;

        @Override
        public void run() {
            while(n < 10){
                System.out.println (n);
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace ();
                }
                n++;
            }
        }
    }

    private static class ShareResource{
        public int n = 0;
    }

    private static class MyThread1 extends Thread{
        private ShareResource resource;

        MyThread1(ShareResource resource){
            this.resource = resource;
        }

        @Override
        public void run() {
            while(resource.n < 10){
                System.out.println (resource.n);
                try{
                    Thread.sleep (500);
                }catch(InterruptedException e){
                    e.printStackTrace ();
                }
                resource.n++;
            }

        }
    }

    public static void main(String[] args) {
        /*Thread t1 = new MyThread ();
        Thread t2 = new MyThread ();
        */

        /*Thread t1 = new Thread (new MyThread ());
        Thread t2 = new Thread (new MyThread ());
        */

        /*MyThread runnable  = new MyThread ();
        Thread t1 = new Thread (runnable);
        Thread t2 = new Thread (runnable);
        */

        ShareResource resource  = new ShareResource ();
        Thread t1 = new MyThread1 (resource);
        Thread t2 = new MyThread1 (resource);
        t1.start ();
        t2.start ();
    }
}
