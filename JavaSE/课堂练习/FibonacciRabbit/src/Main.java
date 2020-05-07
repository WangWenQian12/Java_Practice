import java.util.Scanner;

public class Main {

    //统计每个月兔子的总数
    //有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？

    //本质为斐波那契数列


    public static int sumRabbit(int n){
        if( n==1 || n==2 ){
            return 1;
        }
        int f = 0;
        int f1 = 1;
        int f2 = 1;
        for(int i = 3;i <= n;i++){
            f = f1+f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }

    public static int sumRabbit2(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return sumRabbit2 (n-1)+sumRabbit2 (n-2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()) {
            int n = sc.nextInt ();
            System.out.println (sumRabbit2 (n));
        }
    }
}
