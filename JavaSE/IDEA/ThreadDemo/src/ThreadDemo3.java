import java.util.Scanner;

public class ThreadDemo3{
    private static class FibThread2 extends Thread{
        private int n;
        FibThread2(int n){
            this.n = n;
        }

        @Override
        public void run() {
            long result = Fib.calc (n);
            System.out.printf ("%nfib(%d) = %d%n",n,result);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner (System.in);
        while(true){
            System.out.println ("请输入数字：");
            int n = input.nextInt ();
            Thread thread = new FibThread2 (n);
            System.out.print ("计算中");
            thread.start ();
            while(thread.isAlive ()){
                Thread.sleep (1000);
            }
        }
    }


}
