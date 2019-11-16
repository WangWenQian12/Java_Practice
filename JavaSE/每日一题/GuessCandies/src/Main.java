import java.util.Scanner;

public class Main {

    //A、B、C三个人是好朋友，每个人手里都有一些结果，但具体有多少不知道
    //已知 A-B,B-C,A+B,B+C这四个数值，每个字代表每个人的糖果数，求A,B,C的具体数字

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int sum1 = input.nextInt ();
        int sum2 = input.nextInt ();
        int sum3 = input.nextInt ();
        int sum4 = input.nextInt ();

        //根据题目将四个方程式联立
        int A = (sum1 + sum3)/2;
        int B = (sum2 + sum4)/2;
        int C = sum4 - B;

        if(A - B == sum1 && B - C == sum2 && A + B == sum3 && B + C == sum4 ){
            System.out.println (A + " " + B + " " + C );
        }else{
            System.out.println ("No");
        }

    }
}
