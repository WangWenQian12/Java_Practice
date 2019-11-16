import java.util.Scanner;

public class Main {

    //求俩个数的最小公倍数
    //思路：
    //1.a * b = lcm * gcd
    //2.在最大公约数的基础上求得

    //求最大公约数
    public static int gcd(int a,int b){
        if(b == 0){
            return a;
        }else{
            return gcd (b,a % b);
        }
    }

    //求最大公倍数
    public static int lcm(int a,int b){
        int tmp = gcd (a,b);
        return (a * b)/tmp;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int a = input.nextInt ();
        int b = input.nextInt ();
        System.out.println (lcm(a,b));
    }
}
