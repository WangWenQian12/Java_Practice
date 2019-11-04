//通过多线程来调用方法计算斐波那契数列

//利用递归计算斐波那契数的第n项，当n足够大时，需要很长的时间
//通过多线程，当某一线程需要很久的时间时，其他线程也无需等待，是相互独立的

import java.util.Scanner;

class Fib{
    public static long calc(int n){
        if(n == 0 || n == 1){
            return 1;
        }else{
            return calc(n-1) + calc (n-2);
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

public class ThreadDemo2  {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println ("你要计算第几项？");
            int n = input.nextInt ();
            Thread thread = new FibThread (n);
            thread.start ();
        }
    }

}
