import java.util.Scanner;

public class Main{

    // 判断是否为 守形数，守形数是其平方的地位等于原来的数，比如 25 的平方 625，那么25就是守形数

    public static boolean isKeepShapeNum(int n){
        int m = n * n;
        String s1 = String.valueOf(n);
        String s2 = String.valueOf(m);
        String mantissa = "";
        for(int i = s2.length() - 1;i >= 0;i--){
            mantissa = s2.charAt(i) + mantissa;
            if(mantissa.equals (s1) ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(isKeepShapeNum(n));
        }

    }
}