import java.util.Scanner;

public class Mian {

    //输入一个整数，将这个数字以字符串的形式逆序输出（不考虑正负）

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        //字符串形式接收输入数字
        String num = sc.nextLine ();

        StringBuffer s = new StringBuffer (num);
        s.reverse ();

        System.out.println (s);
    }

}
