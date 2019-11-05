public class ThreadDemo1 {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println ("我在method2中打印");
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


    public static void main(String[] args) throws InterruptedException{
        //只会死循环执行method1，main中的打印语句不会执行
        //method1();

        //俩个死循环可以同时执行，没有一个卡住另一个的情况
        method2 ();
        while(true){
            System.out.println ("我在main中打印");
            //进程会暂停运行1秒
            Thread.sleep (1000);
        }
    }

    private static void method1() throws InterruptedException{
        while(true){
            System.out.println ("我在method1中打印");
            //进程会暂停运行1秒
            Thread.sleep (1000);
        }
    }


}
