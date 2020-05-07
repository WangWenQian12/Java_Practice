import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //输入的字符串全为转译过的大写字母，转移规则：封面别用该字母后的第五个字母替换，现求原字符串

//    密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
//    原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U

    public static char[] deCode(String str){
        char[] arr = new char[str.length ()];
        for(int i = 0; i < str.length ();i++){
            char c = str.charAt (i);
            if(c >= 'F' && c <= 'Z' ){
                int n = (int)c -5;
                arr[i] = (char)((int)c - 5);
            }else if(c >= 'A' && c <= 'E'){
                arr[i] = (char)((int)c + 21);
            }else{
                arr[i] = ' ';
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()){
            String str = sc.nextLine ();
            char[] res = deCode (str);
            for(int i = 0;i < res.length;i++) {
                System.out.print (res[i]);
            }
        }
    }
}
