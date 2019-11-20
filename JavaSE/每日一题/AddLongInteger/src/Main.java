import java.util.Scanner;

public class Main {

    //实现俩个超长正整型的相加
    //我们将俩个字符串的倒序相加，模拟数字从各位开始相加，之后再将字符串反转

    public static String addLondInteger(String a,String b){
        String res = "";//保存相加的字符串
        String addend = "";//加数
        String augend = "";//被加数

        //将较长的字符串作为加数，较短的字符串作为被加数
        if(a.length () > b.length ()){
            addend = a;
            augend = b;
        }else{
            addend = b;
            augend = a;
        }

        //给被加数前面补0，直至和加数的长度相等
        int length = addend.length () - augend.length ();
        for(int i = 0; i< length;i++){
            augend = "0"+ augend;
        }

        int y = 0;//控制进位，如果两数相加结果大于等于10，将y置为1，反之为0
        for(int i = addend.length ()-1;i >= 0;i--){
            char add = addend.charAt(i);
            char aug = augend.charAt (i);
            int x = add-48 + aug-48;//转为十进制相加

            int r = x + y;//和上一位相加的结果的进位相加
            if(r >= 10){
                y = 1;
                res = String.valueOf (r % 10) + res;
            }else{
                y = 0;
                res = String.valueOf (r) + res;
            }

        }
        if(y==1) {//如果最高位相加后需要进位，则加一
            res = String.valueOf (y) + res;
        }

        return res;

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()) {

            String a = sc.nextLine ();
            String b = sc.nextLine ();

            System.out.println (addLondInteger (a, b));
        }
    }
}
