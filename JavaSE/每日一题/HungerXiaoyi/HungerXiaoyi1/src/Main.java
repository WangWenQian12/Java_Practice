import java.util.Scanner;

public class Main {

    //饥饿的小易

    static public long x = 0;
    static public long N = 1000_000_007;
    static public long count = -1;
    static public long times = 4;

    public static void hunger(){
        for(int i = 1;i < 300000;i++){
            long mod = (times * (x + 1) - 1) % N;
            if(mod == 0){
                count = (i + 1)/3 + ((i + 1)%3 == 0 ? 0 :1);
                return;
            }
            times = (times * 2) % N;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        x = sc.nextInt ();
        hunger();
        System.out.println (count);
    }
}
