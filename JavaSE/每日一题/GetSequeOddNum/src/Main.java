import java.util.Scanner;

public class Main {

    //验证尼科彻斯定理：任意一个整数m的立方都可以写成m个连续的奇数值和
    //要求：输入：2 输出：3+5    输入：4 输出：13+15+17+19

    public static String getSequeOddNum(int n){

        //利用等差数列的公式求得第一个数字
        int x = n*n - n +1;
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = x;
            x += 2;
        }
        String res = "";
        for(int i = 0;i < n;i++){
            int num = arr[i];
            res = res + num +"+";
        }
        res = res.substring (0,res.length ()-1);
        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()) {
            int n = sc.nextInt ();

            System.out.println (getSequeOddNum (n));
        }
    }
}
