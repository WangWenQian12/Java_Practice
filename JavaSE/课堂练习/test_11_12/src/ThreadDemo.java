import java.util.Scanner;

class Fib{
    public static long calc(int n){
        if(n==0 || n==1){
            return 1;
        }else{
            return calc (n-1) + calc (n-2);
        }
    }
}

class FibThread extends Thread{
    private int n;
    FibThread(int n){
        this.n = n;
    }

    @Override
    public void run() {
        long result = Fib.calc (n);
        System.out.printf ("第%d项斐波那契数为：%d%n",n,result);
    }
}

public class ThreadDemo {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println ("你要算第几项？");
            int n = input.nextInt();
            Thread thread = new FibThread (n);
            thread.start ();
        }
    }


}
