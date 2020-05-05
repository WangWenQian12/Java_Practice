import java.util.Scanner;

public class WaitDemo {

    private static Object object = new Object ();

    public static class A extends Thread{
        @Override
        public void run() {
            for(int i = 0;i < 10;i++){
                System.out.println (i);
            }

            //等待B线程启动，并且加锁
            synchronized (object){
                try{
                    object.wait ();
                }catch(InterruptedException e){
                    e.printStackTrace ();
                }
            }

            for(int i = 100;i < 110;i++){
                System.out.println (i);
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new A();
        a.start ();

        Scanner input = new Scanner (System.in);
        input.nextLine ();
        synchronized (object){
            object.notify ();
        }
    }
}
