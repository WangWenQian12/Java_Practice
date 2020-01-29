import java.util.Scanner;

public class ToLowerCase {

    //该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串

    public static String toLowerCase(String str){
        String s = "";
        for(int i = 0;i < str.length ();i++){
            if(str.charAt (i) <= 'Z' && str.charAt (i) >= 'A'){
                char c = str.charAt (i);
                s += (char)(c+32);
            }else{
                s += str.charAt (i);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine ();
        //System.out.println (str.toLowerCase ());
        System.out.println (toLowerCase(str));
    }
}
