public class test {

    private static class MyThread extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println ("method2中运行");
                //进程暂停1秒
                try{
                    Thread.sleep (1000);
                }catch(InterruptedException e){
                    e.printStackTrace ();
                }
            }
        }
    }

    private static void method2(){
        Thread thread = new MyThread ();
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
        method2 ();
        while(true){
            System.out.println ("main中打印");
            //暂停1秒
            Thread.sleep (1000);
        }
    }

    private static void method1() throws InterruptedException{
        while(true){
            System.out.println ("method1中打印");
            Thread.sleep (1000);
        }
    }
}
