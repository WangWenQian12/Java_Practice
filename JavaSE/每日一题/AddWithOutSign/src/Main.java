import java.util.Scanner;

public class Main {

    //不用加号将两数相加

    public static int addWithOutSign(int a,int b){
        int sum = 0;
        int carry = 0;
        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        //当循环至y=0时，即进位为0，两数之和已经加至x上，所以返回x即可
        return a;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt ();
        int b = sc.nextInt ();
        System.out.println (addWithOutSign(a,b));
    }
}
