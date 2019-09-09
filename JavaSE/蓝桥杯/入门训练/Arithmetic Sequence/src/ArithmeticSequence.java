import java.util.Scanner;

public class ArithmeticSequence {

    //求1+2+3+...+n的值。
    //注意：
    //1.当n很大时，输出的结果不再int范围内
    //2.int到long类型需要转换

    public static long getSum(int n){
        long sum=0;
        sum = (((long)n+1)*(long)n)/2;
        return sum;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(getSum(n));
    }

}
