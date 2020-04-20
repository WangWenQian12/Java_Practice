import java.util.*;

public class Main{

    // 将 C语言 的命名方式改为 Java 的命名方式 ，如：hello_World -> helloWorld

    public static String translate(String str){
        String res = "";
        int i = 0;
        while(i < str.length()){
            if(str.charAt(i) == '_'){
                char c = str.charAt (++i);
                res += (char)(c - 32);
                i++;
            }else{
                res += str.charAt(i++);
            }
        }
        return res;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(translate(str));
        }
    }
}

