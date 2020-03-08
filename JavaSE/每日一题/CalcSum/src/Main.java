import java.util.Scanner;

public class Main{

    // 输入一个数字，求它的各位之和 和 其平方的各位之和

    public static String calc(int n){
        String res = "";
        res += dightSum(n);
        res += " ";
        res += dightSum(n*n);
        return res;
    }

    public static String dightSum(int n){
        int res = 0;
        while(n > 0){
            res += n%10;
            n /= 10;
        }
        return String.valueOf (res);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(calc(n));
        }
    }
}